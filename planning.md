# 项目计划（planning）

## 1. 项目目标

- 构建基于 Java 17 + Maven 的多模块微服务基础工程。
- 完成平台公共能力、接口契约、网关鉴权、业务服务四层拆分。
- 建立统一的开发规范、接口规范、Git 流程与数据库规范。

## 2. 当前模块结构

- `platform`
  - `platform-common`
  - `platform-web`
  - `platform-security`
  - `platform-tenant`
  - `platform-datasource`
  - `platform-redis`
  - `platform-feign`
  - `platform-tracing`
- `platform_api`
  - `api-user`
  - `api-order`
  - `api-pay`
  - `api-message`
- `platform_gateway`
- `platform_auth`
- `platform_services`
  - `user-service`
  - `order-service`
  - `pay-service`
  - `message-service`
  - `file-service`

## 3. 已完成事项

- 完成 Maven 多模块骨架搭建。
- 完成 `platform_services` 下各服务的统一包结构创建：
  - `controller`
  - `dto.request`
  - `dto.response`（可选）
  - `service.impl`
  - `mapper`
  - `entity`
  - `config`
  - `constant`
  - `enums`
  - `exception`
  - `convert`
  - `client`
- 在空包目录中补充 `.gitkeep`，可正常提交目录结构。
- 完成项目文档建设（中文）：
  - `README.md`
  - `docs/architecture.md`
  - `docs/coding-standards.md`
  - `docs/api-conventions.md`
  - `docs/git-workflow.md`
  - `docs/db-conventions.md`

## 4. 进行中事项

- 梳理各服务最小可运行启动方案。
- 明确公共依赖版本与父 POM 统一管理策略。

## 5. 待办事项（优先级）

1. 为可运行模块补齐启动类与 `resources` 基础配置：
   - `platform_gateway`
   - `platform_auth`
   - `platform_services/*-service`
2. 统一父 POM 依赖管理：
   - Spring Boot
   - Spring Cloud
   - MyBatis（如采用）
   - 常用基础组件版本锁定
3. 建立统一返回与异常体系：
   - `Result<T>`
   - 全局异常处理
   - 业务错误码
4. 打通一个端到端最小业务链路（建议先 `user-service`）。
5. 补充基础测试与 CI 校验（编译、单测、规范检查）。

## 6. 里程碑建议

- M1（骨架可协作）：模块结构、包结构、文档规范全部就位。
- M2（服务可启动）：网关、认证、用户服务可本地启动联调。
- M3（链路可验证）：完成至少一条业务链路并具备基础测试。
- M4（工程化收敛）：完善 CI/CD、日志追踪、配置管理与发布流程。

## 7. 风险与关注点

- 当前多数模块仅有骨架，尚无业务代码，联调价值有限。
- 若不尽快统一依赖版本，后续模块会出现版本漂移。
- 若缺少统一错误码和返回规范，前后端联调成本会升高。

## 8. 决策记录

- 服务层包结构采用统一规范，便于团队协作与代码审查。
- 出参默认使用 `Result<VO>`，复杂场景再引入 `dto.response`。
- 空目录通过 `.gitkeep` 保留，确保仓库结构可被克隆复现。
- 技术选型确认：`Spring Boot`、`Spring Cloud Alibaba`、`MyBatis-Plus`、`HikariCP`、`Redis`。
- 技术落位确认：`MyBatis-Plus` 与连接池统一放在 `platform/platform-datasource`，`Redis` 统一放在 `platform/platform-redis`。

## 9. 变更记录

- 2026-02-10：初始化模块骨架、服务包结构、占位文件与中文规范文档。
