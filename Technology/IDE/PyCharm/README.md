## [PyCharm](https://www.jetbrains.com/pycharm/)

IDE for Python.  

### Install

#### Windows

Download and run the `.exe`.  

#### Linux

Download the `*.tag.gz`, extract it where you want it to be installed and then run `./pycharm.sh` in `.../bin`.  

### Configure

Change or set virtualenv: `Open a project -> Settings -> Project -> Project Interpreter`  
Find [poetry](../../Software/BuildTool/poetry)'s virtualenv with `poetry env info`.  

Delete virtualenv: `$: sudo rm -rf venv`

### Testing

Pick your default runner under: `Ctrl+Alt+S -> Tools -> Python Integrated Tools -> Default Test Runner`

#### Generate Python Tests

```
open a Python script -> Navigate -> Test -> pick test options
```

Shortcut: `CTRL+SHIFT+T`
