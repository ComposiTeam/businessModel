#!/bin/bash

sudo docker stop mysqldb
sudo docker rm mysqldb
sudo docker run --name mysqldb -d -t -i -e MYSQL_ROOT_PASSWORD=root mysql:5.5
ipAddress=$(sudo docker inspect mysqldb | grep "IPAddress" | cut -d"\"" -f4)
echo $ipAddress
commandMy="mysql -h $ipAddress -P 3306 -u root -proot"
echo $commandMy
sleep 30
mysql -h $ipAddress -P 3306 -u root -proot < "database.sql"
