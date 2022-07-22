Write-Host "Building aar started!"

#This is current dirctory
Set-Location $PSScriptRoot

# Switching to server root
cd..
cd server/

$content = 'Hello world! ' | out-file -filepath ../client/app/libs/nux.txt
Write-Host "Done build aar!"