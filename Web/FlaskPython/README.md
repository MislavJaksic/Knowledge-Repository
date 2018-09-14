## [Flask](http://flask.pocoo.org/)

Flask is a Python microframework.

### [Installation](http://flask.pocoo.org/docs/1.0/installation/#installation)

Straightforward.

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
* .method stores the HTTP metohd
* .form stores form data (if POST or PUT methods are used)
* .args.get("key", "") stores URL paramaters
* .files["_HTML _attr_name"] stores uploaded files in a dictionary