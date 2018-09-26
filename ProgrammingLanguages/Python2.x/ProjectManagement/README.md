## Project structuring

Structure:

TopLevel

--__init__.py

--TopLevelModule.py

--SubLevelOne

-- --__init__.py

-- --SubLevelOneModule.py

-- --SubSubLevelOne

-- -- --__init__.py

-- -- --SubSubLevelOneModule.py

--SubLevelTwo

-- --__init__.py

-- --SubLevelTwoModule.py

### How to make programs use other programs

A program is a parent if it is in a folder above a child program.
Parent importing a child program is demonstrated in the TopLevelModule. Import using "from <folder_path>
import <module_name>".
Child importing a parent program is demonstrated in the SubSubLevelOneModule. First, the parent's package
(read folder) has to be added to the sys.path attribute. sys.path attribute is a list of strings where Python is going to search
for modules to import.

### Python packages, modules and imports

In Python, modules are imported and packages contain modules.
__init__.py files have to be put in every project's folder to signify that folder is a package.
A module will import another packaged module only if it is in a deeper folder or in sys.path. To add a
package to sys.path, use "sys.path.insert(0, os.path.abspath('<desired_depth>'))". If a child wants to import
a parent, then <desired_depth> is ".." as it will add the folder above the current one to sys.path.
