## [Mastering GitHub's Markdown](https://guides.github.com/features/mastering-markdown/)

GitHub can display a description of the current folder if there is a file called README.xxx in the folder.
If .xxx is .txt, the description will be plain: no colour; all letters are of the same font and size.
If .xxx is .md, the README will be interpreted as a Markdown file. You can get a taste for what Markdown looks like below.

### The look and feel of Markdown

[GitHub Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

# Big letters with a ghostly line below

## Smaller letters with a ghostly line below

### Smallerer letters

#### Smallererer letters

*Italic letters*

**Bold letters**

**_Italic and bold_**

* Black filled bullet
* Another black filled bullet point
    * Empty indented bullet point
    * Another empty indented bullet point

1. Ordered list
2. Ordered list item
    1. Ordered sublist
    2. Ordered sublist item

You can break up a paragraph  
with two spaces.

[Hyperlink without tooltip](https://www.mozilla.org)
[Hyperlink with a tooltip](https://www.mozilla.org "Mozilla Website")
[Hyperlink with the link at the bottom]

[Hyperlink with the link at the bottom]: https://www.mozilla.org

Embedded image:
![alternative_text_for_embedded_image](https://github.com/MislavJaksic/KnowledgeRepository/blob/master/GitHub/Guides/MasteringMarkdown/mozilla_logo_48.png)

> Blockquote; a thin gray strip will appear to the left of this paragraph and the text itself will be in a gray box. In addition,
> the text should appear 4 spaces away from the left margine.

A light gray horizontal rule
___

`Letters on a grey background`

[Shields and badges:](https://github.com/badges/shields)
[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)
[![Dependency Status](http://img.shields.io/gemnasium/badges/badgerbadgerbadger.svg?style=flat-square)](https://gemnasium.com/badges/badgerbadgerbadger)
[![Coverage Status](http://img.shields.io/coveralls/badges/badgerbadgerbadger.svg?style=flat-square)](https://coveralls.io/r/badges/badgerbadgerbadger)

Special GitHub enriched Markdown features:

```xml
<Looks_like_xml>
</It_can_also_look_like_html_java_javascript>
</It_highlights_the_syntax>
</Looks_like_xml>
```

- [x] Checked box
- [ ] Unchecked box


| Left aligned | Center aligned | Right aligned |
| :--- | :---: | ---: |
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |

~~Strikethough~~
