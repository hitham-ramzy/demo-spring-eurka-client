#!/bin/bash
echo this command is to drop and create new database you can use it to start a fresh installation
echo you need to enter mysql user password
mysql -uroot -p --execute='drop database if exists alten; create database alten DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci; '

## below statement is for creating a db user
# GRANT ALL ON alten.* TO 'user'@'localhost' IDENTIFIED BY 'pass';
# flush priveleges;
