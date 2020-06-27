## [Creating a GitHub Pages site with Jekyll](https://help.github.com/en/github/working-with-github-pages/creating-a-github-pages-site-with-jekyll)

### Prerequisites

Install and setup:
* [Git](../../../../../Git) to access the repository
* `Ruby` to install `Bundler`
* `Bundler` for managing `Ruby` gems
* [Jekyll](../../../../../../../Web/StaticSiteGenerator/Jekyll) for creating a static website

### Creating a repository for your site

Add to an existing project:
* `gh-pages` branch or
* `/docs` folder

You can also create a new repository.  

```
Sign in -> + -> New Repository -> Pick Owner -> Fill in repo name: User-Name.github.io/Org-Name.github.io -> Pick Visibility -> Initialize this repository with a README -> Create Repository
```

### Creating your site

```
$: git init Repository-Name
$: cd Repository-Name
```

Navigate to you publishing source.  

```
$: cd docs
OR
$: git checkout --orphan gh-pages
OR
Note: you are already in root and don't have to reposition
```

[GitHub Pages Jekyll Dependency Version](https://pages.github.com/versions/)  

```
$: jekyll new .
```

Open the `Gemfile` and read the comments:
* set versions to GitHub Pages `Jekyll` Dependency Versions
* uncomment `gem` `"github-pages", group: :jekyll_plugins` and comment the `jekyll` `gem`
* run `bundle update`

Test your site locally.  

Push your site to a GitHub repository.  

```
Sign in -> Choose Repository -> Settings -> Options -> GitHub Pages -> Your site is published at ...
```
