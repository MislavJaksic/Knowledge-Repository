## Project Management

### Setup

```
# Install Python 3

$: python -m pip install --upgrade pip

$: pip install virtualenv
```

### Create a virtual environment

```
$: virtualenv venv - calling a virtual environment venv is customary
```
You can delete the environment by simply deleting the "venv" folder.  

#### Linux

```
$: source venv/bin/activate

$: deactivate
```

#### Windows

```
# Set execution policy:
$: Set-ExecutionPolicy RemoteSigned

$: .\venv\Scripts\activate

$: deactivate
```

### Inside a virtual environment

A virtual environment isolates Python project's packages from other projects.  
Without a virtual environment a package update required for one project may cause another project to stop working.  

```
$: pip install -r requirements.txt
```

### Requirements.txt

Requirements.txt specifies which packages the project requires.  
Only install new Python packages through Requirements.txt.  

### Tests

Run tests with "pytest".

### Documenting

TODO

### Setup.py

TODO