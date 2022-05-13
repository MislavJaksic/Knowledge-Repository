## [Ryans Tutorials: Bash Scripting Tutorial](https://ryanstutorials.net/bash-scripting-tutorial/)

Bash is a command line language. The name stands for Bourne Again SHell.

### What is a Bash Script

Command line commands put into a file for repeated use.  
By convention, files with an extension `.sh`.  

A process is a running instance of a program.

Before running a script, you need permission to run it: `chmod 755 Script-Name.sh`.  

`./` and `$PATH` specify where you want the command to be executed.  
`#!` is the shebang and is put on the first line of the file.  

### Variables

ToDo

### User Interface

Design and implement it so it is most convinient for the end user.  

`tput` is a command which allows you to control the cursor on the terminal and the format of content that is printed.

Supply data to a Bash script:
* As command line arguments - will be retained in the users history; for when the script is not run directly by the user
* Redirected in as STDIN - for when your script is behaving like a filter and just modifying or reformatting data that is fed to it
* Read interactively during script execution - for when you don't know what data may be required until the script is already running
