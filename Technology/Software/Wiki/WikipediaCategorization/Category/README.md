## [https://en.wikipedia.org/wiki/Help:Category](https://en.wikipedia.org/wiki/Help:Category)

Categories group together pages on similar subjects. Use markup `[[Category:XYZ|Sortkey]]`.  

### Summary

A category page is a page like any other, but part of it containers generated links.

### Category page definition

A category page is any page in the Category namespace. They each act as a category, and are termed a "category". The category page has one section titled Subcategories listing other "categories", and one section titled Pages, listing pages as categorized (in other namespaces). New categories are created by creating a page in the Category namespace.

A category page can be edited like any other page. However, when it is displayed, the editable part of the page is followed by automatically generated lists of pages belonging to the category, as follows:

    First a count and list of subcategories (other category pages belonging to the category) is shown, if any exist. The name of each subcategory is followed by counts like "(6 C, 38 P, 2 F)", meaning this subcategory contains 6 subcategories, 38 pages, and 2 files. Counts of 0 are omitted. The further subcategories are expanded in the display if the ► sign alongside the subcategory is clicked (but this "widget" is only visible if your browser has JavaScript enabled). Note: ► is shown if there are no further subcategories. The subcategory is collapsed again if ▼ is clicked.
    Next a count and list of pages in the category (excluding subcategories and images) is shown. If the category has no members, a message to that effect is displayed.
    Next a count and list of image and other media files in the category appears, if any exist. These are shown with thumbnails. The first 20 characters of the file name are shown, with an ellipsis if that is not the full name; also the file size is shown.

The items in the lists all link to the pages concerned; in the case of the images this applies both to the image itself and to the text below it (the name of the image).

For the way in which the lists are ordered, see Sorting category pages below. The first and second lists are divided into sections, according to the first character of the sort key. These initial characters are displayed above the sections. To suppress these, make all sort keys start with a space.

A category page can only display a limited number of items (currently 200). If more pages belong to the category, there will be a link to the next ones.

The categories box for the category page appears at the bottom, in the same place as for other pages. This contains the categories to which the current category page has been added, i.e. its parent categories (the categories of which it is a subcategory). Add a category page to other categories in the normal way, using the "[[Category:Category name]]" or "[[Category:Category name|Sortkey]]" syntax.
Putting pages into categories
Shortcut

    WP:PAGECAT

A page belongs to a category if the page's wikimarkup contains a declaration for that category. A category declaration takes the form [[Category:Category name]] or [[Category:Category name|Sortkey]]. The declaration must be processed, i.e. it will not work if it appears between <nowiki>...</nowiki> or <includeonly>...</includeonly> tags, or in a comment. The declaration may however come from a transcluded page; see Categories and templates below.

A category name can be any string that would be a legitimate page title. If the category name begins with a lower-case letter it will be capitalized.

In Wikipedia, it is customary to place category declarations at the end of the wikimarkup, but before any stub templates (which themselves transclude categories) and interlanguage links.

When a page has been added to one or more categories, a categories box appears at the bottom of the page (or possibly elsewhere, if a non-default skin is being used). This box contains a list of the categories the page belongs to, in the order in which the category declarations appear in the processed wikimarkup. The category names are linked to the corresponding category pages. They appear as redlinks if the corresponding category page does not exist. If a user has enabled the HotCat gadget, the categories box will also provide links to quickly add, remove, or modify category declarations on the page, without having to edit the whole page.

Hidden categories are not displayed, except as described below under Hiding categories.
Working with category pages

The following subsections are ordered from simple actions to more elaborate or rarer actions.
Linking to category pages

To link to a category page without putting the current page in that category, precede the link with a colon: [[:Category:Category name]]. Such a link can be piped like a normal wikilink. (The {{cl}} template, and others listed on its documentation page, may sometimes be helpful.)
Retrieving raw category information

