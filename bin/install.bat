@echo off
echo [INFO] run install.

cd %~dp0
cd ..

set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m
call mvn clean install -Dmaven.test.skip=true

cd bin
pause