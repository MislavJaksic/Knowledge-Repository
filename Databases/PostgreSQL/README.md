## PostgreSQL

### [Installation](https://www.postgresql.org/download/)

Each operating system has a different way of installing PostgreSQL.  
As an example, PostgreSQL 10 will be installed on Ubuntu LTS 18.04.  

Use the following command to install PostgreSQL:
```
sudo apt-get install postgresql-10

Note: if you get an error "Could not get lock..." then just wait a few minutes for apt to finish or consult the web page below.
```
[Apt lock question on StackExchange](https://askubuntu.com/questions/15433/unable-to-lock-the-administration-directory-var-lib-dpkg-is-another-process/315791#315791)  

After installing PostgreSQL you should restart Ubuntu.  
Check if everything is installed correctly with the following command:
```
createdb <your_username>

Note: if you get an error "...role <your_username> does not exist" then you will need to create a role first
```
[PostgreSQL tutorial about creating a database](https://www.postgresql.org/docs/10/static/tutorial-createdb.html)  
[DigitalOcean on role and database creation](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-postgresql-on-ubuntu-18-04)  

You can create a PostgreSQL role using the following commands:
```
sudo -i -u postgres
createuser --interactive
-->Enter name of role to add: <your_username>
-->Shall the new role be a superuser? (y/n) y

Note: PostgreSQL roles are seperate from Linux usernames
```

If you have a role and a database, you can execute the following command:
```
psql

Note: use \q to exit psql
```

### [Tutorial](https://www.postgresql.org/docs/10/static/tutorial-accessdb.html) 

Play around with some of the commands:
```
SELECT version();
SELECT current_date;
SELECT 2 + 2;
\h
\q

Note: to exit a documentation screen just press q
```

### [Tutorial](https://www.postgresql.org/docs/10/static/tutorial-table.html)
