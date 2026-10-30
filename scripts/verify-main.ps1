$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $PSScriptRoot
$bin = Join-Path $root "out"
Remove-Item $bin -Recurse -Force -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Path $bin | Out-Null

$files = Get-ChildItem (Join-Path $root "src/main/java") -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -d $bin $files
Write-Host "Main source compiled successfully." -ForegroundColor Green
