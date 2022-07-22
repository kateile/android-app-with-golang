Set-PSDebug -Trace 1
Write-Host "Building aar started!"

#This is current dirctory
Set-Location $PSScriptRoot

# Switching to server root
cd..

$root = Get-Location
Write-Host "root: $root"

$output =  "$root\client\app\libs"
Write-Host "output dir: $output"

$file =  "$output\server.aar"
Write-Host "output file: $file"

cd server
Write-Host "switched to server dir: $(Get-Location)"

#Installing go and build
go install golang.org/x/mobile/cmd/gomobile@latest
go install golang.org/x/mobile/cmd/gobind@latest
go get golang.org/x/mobile/cmd/gobind
go get golang.org/x/mobile/cmd/gomobile
gomobile init

gomobile bind -v -o $file -target=android  -ldflags="-s -w" ./lib

Write-Host "Done build aar!"