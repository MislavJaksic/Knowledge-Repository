## [Ghost](https://ghost.org/)

Ghost is a publishing tool used most often for blogs.  

Features:
* simplicity
* monetization
* headless `Node.js` CMS
* integrations

[Customers](https://ghost.org/customers/)  

### Setup

[In the Cloud or locally](Docs/Setup)

### Core Concepts

Posts:
* Primary entity-type
* Created in the editor
* Can have `Card`s
* Grouped

Pages:
* Pages are special posts
* Static and independent pages like `About` or `Contact`
* They are not crosslinked

[Details](Docs/CoreConcepts)  

### Local (Theme) Development

Prerequisites:
* [supported Node.js version](https://ghost.org/faq/node-versions/)
* `npm` to manage packages (`npm` comes with `Node.js`)

```
$: npm install ghost-cli@latest -g
$: npm install gscan -g
```

```
$: ls  # -> empty directory
$: ghost install local
```

Visit:
* http://localhost:2368
* http://localhost:2368/ghost

```
$: ghost stop
$: ghost start
$: ghost log
$: ghost ls

$: ghost help
```

[Local Installation](Docs/Setup/Local)  
[Custom Casper Theme](https://github.com/MislavJaksic/Blog/tree/master/ThemeDevelopment)  

### Gatsby and Ghost CMS

[Gatsby Frontend Framework](Docs/APIReference/Gatsby)  
[Gatsby](https://github.com/MislavJaksic/Gatsby-Tutorial)  
