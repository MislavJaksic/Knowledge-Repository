## [Configuration Overview](https://docs.gunicorn.org/en/latest/configure.html)

Order of reading configuration:
* Environmental Variables
* Framework Specific Configuration File
* `gunicorn.conf.py` in the current working directory
* Command Line Arguments stored in `GUNICORN_CMD_ARGS` Environmental Variables
* Command Line Arguments used to invoke Gunicorn

```
$ gunicorn --print-config APP_MODULE
$ gunicorn --check-config APP_MODULE
```


### Command Line

TODO

### Configuration File

TODO

### Framework Settings

TODO
