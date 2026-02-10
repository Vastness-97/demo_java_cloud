# demo_java_cloud

基于 Java 17 + Maven 的多模块微服务脚手架项目。

## 1. 项目说明

项目按“平台能力、接口契约、网关鉴权、业务服务”进行分层组织：

- `platform`：公共基础能力模块
- `platform_api`：服务间 API 契约模块
- `platform_gateway`：网关服务
- `platform_auth`：认证鉴权服务
- `platform_services`：业务微服务模块

## 2. 技术选型

当前确认技术栈：

- `Spring Boot`
- `Spring Cloud Alibaba`
- `MyBatis-Plus`
- `HikariCP`
- `Redis`

模块落位约定：

- `MyBatis-Plus`、数据源、连接池相关配置放在 `platform/platform-datasource`
- `Redis` 相关依赖与通用配置放在 `platform/platform-redis`
- 业务服务模块按需依赖上述基础模块，不重复配置底层能力

## 3. 模块结构

```text
demo_java_cloud
├─ platform
│  ├─ platform-common
│  ├─ platform-web
│  ├─ platform-security
│  ├─ platform-tenant
│  ├─ platform-datasource
│  ├─ platform-redis
│  ├─ platform-feign
│  └─ platform-tracing
├─ platform_api
│  ├─ api-user
│  ├─ api-order
│  ├─ api-pay
│  └─ api-message
├─ platform_gateway
├─ platform_auth
└─ platform_services
   ├─ user-service
   ├─ order-service
   ├─ pay-service
   ├─ message-service
   └─ file-service
```

## 4. 服务包结构规范

`platform_services` 下每个服务使用统一分层：

```text
com.demo.<service>
├─ controller
├─ dto
│  ├─ request
│  └─ response（可选）
├─ service
│  └─ impl
├─ mapper
├─ entity
├─ config
├─ constant
├─ enums
├─ exception
├─ convert
└─ client
```

约定：

- 入参使用 `dto.request`
- 出参优先使用 `Result<VO>`
- 仅在复合返回场景使用 `dto.response`

## 5. 构建命令

根目录构建：

```bash
mvn clean install
```

构建单个模块（示例）：

```bash
mvn -pl platform_services/user-service -am clean package
```

## 6. 团队文档

- `docs/architecture.md`：架构说明
- `docs/tech-stack.md`：技术选型说明
- `docs/coding-standards.md`：编码规范
- `docs/api-conventions.md`：接口规范
- `docs/git-workflow.md`：Git 工作流规范
- `docs/db-conventions.md`：数据库规范

## 7. 本地中间件环境

本地开发统一使用 `docker/local` 目录中的标准环境编排：

- `MySQL`
- `Redis`
- `Nacos`

快速开始：

```powershell
cd docker/local
Copy-Item .env.example .env
docker compose up -d
```

详细步骤见：`docker/local/README.md`
