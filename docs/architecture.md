# 架构说明

## 1. 分层模块设计

- `platform`：公共技术能力与基础组件
- `platform_api`：服务间 API 契约与共享接口模型
- `platform_gateway`：统一流量入口
- `platform_auth`：认证与授权
- `platform_services`：业务微服务

## 2. 服务边界

- `user-service`：用户域
- `order-service`：订单域
- `pay-service`：支付域
- `message-service`：消息通知域
- `file-service`：文件域

约束：

- 服务间调用通过 `platform_api` 中的契约完成
- 禁止跨服务直接访问数据库
- 公共能力沉淀到 `platform/*`，避免在服务中重复实现

## 3. 请求链路（目标）

客户端 -> 网关 -> 认证鉴权 -> 目标服务 -> DB/Redis/外部系统

## 4. 依赖规则

- `platform_services/*` 可依赖 `platform/*` 和 `platform_api/*`
- `platform_api/*` 不依赖具体服务实现
- `platform/*` 不依赖业务模块

## 5. 技术选型落位

- 数据访问相关（`MyBatis-Plus`、`HikariCP`、数据源）放在 `platform/platform-datasource`
- 缓存与 Redis 能力放在 `platform/platform-redis`
- 业务服务不重复堆叠底层中间件配置，按需依赖基础模块

## 6. 非功能基线

- 统一响应结构：`Result<T>`
- 统一异常处理与错误码体系
- 统一 TraceId 与结构化日志
- 明确远程调用超时与重试策略
