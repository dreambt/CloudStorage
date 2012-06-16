@echo off
echo [INFO] Init dependency: net.sourceforge.pinyin4j.

set path=D:\.m2\repository\com\aliyun\aliyun-openservices\0.0.1


cd %~dp0
rem call ant checksum
mkdir %path%
copy aliyun-openservices* %path%

pause