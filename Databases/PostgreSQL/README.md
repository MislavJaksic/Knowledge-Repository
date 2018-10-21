## PostgreSQL

### [Installation](https://www.postgresql.org/download/)

[Additonal instructions](http://www.postgresqltutorial.com/)

Each operating system has a different way of installing PostgreSQL.  
As an example, PostgreSQL 10 will be installed on Ubuntu LTS 18.04.  

Use the following command to install PostgreSQL:
```
sudo apt-get update
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
When you have created a Postgres role, go back and create a database with the same username.

If you have a role and a database, you can execute the following command:
```
psql

Note: use \q to exit psql
```

### [Installing pgadmin](http://queirozf.com/entries/installing-postgresql-and-pgadmin-on-ubuntu)

You can install a pgAdmin, an administration interface, on Ubuntu with:
```
sudo apt-get install pgadmin3
```

You need to register a new server, but first you need to set a password. Execute the following:
```
psql
\password <your_username>
Enter your password: <postres_password>
```

Run the PgAdmin interace with:
```
pgadmin3
```

After setting up a password, click "Add a connection to a server" and register it:
```
Name: <catchy_name>
Host: localhost
Port: by default, its 5432
Maintenance DB: postgres
Username: <your_username>
Password: <postres_password>
```

### PgAdmin interface

After installing and registering a PostgreSQL server note a few buttons:
```
Refresh
Execute arbitrary SQL queries
Expand schemas list
Show data in selected table
```

### [PostgreSQL and Python psycopg](http://www.postgresqltutorial.com/postgresql-python/)

It can be installed using Anaconda:
```
conda search psycopg2
conda install psycopg2
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
TODO
