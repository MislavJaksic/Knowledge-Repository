from setuptools import setup, find_packages


with open("README.rst") as f:
  readme = f.read()

setup(
  name="project_template",
  version="0.1.0",
  description="",
  long_description=readme,
  
  author="",
  author_email="",
  url="",
  
  packages=find_packages(exclude=("tests", "docs")),
  
  entry_points={"console_scripts" : ["project_name = src.big_package.runner:Run"]} 
)

