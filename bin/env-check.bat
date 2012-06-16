@echo off
rem 请根据实际情况修改：

SET JAVA_HOME=C:\Program Files\Java\jdk1.6.0_31
SET M2_HOME=D:\java\tools\maven-3.0.3
SET ANT_HOME=D:\java\tools\ant-1.8.2

rem ########## check JAVA_HOME #############
wmic ENVIRONMENT where "name='JAVA_HOME'" delete
wmic ENVIRONMENT create name="JAVA_HOME",username="<system>",VariableValue="%JAVA_HOME%"

rem ########## check M2_HOME ###############
wmic ENVIRONMENT where "name='M2_HOME'" delete
wmic ENVIRONMENT create name="M2_HOME",username="<system>",VariableValue="%M2_HOME%"

rem ########## check ANT_HOME ##############
wmic ENVIRONMENT where "name='ANT_HOME'" delete
wmic ENVIRONMENT create name="ANT_HOME",username="<system>",VariableValue="%ANT_HOME%"

set PATH_STR=<nul
echo %PATH%| find "M2_HOME" || set PATH_STR=%%M2_HOME%%\bin;%PATH_STR%
echo %PATH%| find "ANT_HOME" || set PATH_STR=%%ANT_HOME%%\bin;%PATH_STR%
echo %PATH%| find "JAVA_HOME" || set PATH_STR=.;%%JAVA_HOME%%\bin;%PATH_STR%

if %PATH_STR%=="" pause>nul&exit/b

wmic ENVIRONMENT where "name='path' and username='<system>'" set VariableValue="%PATH_STR%;%PATH%"

@echo on