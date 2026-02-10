# 技术选型说明

## 1. 选型清单

- `Spring Boot`：应用开发基础框架
- `Spring Cloud Alibaba`：微服务治理能力（注册发现、配置中心、熔断限流等可按阶段接入）
- `MyBatis-Plus`：持久层开发与 CRUD 增强
- `HikariCP`：数据库连接池
- `Redis`：缓存与高频数据访问支撑

## 2. 模块落位原则

- `platform/platform-datasource`
  - 管理 `MyBatis-Plus`、数据源、连接池、数据库通用配置
  - 沉淀分页、拦截器、审计字段等公共能力
- `platform/platform-redis`
  - 管理 Redis 依赖与序列化、缓存模板等通用配置
- `platform_services/*`
  - 按需依赖基础模块，聚焦业务逻辑

## 3. 依赖管理原则

- 版本统一在根 `pom.xml` 的 `dependencyManagement` 管理
- 业务模块尽量不显式写版本号
- 先保证“全服务一致”，再做个别服务差异化调优

## 4. 当前阶段建议

- 先完成最小可运行链路（网关 + 认证 + user-service）
- 再逐步接入更多治理能力（如配置中心、限流、链路追踪等）
- 避免过早抽象独立 starter，先在 `platform` 层稳定能力

## 5. 环境分层（企业常见）

- `本地开发`：使用 `docker/local/docker-compose.yml` 统一 MySQL/Redis/Nacos 版本与端口
- `测试/预发`：使用共享环境（通常 K8s），配置通过 Nacos 管理
- `生产`：中间件使用托管服务或运维集群，应用侧只消费连接信息与配置
