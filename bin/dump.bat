"D:\Program Files\xampp\mysql\bin\mysqldump" -h 192.168.1.224 -udev -pdev --default-character-set=utf8 --opt --extended-insert=false --triggers -R --hex-blob --single-transaction --max_allowed_packet=104857600 --net_buffer_length=16384 ct_cloud_dev > ct_cloud_dev.sql
"D:\Program Files\xampp\mysql\bin\mysqldump" -h 192.168.1.224 -udev -pdev --default-character-set=utf8 --opt --extended-insert=false --triggers -R --hex-blob --single-transaction --max_allowed_packet=104857600 --net_buffer_length=16384 ct_website_dev > ct_website_dev.sql