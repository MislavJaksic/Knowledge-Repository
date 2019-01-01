## [Flask](http://flask.pocoo.org/)

Flask is a web microframework. By itself, it doesen't consign you to any database or data abstraction layer.  
If you need the mentioned functionalities, you can extend Flask using extensions.  

### [Installation](http://flask.pocoo.org/docs/1.0/installation/#installation)

Get Python 3.x.  
Get the pip package.
Get the virtualenv package.
Create a virtual environment inside a Flask project folder.  

### [Example project]()

See example project.

### Run Flask

Key:  
_folder: on the same level as venv by default; is a package (has __init__.py)  
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

### Flask

Sample layout:
```
/home/user/Projects/flask-tutorial
├── flaskr/
│   ├── __init__.py
│   ├── db.py
│   ├── templates/
│   │   ├── base.html
│   │   ├── auth/
│   │   │   └── ...
│   │   └── blog/
│   │       └── ...
│   └── static/
│       └── style.css
├── tests/
│   └── ...
├── venv/
├── setup.py
└── MANIFEST.in
```

__init__.py should return a Flask instance. Flask instance must know where it is located.  
Flask instance can register teardown function (those activated upon exit), blueprints and views, command, ...  
Flask config is a dictionary with a lot of default value. You can add more for later use. You can load it from a file or fill it with another dictionary.  

Flask has an instance folder, one which should store data that is not to be commited to version control.  
Use open_resources to open files relative to the location of the Flask module.  

[flask.Flask(import_name)](http://flask.pocoo.org/docs/1.0/api/#flask.Flask)  
[_flask_instance.add_url_rule(rule)](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.add_url_rule)  
[_flask_instance.register_blueprint(blueprint)](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.register_blueprint)  
[_flask_instance.teardown_appcontext(f)](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.teardown_appcontext)  
[_flask_instance.cli (is click.Group)](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.cli)  
[click.Group.add_command(command)](https://click.palletsprojects.com/en/7.x/api/#click.Group)  

[Instance folder](http://flask.pocoo.org/docs/1.0/config/#instance-folders)  
[_flask_instance.open_resource(resource/file)](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.open_resource)  
[_flask_instance.default_config](http://flask.pocoo.org/docs/1.0/api/#flask.Flask.default_config)  

### Proxies

g is unique to each request. It can store and transport data between functions.  
current_app points to _flask_instance handling the request. It allows you to interact with it without having to import it.  
session acts like a signed cookie across multiple requests. You must have a secure SECRET_KEY.  

[g](http://flask.pocoo.org/docs/1.0/api/?highlight=g#flask.g)  
[flask.current_app()](http://flask.pocoo.org/docs/1.0/api/#flask.current_app)  
[flask.session](http://flask.pocoo.org/docs/1.0/api/?highlight=session#flask.session)  

### Views and Blueprints

View is a code that responds to a (HTTP) request. Views create a response.  

Blueprint is a related group of Views. They route and register functions and their URLs.  
Blueprints may prefix URLs they register.  
Functions can be registered so that they are executed before anything else or upon entering a specific URL.  

[Blueprint()](http://flask.pocoo.org/docs/1.0/api/#flask.Blueprint)  
[@_blueprint.route(rule, methods=(None))](http://flask.pocoo.org/docs/1.0/api/#flask.Blueprint.route)  
[@_blueprint.before_app_request(f)](http://flask.pocoo.org/docs/1.0/api/#flask.Blueprint.before_app_request)  

### Misc funcions

url_for() will generate a URL for you based on the routing anf function name.  
redirect() will redirect the caller to a location and provide them with a response code.  
render_template() will render a HTML template from the template folder.  

[flask.url_for(endpoint)](http://flask.pocoo.org/docs/1.0/api/#flask.url_for)  
[flask.redirect(location)](http://flask.pocoo.org/docs/1.0/api/#flask.redirect)  
[flask.render_template(template)](http://flask.pocoo.org/docs/1.0/api/#flask.render_template)   

### Requests

Request is what Flask recieves with every (HTTP) user request.
They have a method and a form dictionary which stores data.  

[Request()](http://flask.pocoo.org/docs/1.0/api/#flask.Request)  
[_request.method](http://flask.pocoo.org/docs/1.0/api/#flask.Request.method)  
[_request.form](http://flask.pocoo.org/docs/1.0/api/#flask.Request.form)  

### Templates

g is available in all templates.  

Flask uses Jinja templates.  
{% ... %} for Statements  
{{ ... }} for Expressions  
{# ... #} for Comments <- rare  
#  ... ## for Line Statements <- rare  

{% block _block_name %} will be overrriden by other templates which use {% extends "_HTML_file_name" %}.  

[Jinja templates](http://jinja.pocoo.org/docs/2.10/templates/)  

### Click commands

TODO