Raw information about the members of a category, their sortkeys and timestamps (time when last added to the category) can be obtained from the API, using a query of the form:

    http://en.wikipedia.org/w/api.php?cmtitle=Category:Category_name&action=query&list=categorymembers&cmlimit=500&cmprop=title|sortkey|timestamp

Listings of up to 500 members are possible. If there are more members then the results will include text near the end like this: <categorymembers cmcontinue="page|NNNN|TITLE" />.

This can be added to the previous one, without quotation marks, for the next page of members: ...&cmcontinue=page|NNNN|TITLE
Sorting category pages
See also: Help:Sorting
Shortcut

    WP:SORTCAT

By default, a page is sorted under the first character of its name, without the namespace. English Wikipedia groups accented characters together with their unaccented version, so pages starting with À, Á, Ä, will be listed under heading A. Sorting is case-insensitive, so "ABC" comes after "Abacus".

Unlike at Special:Allpages and Special:Prefixindex, a space is treated as a space (coming before all other characters), not as an underscore.

The English Wikipedia has numerical sorting in categories. This means a page whose title begins with a number will be sorted according to the numeric value of the number (even if it is multiple digits). Thus "9 dogs", "25 dogs", and "112 dogs" will all appear under the "0–9" heading in numeric order. If the number includes a comma, space, or period, the sorting algorithm will only consider the part of the number before the separator.

Each of the three lists (subcategories, pages, media files) is arranged in the order explained above (except that, in the subcategories list, the namespace indicator "Category:" is not considered). If an item ought to be positioned within a list on the basis of an alternative name (sort key) for that item, then this can be specified in the category tag that places the item in the list:

[[Category:Category name|Sortkey]]

For example, to add an article called Albert Einstein to the category "People" and have the article sorted by "Einstein, Albert", you would type:

[[Category:People|Einstein, Albert]]

Unlike a piped link (which uses the same syntax), the sort key itself is not displayed to readers. It affects only the order in which pages are listed on the category page.

It is useful to document the system being used for sort keys on the category page. For guidelines about the use of sort keys on Wikipedia, see WP:SORTKEY.
Default sort key
Shortcut

    WP:DEFAULTSORT

See also: WP:NAMESORT and WP:SORTKEY

It is possible to set a default sort key which is different from {{PAGENAME}} by using the magic word {{DEFAULTSORT}}:

{{DEFAULTSORT:new key}}

In the case of multiple default sort key tags, the last DEFAULTSORT on the final rendering of a page applies for all categories, regardless of the position of the category tags. This also means that a DEFAULTSORT tag included from a template is not effective if another DEFAULTSORT tag occurs later on the page, even if the later DEFAULTSORT tag is also "hidden" (included by another template). If a category is added inside <ref>...</ref> then DEFAULTSORT may be ignored.
Searching for pages in categories
Further information: Help:Searching § Syntax
See also: § Searching for articles in categories, Wikipedia:Category intersection, and Wikimedia bug T3497 "Hierarchical category system is urgently needed"

In addition to browsing through hierarchies of categories, it is possible to use the search tool to find specific articles in specific categories. To search for articles in a specific category, type incategory:"CategoryName" in the search box.

An "OR" can be added to join the contents of one category with the contents of another. For example, enter

        incategory:"Suspension bridges" OR incategory:"Bridges in New York City"

to return all pages that belong to either (or both) of the categories, as here.

Note that using search to find categories will not find articles which have been categorized using templates. This feature also doesn't return pages in subcategories.
Listing all categories

Special:Categories provides an alphabetic list of all categories, with the number of members of each; this number does not include the content of the subcategories, but it includes the subcategories themselves, i.e., each counting as one.

The above list contains all categories that have members, regardless of whether they have corresponding category pages. To list all existing category pages (regardless of whether they have members), use Special:AllPages/Category:.
Displaying category trees and page counts

As described at mw:Help:Magic words, {{PAGESINCATEGORY:Example}} or {{PAGESINCAT:Example}} returns the number of pages in "Category:Example". Each subcategory counts as one page; pages in subcategories are not counted.

