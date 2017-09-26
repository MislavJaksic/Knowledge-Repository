## Ruby on Rails

A web application development framework.

### Install

On Windows:
1) install Ruby, a programming language, using a development kit
2) install SQLite by downloading a shell and .dll files
3) the Ruby path should be configured, but you need to set the PATH of sqlite3
4) (not mentioned in the tutorial) install Node.js and restart your computer

Step 4) is a way to solve the ExecJS error that may appear during the tutorial.

### Tutorial
To create a new application, position your command line in a folder and write rails new <name>.
Position your commna dline in the newly created folder and write ruby bin/rails server to start the server on 
http://localhost:3000.
Stop the server with Ctrl+C.

Controller receives requests and collects info.
View displays a page in a human readable form.
Routing decides which controller will recieve a request. There is more then one route to each controller.
Actions serve different routes. Actions collect info to provide it to a view.

To create a new controller with an action, use a generator. Write: ruby bin/rails generate controller 
<controller name> <action name>
Views are located in app/views.
Routing file: config/routes.rb, change your home page; says how to connect requests to actions and controllers.
              root '<controller name>#<action name>' maps requests for the root of the application the the 
			  <action name> of <controller name>.
