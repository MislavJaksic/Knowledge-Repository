## [Overview](https://ghost.org/docs/api/v3/handlebars-themes/context/)

Each `page` in a Ghost `theme` belongs to a `context` which is determined by the `URL`.  

`URL`s or `route`s are mapped to content.  
`Route`s determine what will be displayed and what `theme` will be used.  
`context`s interact with `helper`s.  

Use `{{#is}}` to detect `context`.  

### [Index](https://ghost.org/docs/api/v3/handlebars-themes/context/index/)

Main post list and home page.  
Paired with the `home` `context` or the `page` `context`.  

Present on:
*  `/`
* `page`s of the `post` list, which live at `/page/:num/`

Rendered with `index.hbs` or `home.hbs` if present.  
`index.hbs` `template` is used if no `tag.hbs` or `author.hbs` templates are provided.  

`template`s can access post objects and a pagination object.   

`{{#foreach 'posts'}}{{/foreach}}` is the best way to loop through your `post`s and output each one.  
`{{pagination}}` `helper` is the best way to output pagination.  



`home` is a special `context` which refers to page 1 of the `index`.  
`route` is always /.  
Default `template` for the `home` `page` is` index.hbs`.  

## [Post](https://ghost.org/docs/api/v3/handlebars-themes/context/post/)

TODO

## [Page](https://ghost.org/docs/api/v3/handlebars-themes/context/page/)

`page` `context` is for static content.  

`URL` is `/:slug/`.  

Default `template` for a `page` is `post.hbs` unless `page.hbs` is defined.  
`page-:slug.hbs` can be used for each individual `page` instead.  

`page` `context` can access `post` object which matches the `route`.   
`{{#post}}{{/post}}` will drop into the `post` scope and access all of the attributes.   

`post` (`page`) object attributes:
* `id` - the incremental ID of the page
* `title` - the title of your static page
* `excerpt` - a short preview of your page content
* `content` - the content of the page
* `url` - the web address for the static page
* `feature_image` - the cover image associated with the page
* `featured` - indicates a featured page. Defaults to false
* `page` - true if the post is a static page. Defaults to false
* `meta_title` - custom meta title for the page
* `meta_description` - custom meta description for the page
* `published_at` - date and time when the page was published
* `updated_at` - date and time when the page was last updated
* `created_at` - date and time when the page was created
* `primary_author` - a formatted link to the first author
* `tags` - a list of tags associated with the page

`{{#post}}{{/post}}` is the key to theming a static `page`.  
Other `helper`s:
* `{{title}}`
* `{{content}}`
* `{{url}}`
* `{{author}}`
* `{{date}}`
* `{{excerpt}}`
* `{{img_url}}`
* `{{post_class}}`
* `{{tags}}`

## [Author](https://ghost.org/docs/api/v3/handlebars-themes/context/author/)

TODO

## [Tag](https://ghost.org/docs/api/v3/handlebars-themes/context/tag/)

TODO
