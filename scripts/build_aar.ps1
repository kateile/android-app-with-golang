Write-Host "Building aar started!"

#This is current dirctory
Set-Location $PSScriptRoot

# Switching to server root
cd..
cd server/

#Installing go and build
go install golang.org/x/mobile/cmd/gomobile@latest
go install golang.org/x/mobile/cmd/gobind@latest
go get golang.org/x/mobile/cmd/gobind
go get golang.org/x/mobile/cmd/gomobile
gomobile init

gomobile bind -v -o ../client/app/libs/server.aar -target=android  -ldflags="-s -w" ./lib

Write-Host "Done build aar!"