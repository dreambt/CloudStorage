@echo off
echo Please download the yuicompressor from http://yuilibrary.com/downloads/yuicompressor and put the jar file here.

echo Compressing.... static\main.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\main.min.css ..\src\main\webapp\static\main.css

echo Compressing.... static\jquery-validation/1.9.0/validate.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\jquery-validation/1.9.0/validate.min.css ..\src\main\webapp\static\jquery-validation/1.9.0/validate.css

pause