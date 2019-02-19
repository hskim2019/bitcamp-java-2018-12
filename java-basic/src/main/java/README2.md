# src/main/java

# database

==========1. 수퍼관리자로 서버 접속==========
bitcamp@bitcamp7:~$ sudo mysql -u root -p
Enter password: (1111)
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 33
Server version: 10.1.38-MariaDB-0ubuntu0.18.04.1 Ubuntu 18.04

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> show databases
    -> show databases;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'show databases' at line 2
MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
+--------------------+
3 rows in set (0.02 sec)


=========2. MySQL 사용자 추가=============
MariaDB [(none)]> CREATE USER 'bitcamp'@'localhost' IDENTIFIED BY '1111';
Query OK, 0 rows affected (0.00 sec)


========3. MySQL 사용자 목록 조회=============
MariaDB [(none)]> select user, host from mysql.user;
+---------+-----------+
| user    | host      |
+---------+-----------+
| bitcamp | localhost |
| root    | localhost |
+---------+-----------+
2 rows in set (0.00 sec)



=======4. MySQL 데이터베이스 생성==============
MariaDB [(none)]> CREATE DATABASE bitcampdb
    -> CHARACTER SET utf8
    -> COLLATE utf8_general_ci;
Query OK, 1 row affected (0.00 sec)


=======5. MySQL 사용자에게 데이터베이스 사용 권한 부여================
MariaDB [(none)]> GRANT ALL ON bitcampdb.* TO 'bitcamp'@'localhost';
Query OK, 0 rows affected (0.00 sec)


=======6. 나가서 사용자 교체 후 서버 접속=============
MariaDB [(none)]> quit
Bye



bitcamp@bitcamp7:~$ mysql -u bitcamp -p
Enter password: 
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 34
Server version: 10.1.38-MariaDB-0ubuntu0.18.04.1 Ubuntu 18.04

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.



======== data base 조회해보기============
MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| bitcampdb          |
| information_schema |
+--------------------+
2 rows in set (0.00 sec)

==========기본으로 사용할 데이터베이스 지정하기==============
MariaDB [(none)]> use bitcampdb;
Database changed
MariaDB [bitcampdb]> show tables;
Empty set (0.00 sec)


======= 사용자 삭제========
DROP USER '계정'@'접속대역';

===== database 삭제========
DROP DATABASE [ 데이터베이스 이름 ] ; 
