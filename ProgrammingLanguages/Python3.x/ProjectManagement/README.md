## Project Management

### Setup

Install Python_3.x.
Update pip package: "python -m pip install --upgrade pip".  
Install virtualenv package: "pip install virtualenv".  

### Create a virtual environment

Create a virtual environment: "virtualenv venv". "venv" is a customary name for a python virtual environment.  

Linux: activate and deactivate virtual environment: "source venv/bin/activate"; "deactivate"  
Windows: relax the script execution policy: "Set-ExecutionPolicy RemoteSigned"  
. . . . .activate and deactivate virtual environment: ".\venv\Scripts\activate"; "deactivate" 

You may delete your virtual environment by simply deleting the "venv" folder. 

### Inside a virtual environment

The virtual environments isolate Python dependencies (specific version packages) from the rest of your computer.  
Without a virtual environment you may never be sure that someday a package version isn't going to break your program.  

Install requirements: "pip install -r requirements.txt".  

### Requirements.txt

Requirements.txt specify project dependencies.  
You should install new Python packages through Requirements.txt.  

Install new packages: "pip install -r requirements.txt".  

### Tests

Run tests with "pytest".

### Documenting

TODO

### Setup.py

TODO