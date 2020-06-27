## [About GitHub Pages and Jekyll](https://help.github.com/en/github/working-with-github-pages/about-github-pages-and-jekyll)

### About Jekyll

`Jekyll` is a static site generator. It creates them from `Markdown` and `HTML`.  
`Jekyll` supports `Markdown` and `Liquid`.  

### Configuring Jekyll in your GitHub Pages site

Change `Jekyll` settings using `_config.yml`.  
`Jekyll`, by default, doesn't build files/folders that:
* are located in a folder called `/node_modules` or `/vendor`
* start with `_`, `.`, or `#`
* end with `~`
* are excluded by the exclude setting in your configuration file

### Front matter

Add YAML `Front Matter` to the top of any `Markdown` or `HTML` file to set variables and metadata.  
Add `site.github` to a post or page to add any repository references metadata to your site.  

### Themes

You can add a theme with a theme chooser or manually.  

### Plugins

`Jekyll` plugins to extend the functionality of `Jekyll`.  

GitHub Pages uses plugins that are enabled by default and cannot be disabled:
* `jekyll-coffeescript`
* `jekyll-default-layout`
* `jekyll-gist`
* `jekyll-github-metadata`
* `jekyll-optional-front-matter`
* `jekyll-paginate`
* `jekyll-readme-index`
* `jekyll-titles-from-headings`
* `jekyll-relative-links`

Enable plugins by adding the plugin's gem to the `plugins` setting in your `_config.yml` file.  

### Building your site locally

Build and test your site locally before pushing it to GitHub.  
