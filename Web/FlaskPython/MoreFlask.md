### [Tutorial](http://flask.pocoo.org/docs/1.0/tutorial/)

#### Application Setup

[Flask()](http://flask.pocoo.org/docs/1.0/api/#flask.Flask)  
[_flask_instance.config.from_mapping()](http://flask.pocoo.org/docs/1.0/api/#flask.Config.from_mapping)  
[_flask_instance.config.from_pyfile()](http://flask.pocoo.org/docs/1.0/api/#flask.Config.from_pyfile)  
[_flask_instance.instance_path](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.instance_path)  
[SECRET_KEY](http://flask.pocoo.org/docs/1.0/config/#SECRET_KEY)  

[Decorator @_flask_instance.route()](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.route)  



_folder: on the same level as venv by default, is a package (has __init__.py)  
_application_factory: called "create_app" by default, returns a Flask instance  

Linux and Mac:  
```
export FLASK_APP=_folder:_application_factory
export FLASK_ENV=development
```

Windows PowerShell:  
```
$env:FLASK_APP = "_folder:_application_factory"
$env:FLASK_ENV = "development"
```

```
flask run

Open: http://127.0.0.1:5000/hello
```

#### Define and Access the Database

[g proxy](http://flask.pocoo.org/docs/1.0/api/#flask.g)  

[_flask_instance.current_app](http://flask.pocoo.org/docs/1.0/api/#flask.current_app)  
[_flask_instance.open_resource()](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.open_resource)  
[_flask_instance.teardown_appcontext()](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.teardown_appcontext)  

[connect()](https://docs.python.org/3/library/sqlite3.html#sqlite3.connect)  
[sqlite3.Row](https://docs.python.org/3/library/sqlite3.html#sqlite3.Row)  

[command()](https://click.palletsprojects.com/en/7.x/api/#click.command)  
[_click_group.add_command()](https://click.palletsprojects.com/en/7.x/api/#click.Group.add_command)  



SQLite is a free, serverless, sequential database that is also built into Python.  

g is a namespace object that can store data during an application context.  
current_app allows access to the application without having to import it.  

sqlite3.Row makes SQLite mimic Python tuples when returning data.  

You can define, register and run a Flask command.  
```
Define:   @click.command(_command_name)
Register: during _flask_instance creation
Run:      flask _command_name
```

#### Blueprints and Views

[Blueprint()](http://flask.pocoo.org/docs/1.0/api/#flask.Blueprint)  
[_flask_instance.register_blueprint()](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.register_blueprint)  
[_blueprint.route()](http://flask.pocoo.org/docs/1.0/api/#flask.Blueprint.route)  
[_blueprint.before_app_request()](http://flask.pocoo.org/docs/1.0/api/#flask.Blueprint.before_app_request)  

[_request.method](http://flask.pocoo.org/docs/1.0/api/#flask.Request.method)  
[_request.form](http://flask.pocoo.org/docs/1.0/api/#flask.Request.form)  

[generate_password_hash()](http://werkzeug.pocoo.org/docs/0.14/utils/#werkzeug.security.generate_password_hash)  
[check_password_hash()](http://werkzeug.pocoo.org/docs/0.14/utils/#werkzeug.security.check_password_hash)  

[_connection.fetchone()](https://docs.python.org/3/library/sqlite3.html#sqlite3.Cursor.fetchone)  
[_connection.fetchall()](https://docs.python.org/3/library/sqlite3.html#sqlite3.Cursor.fetchall)  
[_connection.execute()](https://docs.python.org/3/library/sqlite3.html#sqlite3.Connection.execute)  
[_connection.commit()](https://docs.python.org/3/library/sqlite3.html#sqlite3.Connection.commit)  

[url_for()](http://flask.pocoo.org/docs/1.0/api/#flask.url_for)  
[redirect()](http://flask.pocoo.org/docs/1.0/api/#flask.redirect)  
[flash()](http://flask.pocoo.org/docs/1.0/api/#flask.flash)  
[render_template()](http://flask.pocoo.org/docs/1.0/api/#flask.render_template)  

[session proxy](http://flask.pocoo.org/docs/1.0/api/#flask.session)   



View is a code that responds to a (HTTP) request. Views create a response.  

Blueprint is a related group of Views.  
Blueprints register views with the Flask instance.  
Blueprints can prefix URLs they register.  
Blueprint route functions and register their URLs.  
Blueprints can register function that have to be executed before any other view functions.  

Request has a method. Some methods include: POST, GET...  
Request can have a form dictionary which is filled when a user submits data through a HTML form.  

Storing passwords is a art unto itself. Make sure it is "salted" and hashed.  

Connections to the database can execute SQL queries, commit INSERTs and get results.  

Endpoint is a decorator that registers a function. Endpoint is a name associated with a view, a function name.  
If an Endpoint is registered with a Blueprint, the Blueprint name is prepended to the Endpoint name.  
Generate a URL for an endpoint, don't write out the URL.  
Redirection means returning a response that directs a client to another URL.  
Messages can be flashed to the user.  
HTML templates can be rendered from their own folder.  

Session is a dictionary that acts like a signed cookie across requests.  

#### Templates and Static Files

Templates are placeholder HTML files.  
{{ }} denote an expression. {% %} denote a control flow statement.  

#### Blog

TODO

#### Make the Project Installable

TODO

#### Test Coverage

TODO

### [Quickstart](http://flask.pocoo.org/docs/1.0/quickstart/#quickstart)

To see how to set up an application, see "Larger Application".  
You can view the result on http://127.0.0.1:5000/.  
There are multiple [deployment options](http://flask.pocoo.org/docs/1.0/deploying/#deployment).  

To swap between development and production mode use:  
```
export FLASK_ENV=development # refreshes the service after each program change
export FLASK_ENV=production
```

url_for("_function_name", args...) - build and return a URL from .route() and args  
```
Example:
@app.route('/user/login/<username>')
def profile(username):
  return '{}\'s profile'.format(username)
  
url_for('profile', username='John Doe', unknown="hello") # returns /user/login/John%20Doe?unknown=hello
```

You can specify which HTTP methods you wil accept at that URL.  
Flask can server static files (even though that's the job of a server):  
```
url_for('static', filename='style.css') # file is located in static/style.css
```

You can generate a web page from a template.  
All templates are located in the templates folder.  
```
@app.route('/hello/<name>')
def hello(name=None):
    return render_template('hello.html', name=name)
```
```
<!doctype html> <!- Can access request, session, g objects and get_flashed_messages() function -->
<title>Hello from Flask</title>
{% if name %}
  <h1>Hello {{ name }}!</h1>
{% else %}
  <h1>Hello, World!</h1>
{% endif %}
```

All info that the user sends is in the global request object.  

You can upload and serve files using Flask.  

TODO http://flask.pocoo.org/docs/1.0/quickstart/#cookies 



### [Patterns for Flask](http://flask.pocoo.org/docs/1.0/patterns/)

#### [Larger Applications](http://flask.pocoo.org/docs/1.0/patterns/packages/)

See flask_service_blueprint.zip file.  

#### [Uploading Files](http://flask.pocoo.org/docs/1.0/patterns/fileuploads/#uploading-files)

```
UPLOAD_FOLDER = '/path/to/the/uploads'
ALLOWED_EXTENSIONS = set(['txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif'])

app = Flask(__name__) # drop in a "Larger Application"
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
```

### API

[Request](http://flask.pocoo.org/docs/1.0/api/#flask.Request)  
* .method stores the HTTP method  
* .method stores the HTTP method  
* .form stores form data (if POST or PUT methods are used)  
* .args.get("key", "") stores URL paramaters  
* .files["_HTML _attr_name"] stores uploaded files in a dictionary  