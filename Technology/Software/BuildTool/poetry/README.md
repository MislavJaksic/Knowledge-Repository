## [poetry](https://python-poetry.org/)

[Python Template project](https://github.com/MislavJaksic/Python-Project-Template) that uses poetry.  
```
$: poetry env info  # show project virtualenv info
```

### [PyCharm](../../../IDE/PyCharm)  

`PyCharm` is a free helpful IDE for Python that is fully compatible with `poetry`.  
Make sure you create a `virtualenv` with `poetry install` rather then with `PyCharm`.  

### Errors

```
EnvCommandError
...
No Python at ...
```
Solution: delete the `virtualenv` under `...\AppData\Local\pypoetry\Cache\virtualenvs` on Windows
