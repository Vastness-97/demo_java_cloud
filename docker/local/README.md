# 本地中间件环境（MySQL + Redis + Nacos）

该目录用于团队本地开发环境，不用于测试/生产。

## 1. 启动前准备

1. 复制环境变量模板：

```powershell
cd docker/local
Copy-Item .env.example .env
```

2. 按需修改 `.env`（端口、密码）。
3. `NACOS_AUTH_TOKEN` 必须为 Base64 且解码后长度不少于 32 字节。

## 2. 启动

```powershell
cd docker/local
docker compose up -d
docker compose ps
```

## 3. 初始化 Nacos 数据库表结构

首次启动时，Nacos 连接 MySQL 需要官方表结构。

```powershell
cd docker/local/scripts
powershell -ExecutionPolicy Bypass -File .\init-nacos-schema.ps1
```

执行完成后，重启 Nacos：

```powershell
cd ..
docker compose restart nacos
```

## 4. 访问与连接信息

- MySQL: `localhost:${MYSQL_PORT}`（默认 3306）
- Redis: `localhost:${REDIS_PORT}`（默认 6379）
- Nacos: `http://localhost:${NACOS_HTTP_PORT}/nacos`（默认 8848）

## 5. 常用命令

```powershell
# 查看日志
docker compose logs -f nacos

# 停止
docker compose down

# 停止并删除数据卷（谨慎）
docker compose down -v
```
