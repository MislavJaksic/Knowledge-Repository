## [Installation](https://docs.gunicorn.org/en/latest/install.html)

```
$ pip install gunicorn  # not recommended
```

### From Source

```
$: pip install git+https://github.com/benoitc/gunicorn.git
```

### Async Workers

TODO

### Extra Packages

TODO

### Debian GNU/Linux

```
$ sudo apt-get install gunicorn
```

Add to `/etc/apt/sources.list` to get the most recent version:
```
deb http://ftp.debian.org/debian stretch-backports main
```

```
# Note: after addin the line to `/etc/apt/sources.list`
$ sudo apt-get update
$ sudo apt-get -t stretch-backports install gunicorn
```

### Ubuntu

```
$ sudo apt-get update
$ sudo apt-get install gunicorn
```
