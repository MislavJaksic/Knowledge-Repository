## [How to install Ghost locally](https://ghost.org/docs/install/local/)

For development.  

Prerequisites:
* [supported Node.js version](https://ghost.org/faq/node-versions/)
* `yarn` or `npm` to manage packages (`npm` comes with `nodejs`)

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

### Developing Themes

Place custom `theme` in `/content/themes/`.  
File edits automatically reload Ghost.  
You need to restart Ghost after creating new files.  

Scan and validate themes with `gscan`:
* `gscan /path/to/Theme-Directory`
* `gscan -z /path/to/Archive-Name.zip`
