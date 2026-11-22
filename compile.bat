@echo off
cd /d "%~dp0"

if not exist bin mkdir bin

javac -encoding UTF-8 -d bin src\*.java

if %errorlevel% equ 0 (
    echo コンパイルが完了しました。
) else (
    echo コンパイルエラーが発生しました。
)

pause
