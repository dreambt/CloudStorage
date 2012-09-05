@echo off
echo Please download the yuicompressor from http://yuilibrary.com/downloads/yuicompressor and put the jar file here.

echo Compressing.... static\style\main.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\style\main.min.css ..\src\main\webapp\static\style\main.css

echo Compressing.... static\js\main.js
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\main.min.js ..\src\main\webapp\static\js\main.js

echo Compressing.... FancyBox
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\fancyBox\jquery.fancybox.css ..\src\main\webapp\static\js\fancyBox\jquery.fancybox.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-buttons.css ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-buttons.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-buttons.js ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-buttons.js
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-media.js ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-media.js
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-thumbs.css ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-thumbs.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-thumbs.js ..\src\main\webapp\static\js\fancyBox\helpers\jquery.fancybox-thumbs.js

echo Compressing.... FileTree
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\filetree\jquery.treeview.async.js ..\src\main\webapp\static\js\filetree\jquery.treeview.async.js
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\filetree\jquery.treeview.css ..\src\main\webapp\static\js\filetree\jquery.treeview.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\filetree\jquery.treeview.edit.js ..\src\main\webapp\static\js\filetree\jquery.treeview.edit.js
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\filetree\jquery.treeview.js ..\src\main\webapp\static\js\filetree\jquery.treeview.js
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\js\filetree\jquery.treeview.sortable.js ..\src\main\webapp\static\js\filetree\jquery.treeview.sortable.js

echo Compressing.... static\jquery-validation/1.9.0/validate.css
java -jar yuicompressor-2.4.7.jar -o ..\src\main\webapp\static\jquery-validation/1.9.0/validate.min.css ..\src\main\webapp\static\jquery-validation/1.9.0/validate.css

pause