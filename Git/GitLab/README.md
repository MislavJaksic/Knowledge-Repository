## [GitLab](https://gitlab.com/)

### Command Line Instructions (below Maintainer rank)

```
Git global setup
  git config --global user.name "Mislav Jaksic"
  git config --global user.email "jaksicmislav@gmail.com"

Create a new repository
  git clone https://gitlab.com/URI/to/_file_name.git
  cd URI
  touch README.md
  git add README.md
  git commit -m "add README"

Existing folder
  cd existing_folder
  git init
  git remote add origin https://gitlab.com/URI/to/_file_name.git
  git add .
  git commit -m "Initial commit"

Existing Git repository
  cd existing_repo
  git remote rename origin old-origin
  git remote add origin https://gitlab.com/URI/to/_file_name.git
```

### Command Line Instructions (Maintainer rank and above)

```
Git global setup
  git config --global user.name "Mislav Jaksic"
  git config --global user.email "jaksicmislav@gmail.com"

Create a new repository
  git clone https://gitlab.com/URI/to/_file_name.git
  cd URI
  touch README.md
  git add README.md
  git commit -m "add README"
  git push -u origin master

Existing folder
  cd existing_folder
  git init
  git remote add origin https://gitlab.com/URI/to/_file_name.git
  git add .
  git commit -m "Initial commit"
  git push -u origin master

Existing Git repository
  cd existing_repo
  git remote rename origin old-origin
  git remote add origin https://gitlab.com/URI/to/_file_name.git
  git push -u origin --all
  git push -u origin --tags
```
