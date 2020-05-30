## [Overview](https://ghost.org/docs/api/v3/handlebars-themes/)

Separates `HTML` from `JavaScript`.  
[Handlebars](../../TemplateProcessor/Handlebars) templating language.  
Validate `theme`s with `GScan`.  

## [Structure](https://ghost.org/docs/api/v3/handlebars-themes/structure/)

```
.
├── /assets
    ├── /css
        ├── screen.css
    ├── /fonts
    ├── /images
    ├── /js
├── /partials
    ├── list-post.hbs
├── default.hbs  # base template
├── index.hbs  # required; template for the list of posts
├── home.hbs  # template for /
├── post.hbs  # required; template for a post
├── custom-{{template-name}}.hbs  # template selected on a per-post basis
├── tag.hbs  # template for tag archives
├── author.hbs  # template for author archive pages
├── private.hbs  # template for the password form page
├── error.hbs  # template for 404 or 500 errors
├── error-{{error-class}}xx.hbs  # template for errors belonging to a specific class
├── error-{{error-code}}.hbs  # template for status code-specific errors
├── amp.hbs  # template for Accelerated Mobile Pages (AMP)
├── robots.txt  # overrides default
└── package.json  # required
```

Ghost `theme`s must use at least these `helper`s:
* `{{asset}}`
* `{{body_class}}`
* `{{post_class}}`
* `{{ghost_head}}`
* `{{ghost_foot}}`

Each `page` in a Ghost `theme` belongs to a `context` which is determined by the `URL`.  

Install Ghost locally and develop your `theme`.  

## [Package.json](https://ghost.org/docs/api/v3/handlebars-themes/packagejson/)

`package.json` has the `theme`'s meta data.  

```
{
    "name": "Theme-Name",
    "description": "Theme-Description",
    "version": "1.2.3",
    "engines": {
        "ghost-api": "v3"
    },
    "license": "MIT",
    "author": {
        "email": "Name-Surname@gmail.com"
    },
    "config": {
        "posts_per_page": 5,
        "image_sizes": {}
    }
}
```
