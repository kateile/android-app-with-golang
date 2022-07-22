Write-Host "Building app started!"

#This is current dirctory
Set-Location $PSScriptRoot

./build_aar.ps1

# Switching to server root
cd..
cd client/

./gradlew assembleRelease