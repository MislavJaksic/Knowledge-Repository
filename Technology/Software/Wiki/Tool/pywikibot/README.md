## [Pywikibot](https://github.com/wikimedia/pywikibot)

### [Install](https://www.mediawiki.org/wiki/Manual:Pywikibot/Installation)

Get it from Git.  
Strongly suggest using `poetry` as a dependency manager.  

### [Accessing Third-party Wikis](https://help.fandom.com/wiki/Pywikibot)

Follow the guide.  

### [Scripts](https://www.mediawiki.org/wiki/Manual:Pywikibot/Scripts)

```
$: poetry run python pwb.py login  # Login to the Wiki

$: poetry run python pwb.py cosmetic_changes  # Don't run it standalone, instead set "cosmetic_changes = True" in "user-config.py"

$: poetry run python pwb.py redirect double  # Fix double redirects
$: poetry run python pwb.py redirect broken  # Fix broken redirects

$: poetry run python pwb.py weblinkchecker -start:!  # Check dead links for the first time for all pages on the wiki
$: poetry run python pwb.py weblinkchecker -repeat  # After the bot has checked some pages, run it on these pages again at a later time

$: poetry run python pwb.py template -cat:Category-Name -remove "Template-Name"  # Remove every occurrence of the template from pages in category
$: poetry run python pwb.py template "Old-Template-Name" "New-Template-Name"  # Replace one template with the other

$: poetry run python pwb.py replace -page:Page-Name-1..-page:Page-Name-N "Old-String" "New-String"  # Replace old with new string on selected pages
$: poetry run python pwb.py replace -cat:Category-Name "Old-String" "New-String"  # Replace old with new string on pages in category
$: poetry run python pwb.py replace -page:Page-Name-1..-page:Page-Name-N -regex "Find-Regex" "Replace-Regex"  # Replace old with new string on selected pages using regex
$: poetry run python pwb.py replace -cat:Category-Name -regex "\| some-exact-words=.*\n \| " "| " "\| some-other-exact-words=.*\n \| " "| "  # How to replace a line with nothing without errors

$: poetry run python pwb.py category add  # ToDo
$: poetry run python pwb.py category add -to:Category-Name -redirect -page:Page-Name-1..-page:Page-Name-N  # Add category to a list of pages and follow redirects
$: poetry run python pwb.py category move -from:Category-Name -to:Category-Name -redirect -match:Regular-Expression  # Move a page that satisfies the RegEx
$: poetry run python pwb.py category remove -from:Category-Name -redirect -page:Page-Name-1..-page:Page-Name-N  # Remove category from a list of pages and follow redirects

$: poetry run python pwb.py add_text -cat:Category-Name -text:"{{Template-Name}}" -grepnot:"\{\{Template-Name\}\}"  # Add template to the bottom of the page, unless it is already present
$: poetry run python pwb.py add_text -cat:Category-Name -up -text:"{{Template-Name}}" -grepnot:"\{\{Template-Name\}\}"  # Add template to the top of the page, unless it is already present

$: poetry run python pwb.py movepages -pairsfile:"move-pairsfile.txt" -noredirect  # Move "[[Old-Page]] [[New-Page]] [[Old-Page]] [[New-Page]]" page pairs leaving no redirect behind

$: poetry run python pwb.py delete -cat:Category-Name  # Delete all pages in a category
```
