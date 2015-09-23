#!/bin/bash

sudo docker stop mysqldb
sudo docker rm mysqldb
sudo docker run --name mysqldb -d -t -i -e MYSQL_ROOT_PASSWORD=root mysql:5.5
ipAddress=$(sudo docker inspect mysqldb | grep "IPAddress" | cut -d"\"" -f4)
echo $ipAddress
oldIPAddress=$( grep "gradplannerBD" /etc/hosts | cut -d" " -f1)
echo $oldIPAddress
sed s/$oldIPAddress/$ipAddress/ < /etc/hosts > /etc/hosts.tmp
mv /etc/hosts.tmp /etc/hosts
sleep 15
mysql -h $ipAddress -P 3306 -u root -proot < "database.sql"
