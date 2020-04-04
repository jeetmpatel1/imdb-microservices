On widnows, Use below commands in Powershell to kill all the microservices.

Stop-Process -Id (Get-NetTCPConnection -LocalPort 8081).OwningProcess -Force
Stop-Process -Id (Get-NetTCPConnection -LocalPort 8082).OwningProcess -Force
Stop-Process -Id (Get-NetTCPConnection -LocalPort 8083).OwningProcess -Force
Stop-Process -Id (Get-NetTCPConnection -LocalPort 8761).OwningProcess -Force