## [pgAdmin](https://www.pgadmin.org/)

### Install

#### Windows

Already comes pre-installed with the PostgreSQL installer.  
If installed in a non-deafult location, you'll need to set the binary path in `File -> Preferences -> Binary Path` to the location hwere you installed postgres.  

#### [Linux](http://queirozf.com/entries/installing-postgresql-and-pgadmin-on-ubuntu)

```
$: sudo apt-get install pgadmin4
```

```
$: psql
\password _username
Enter your password: _password
```

```
$: pgadmin3
```

```
# Note: click "Add a connection to a server"
Name: Catchy-Name
Host: localhost
Port: by default, its 5432
Maintenance DB: postgres
Username: _username
Password: _password
```

### Usage

Create database: right-click Databases  
Create schema: right-click Schemas  
Create table: right-click Tables  