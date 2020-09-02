## [Running Gunicorn](https://docs.gunicorn.org/en/latest/run.html)

You can integrate Gunicorn with `Django`, `Pyramid` or `TurboGears`.

### Commands

#### gunicorn

```
$: gunicorn [OPTIONS] [WSGI_APP]
  # [OPTIONS]: -c, -b, -w, -k, -n, ...
  # [WSGI_APP]: $(MODULE_NAME):$(VARIABLE_NAME)
```

Example: `gunicorn -w 2 test:app`

### Integration

TODO
