Set-PSDebug -Trace 1
Write-Host "Building app started!"

#This is current dirctory
Set-Location $PSScriptRoot

# Build aar
./build_aar.ps1

Set-Location $PSScriptRoot

# Switching to server root
cd..
cd client/

./gradlew assembleRelease