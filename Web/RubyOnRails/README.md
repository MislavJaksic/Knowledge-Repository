## Ruby on Rails

A web application development framework.

### Install

http://guides.rubyonrails.org/getting_started.html
http://blog.teamtreehouse.com/installing-rails-5-windows

On Windows:
1) install Ruby, a programming language, using a development kit
2) install SQLite by downloading a shell and .dll files
3) the Ruby path should be configured, but you need to set the PATH of sqlite3
4) (not mentioned in the tutorial) install Node.js and restart your computer

Step 4) is a way to solve the ExecJS error that may appear during the tutorial.

### Tutorial

To create a new application, position your command line in a folder and write "rails new prject_name".

Position your commna dline in the newly created folder and write ruby bin/rails server to start the server on 
http://localhost:3000.
Stop the server with Ctrl+C.

Controller receives requests and collects info.

View displays a page in a human readable form.

Routing decides which controller will recieve a request. There is more then one route to each controller.

Actions serve different routes. Actions collect info to provide it to a view.

To create a new controller with an action, use a generator. Write: "ruby bin/rails generate controller 
controller_name action_name"

Views are located in app/views.

Routing file: config/routes.rb, change your home page; says how to connect requests to actions and controllers.
              root "controller_name#action_name" maps requests for the root of the application the the 
              action_name of controller_name.
			  
Resource is a collection of similar objects. Resources are manipulated through CRUD operations. Rails has a 
"resources" method which declares a REST resource. Declare "resource :recource_name_plural" and Rails will 
create the CRUD automatically.

When controllers are generated they are empty. If there is an action <action name> in the controller, then 
Rails will look for resource_name/action_name templete. If it doesn't exit, it will look for 
application/action_name as controller_name inherits from ApplicationController.

request.formats: specifies th format (example is ["text/html"]).

request.variant: what kind of physical device will be served a response.

Template: made up of three parts, a action name and two extensions "action_name.format.handler" in
app/views/resource_name (example new.html.erb in app/views/articles).

Form: created using "form_with". Write it into the template. Fields of the form are passed as parameters to
Rails.

Params method: if an URI is http://www.example.com/?username=dhh&email=dhh@email.com then 
params[:username] = "dhh" and params[:email] = "dhh@email.com".

Stopped at 5.4
