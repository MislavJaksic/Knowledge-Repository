## [Step by Step Tutorial](https://jekyllrb.com/docs/step-by-step/01-setup/)

### Setup

Follow the Installation guide.  

```
$: bundle init  # create a Gemfile
# Note: edit the Gemfile
  # gem "jekyll"
$: bundle  # installs dependencies (jekyll)
```

Add index.html:
```
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Home</title>
  </head>
  <body>
    <h1>Hello World!</h1>
  </body>
</html>
```

```
$: bundle exec jekyll build  # build
# Note: the output is in the _site directory

$: bundle exec jekyll server  # server website on http://localhost:4000/
```

### Liquid

Liquid is a templating language which has:
* objects
* tags
* filters

TODO
