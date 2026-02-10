# 编码规范

## 1. 包结构规范（`platform_services/*`）

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

## 2. 命名规范

- 类名：`PascalCase`
- 方法/字段：`camelCase`
- 常量：`UPPER_SNAKE_CASE`
- `DTO`：用于入参（`dto.request`）
- `VO`：用于 `Result<T>` 中的业务出参
- `xxxResponse`：仅用于复杂接口响应契约

## 3. Controller 规范

- Controller 只做参数接收、校验、协议转换
- 不在 Controller 中编写核心业务逻辑
- 返回值统一使用 `Result<T>`

## 4. Service 规范

- 业务逻辑放在 `service`/`service.impl`
- 事务边界定义在服务层
- 外部服务调用统一放在 `client` 包

## 5. Mapper / Entity 规范

- `mapper` 仅负责持久层访问
- `entity` 对应数据库实体
- SQL 需清晰可读，避免隐藏的 N+1 查询

## 6. 异常规范

- 业务异常放在 `exception` 包
- 全局异常处理统一转换为标准 `Result`
- 错误码集中定义并文档化

## 7. Convert 规范

- 对象转换逻辑统一放在 `convert`
- 可复用的转换逻辑不要散落在 Controller/Service 中
