@echo off
setlocal enabledelayedexpansion
cd /d "%~dp0"

:SELECT_SORT
echo 実行するソートを選択してください。
echo 1：マージソート
echo 2：クイックソート
set "SORT_TYPE="
set /p SORT_TYPE="番号を入力 (1 または 2)："

if "!SORT_TYPE!"=="1" (
    set "TARGET=MergeSort"
) else if "!SORT_TYPE!"=="2" (
    set "TARGET=QuickSort"
) else (
    echo 1 または 2 を入力してください。
    echo.
    goto SELECT_SORT
)

echo.

:SELECT_ORDER
echo 並び順を選択してください。
echo 1：昇順
echo 2：降順
set "ORDER="
set /p ORDER="番号を入力 (1 または 2)："

if not "!ORDER!"=="1" if not "!ORDER!"=="2" (
    echo 1 または 2 を入力してください。
    echo.
    goto SELECT_ORDER
)

echo.

:INPUT_NUMBERS
echo 数値を入力してください（空白区切りの数値、または１つの数値）：
set "INPUT_VAL="
set /p INPUT_VAL="数値文字列："

if not defined INPUT_VAL (
    echo 数値を入力してください
    echo.
    goto INPUT_NUMBERS
)

set INPUT_VAL| findstr /r "^INPUT_VAL=[-0123456789+ ]*$" >nul
if errorlevel 1 (
    echo 数値、半角スペース以外の文字が含まれています
    echo.
    goto INPUT_NUMBERS
)

set "COUNT=0"
set "ERR="
set "OVER="
for %%A in (!INPUT_VAL!) do (
    set /a COUNT+=1
    set "TOKEN=%%A"
    echo(!TOKEN!| findstr /r "^[+-][0123456789][0123456789]*$ ^[0123456789][0123456789]*$" >nul || set "ERR=1"
    if not "!TOKEN:~9,1!"=="" set "OVER=1"
)

if !COUNT! equ 0 (
    echo 数値を入力してください
    echo.
    goto INPUT_NUMBERS
)

if defined ERR (
    echo 数値の形式が正しくありません
    echo.
    goto INPUT_NUMBERS
)

if !COUNT! geq 2 if defined OVER (
    echo 空白区切りの場合は、符号を含めて9桁以内で入力してください。
    echo.
    goto INPUT_NUMBERS
)

set "CLEAN_NUM=!INPUT_VAL:+=!"

echo.
java -cp bin !TARGET! !ORDER! "!CLEAN_NUM!"

echo.
pause
