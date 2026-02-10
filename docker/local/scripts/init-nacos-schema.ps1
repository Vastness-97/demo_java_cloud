param(
    [string]$MysqlContainer = "mysql-dev",
    [string]$NacosContainer = "nacos-dev",
    [string]$MysqlRootPassword = "root123",
    [string]$Database = "nacos_config"
)

$ErrorActionPreference = "Stop"

$schemaFile = Join-Path $PSScriptRoot "nacos-mysql-schema.sql"

Write-Host "Exporting Nacos MySQL schema from container: $NacosContainer"
docker cp "${NacosContainer}:/home/nacos/conf/mysql-schema.sql" $schemaFile

Write-Host "Importing schema into MySQL: $MysqlContainer / DB: $Database"
Get-Content $schemaFile | docker exec -i $MysqlContainer mysql -uroot -p$MysqlRootPassword $Database

Write-Host "Done. You can restart nacos-dev if it was failing before schema import."