The page Special:CategoryTree enables you to see the tree structure of a category (its subcategories, their subcategories and so on; the display of files and other member pages is optional).

The CategoryTree extension can be used to display such a tree on any page. (This is sometimes done on the category page itself, if the category is split over multiple screens, to make all subcategories available on every screen.) The basic syntax is

    <categorytree>Category name</categorytree>

to display just the subcategory tree, and

    <categorytree mode=pages>Category name</categorytree>

to display member pages as well. They will be indicated by italics.

Dapete's category-visualizer vCat will render charts of the tree structure.

You may also use Template:Category tree or Template:Category tree all, instead.

Warning:

    The following code {{PAGESINCATEGORY:{{PAGENAME}}}} will not work as expected when used in the wikitext or in a transcluded template in a category page whose title contains some ASCII punctuations.
    For legacy reasons, {{PAGENAME}} may return the page name with these characters being HTML-encoded using numeric character entities : this still works for generating derived wikilinks or displaying page names, or when HTML-encoded this page name is used in a conditional "#switch", but PAGESINCATEGORY does not recognize the category name given in parameter if some characters are HTML-encoded (this is the case notably when the category name contains ASCII apostrophes ' and a few other ASCII punctuations. (The same HTML-encoding is also applied to the values returned by {{FULLPAGENAME}}, {{SUBPAGENAME}}, or {{NAMESPACE}}).
    In that case, as the category is not found by its HTML-encoded pagename, PAGESINCATEGORY will unexpectedly return 0 and not its effective number of member pages.
    A simple workaround is to transform these HTML-encoded characters back into standard UTF-8-encoded characters, by using the {{titleparts:}} parser function, like this:
    {{PAGESINCATEGORY:{{titleparts:{{PAGENAME}}}}}}

Moving and redirecting category pages

Categories can be moved in the same way as an ordinary page; but a certain amount of cleanup may be necessary. A redirect is left at the old category name, and this is not a normal #REDIRECT [[...]] but a {{category redirect}}. Once all the pages have been moved out of the old category, it may be left as a category redirect or deleted. For categories entirely populated through templates (see above), modifying the templates enables all affected articles to be moved to another category, but with the refresh problem mentioned. Almost all category name changes are made pursuant to a consensus decision at Wikipedia:Categories for discussion.

Do not create intercategory redirects other than with a {{category redirect}} template. See Wikipedia:Categories for discussion#Redirecting categories for more on category redirects.
Hiding categories

When the magic word __HIDDENCAT__ is placed on a category page, that category becomes hidden, meaning that it will not be displayed on the pages belonging to that category. On Wikipedia, the magic word is not normally used explicitly, but is applied through the {{hidden category}} template. The feature is mostly used to prevent project maintenance categories from showing up to ordinary readers on article pages.

However, hidden categories are displayed (although listed as hidden):

    on category pages (whether as parent categories or subcategories);
    at preview during editing;
    if the user has selected "Show hidden categories" in user preferences.

Hidden categories are automatically added to Category:Hidden categories.

For guidelines on the hiding of categories on Wikipedia, see WP:HIDDENCAT.

Finding articles for a category

The most effective way of finding entries of a category is using the "What links here" tool on the category's main article.

An easy way to find relevant articles for a new category or missing entries in an existing one is by finding the most relevant list and checking its entries. Sometimes categories are about things that are intersections of other categories for which the PetScan tool can be used.

More relevant articles may also be found linked in a category's main article and the articles already featured in the category − especially in their "See also" sections (if existent) and the automatically suggested "RELATED ARTICLES" below them.

Furthermore, a category's superordinate categories often feature articles that should be subcategorized to the category.

Other ways to find relevant articles include searching Wikipedia for the category's topic and searching the Web for the topic in quotes " (with synonyms also in quotes and appended after an OR) and appending the word wiki or Wikipedia or site:Wikipedia.org to them.
Categorizing
Main page: Wikipedia:Categorization
Categorizing templates

Templates are categorized the same way as articles, except that [[Category: Some-topic templates]] should be placed on the template's documentation page (or inside <noinclude>...</noinclude> tags, if there is no documentation page), this is necessary to avoid categorizing pages by template inclusion (see below).
Categories and templates

A template can be used to add pages to a category, usually by placing the category link inside <includeonly></includeonly> tags on the template (e.g. <includeonly>[[Category:category name]]</includeonly>). When the template is transcluded into the page, the category link becomes active, and the page is added to the category page. This is useful for categories that have high turnover or many pages included, like cleanup categories.

Changes to the template, however, may not be reflected immediately on the category page. When you edit an article to add a category tag directly, the list of category members is updated immediately when the page is saved. When a category link is contained in a template, however, this does not happen immediately: instead, whenever a template is edited, all the pages that transclude it are put into the job queue to be recached during periods of low server load. This means that, in busy periods, it may take hours or even days before individual pages are recached and they start to appear in the category list. Performing a null edit to a page will allow it to jump the queue and be immediately recached.

To add the template itself to the category page as well, omit the "includeonly" tags. To add the template to a category without categorizing pages on which the template is transcluded, place the category declaration between <noinclude>...</noinclude> tags, or add it to the template documentation page between <includeonly></includeonly> (the latter allows recategorizing the template without editing it, which is helpful if it is protected, or so complicated that mere mortals hesitate to touch it).

Parser functions can be used to make the transcluded categories, or the sort key used in them, dependent on other variables, notably PAGENAME.

Passing a category name as a parameter
    <includeonly>[[Category:{{{cat|default}}}]]</includeonly> or <includeonly>{{{cat|[[Category:default]]}}}</includeonly>
    If the user provides a parameter 'cat=XXX' the page will be categorized at the page [[Category:XXX]], otherwise it will be categorized at the page [[Category:default]]. Calling the template with "cat=" (equal to nothing) disables putting the page in any category.

Excluding non-article pages
    <includeonly>{{#if:{{NAMESPACE}} | | [[Category:XXX]]}}</includeonly>
    the variable NAMESPACE is null for mainspace articles. For any space other than mainspace, this ParserFunction will produce an empty string, but for regular articles this will include the article in Category:XXX.

On Wikipedia it is not recommended that templates be used to populate ordinary content categories of articles. See Categorization using templates in the categorization guideline.
Categorizing redirect pages
Main page: Wikipedia:Categorizing redirects

Redirect pages can be categorized and there are conventions how to do it. The redirect link must be first on the page. On a category page, redirects are listed in italics.
"Related Changes" with categories

For a category, the "Related Changes" feature, when applied to the corresponding category page, lists recent changes to the pages which are currently listed as belonging to a category. Where those pages are subcategories or image pages, only changes to their editable parts are listed.

Notice that "Related Changes" does not show edits to pages that have been removed from the category.

Also, "Related Changes" does not list recent changes to pages linked from the editable part of the category page (as it would normally, with a non-category page). If a workaround would be required, the links in question could be placed in a template and transcluded onto the category page.

As usual – unlike with watchlists – recent changes to corresponding talk pages are not shown under "Related Changes". Pages one is watching are bolded on the list. This can help to find which pages in a given category one has on one's watchlist.

The DynamicPageList (third-party) extension provides a list of last edits to the pages in a category, or optionally, just the list of pages; the simpler DynamicPageList (Wikimedia) is installed on Meta, Wikinews, Wikibooks and Wikiversity; the extension mw:Extension:DPLforum is installed on Wikia.
Watching category additions and removals

Since 2016, additions and removals from categories are available via the "Category changes" filter on recent changes pages, including watchlists and Special:RecentChangesLinked. For example, category changes to articles in Category:Cannabis stubs can be found here. You can monitor additions and removals from specific categories by adding the categories to your watchlist and making sure the "Category changes" filter is active. You can view changes to categories in your watchlist by clicking here. Additional scripts with similar functionality are User:CategoryWatchlistBot and User:Ais523/catwatch.
