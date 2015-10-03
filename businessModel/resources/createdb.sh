#!/bin/bash
#variables
#set the container name
containerName="gradplannerBD"
rootPassword="root"
containerTag="5.5"
databaseSqlFile="database.sql"

#make sure that container will be a new container
sudo docker stop "$containerName"
sudo docker rm "$containerName"

#run the container
sudo docker run --name "$containerName" -d -t -i -e MYSQL_ROOT_PASSWORD="$rootPassword" mysql:"$containerTag"

#Getting the ip address of the container
ipAddress=$(sudo docker inspect "$containerName" | grep "IPAddress" | cut -d"\"" -f4)
echo $ipAddress

#Getting the old ip address in the hosts file (It wad done for ubuntu so It may need change for others distributions)
oldIPAddress=$( grep "gradplannerBD" /etc/hosts | cut -d" " -f1)
echo $oldIPAddress

#replacing the old ip for the new one
#sed does not allow to redirect the output for the same file
#so It is needed to create a tmp file
sed s/$oldIPAddress/$ipAddress/ < /etc/hosts > /etc/hosts.tmp
#replacing the host file 
mv /etc/hosts.tmp /etc/hosts

#time needed for docker set up the container
sleep 15
#creating the database
mysql -h $ipAddress -P 3306 -u root -proot < "$databaseSqlFile"
