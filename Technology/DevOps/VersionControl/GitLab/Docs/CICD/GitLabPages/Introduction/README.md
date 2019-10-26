## [Exploring GitLab Pages](https://docs.gitlab.com/ee/user/project/pages/introduction.html)

GitLab Pages requirements:
* instance domain
* ".gitlab-ci.yml"file
* GitLab Runner

GitLab Pages on GitLab.com:
* have a gitlab.io domain
* custom domains and TLS support
* shared runners

You can create custom error code pages (403, 404, ...).  

Redirecting is possible even with static pages.  

You can control the visibility of GitLab Pages.  

### .gitlab-ci.yml configurations

For plain HTML websites at the root of the repository:
```
├── index.html            pages:
├── css                     script:
│   └── main.css            - mkdir .public
└── js                      - cp -r * .public
    └── main.js             - mv .public public
                            artifacts:
                              paths:
                              - public
                            only:
                            - master
```

For static site generators see a [guide](https://docs.gitlab.com/ee/user/project/pages/getting_started_part_four.html).  

For repositories where there is code:
```
# Note: limit the pages job with the "only" parameter in -gitlab-ci.yml
# Note: create a branch for hosting your pages
$: git checkout --orphan pages

├── SSG Jekyll        image: ruby:2.6
├── ...               
...                   pages:
                        script:
                        - gem install jekyll
                        - jekyll build -d public/
                        artifacts:
                          paths:
                          - public
                        only:
                        - pages
```

For serving compressed assets:
```
public/                   pages:
├─┬ index.html              # Other directives
│ └ index.html.gz           script:
│                             # Build the public/ directory first
├── css/                      - find public -type f -regex '.*\.\(htm\|html\|txt\|text\|js\|css\)$' -exec gzip -f -k {} \;
│   └─┬ main.css        
...                             
```

### Resolving URLs

```
public/
├─┬ index.html
│ ├ data.html
│ └ info.html
│
├── data/
│   └── index.html
├── info/
│   └── details.html
└── other/
    └── index.html
```

| URL path            | HTTP response | File served               |
|---------------------|---------------|---------------------------|
| /                   | 200 OK        | public/index\.html        |
| /index\.html        | 200 OK        | public/index\.html        |
| /index              | 200 OK        | public/index\.html        |
| /data               | 200 OK        | public/data/index\.html   |
| /data/              | 200 OK        | public/data/index\.html   |
| /data\.html         | 200 OK        | public/data\.html         |
| /info               | 200 OK        | public/info\.html         |
| /info/              | 200 OK        | public/info\.html         |
| /info\.html         | 200 OK        | public/info\.html         |
| /info/details       | 200 OK        | public/info/details\.html |
| /info/details\.html | 200 OK        | public/info/details\.html |
| /other              | 302 Found     | public/other/index\.html  |
| /other/             | 200 OK        | public/other/index\.html  |
| /other/index        | 200 OK        | public/other/index\.html  |
| /other/index\.html  | 200 OK        | public/other/index\.html  |
