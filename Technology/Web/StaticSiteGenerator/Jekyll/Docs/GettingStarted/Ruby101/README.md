## [Ruby 101](https://jekyllrb.com/docs/ruby-101/)

Gems are Ruby packages.  

Gemfile is a list of required gems.  
```
source "https://rubygems.org"

gem "jekyll"

group :jekyll_plugins do
  gem "jekyll-feed"
  gem "jekyll-seo-tag"
end
```

Bundler is a gem  package manager.  
```
$: gem install bundler
# Note: install Bundler only once

$: bundle install  # installs gems
$: bundle exec jekyll serve  # servers the website on http://localhost:4000
```
