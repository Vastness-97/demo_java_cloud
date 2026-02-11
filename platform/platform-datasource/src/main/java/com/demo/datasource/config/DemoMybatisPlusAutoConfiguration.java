package com.demo.datasource.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(MybatisPlusInterceptor.class)
public class DemoMybatisPlusAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 统一注册分页插件，避免各业务服务重复配置
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
        return this::applyGlobalDefaults;
    }

    private void applyGlobalDefaults(MybatisPlusProperties properties) {
        GlobalConfig globalConfig = properties.getGlobalConfig();
        if (globalConfig == null) {
            // 兜底创建全局配置，保证后续默认值可写入
            globalConfig = new GlobalConfig();
            properties.setGlobalConfig(globalConfig);
        }

        GlobalConfig.DbConfig dbConfig = globalConfig.getDbConfig();
        if (dbConfig == null) {
            // 兜底创建 DB 级配置
            dbConfig = new GlobalConfig.DbConfig();
            globalConfig.setDbConfig(dbConfig);
        }

        // 仅在业务侧未显式配置时设置默认值，避免覆盖业务定制
        if (dbConfig.getIdType() == null) {
            dbConfig.setIdType(IdType.ASSIGN_ID);
        }
        if (dbConfig.getLogicDeleteField() == null) {
            dbConfig.setLogicDeleteField("deleted");
        }
        if (dbConfig.getLogicDeleteValue() == null) {
            dbConfig.setLogicDeleteValue("1");
        }
        if (dbConfig.getLogicNotDeleteValue() == null) {
            dbConfig.setLogicNotDeleteValue("0");
        }
    }
}