call runcrud
if "%ERRORLEVEL%" == "0" goto opera
echo.
echo RUNCRUD.BAT has error
goto fail

:opera
cd C:\Program Files\Opera
launcher.exe http://localhost:8080/crud/v1/task/getTasks
cd C:\programyJava\Development\Projects\Spring_WEB-REST_API
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished