## [Gunicorn](https://gunicorn.org/)

Python WSGI HTTP Server for UNIX.

### Install

[Installation instructions](Installation)

#### Ubuntu

```
$ sudo apt-get update
$ sudo apt-get install gunicorn
```

### Run

```
$: gunicorn [OPTIONS] [WSGI_APP]
  # [OPTIONS]: -c, -b, -w, -k, -n, ...
  # [WSGI_APP]: $(MODULE_NAME):$(VARIABLE_NAME)
```

[Run instructions](Running)
