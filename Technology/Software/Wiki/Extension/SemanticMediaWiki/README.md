## [Semantic MediaWiki](https://www.semantic-mediawiki.org/wiki/Semantic_MediaWiki)

```
Subject: a wikipage
Property: predicate, a number or URL or Page or another Type
Value/Object: a declarative value
Statement: a subject, a property and a value in order to form a fact
```

`Special:Types`:
* `Page`
* `Text`
* `Number`
* ...

`Special:Properties`:
* `Has type`
* `Allows value`
* `Has query`
* ...

Create Page `Property:Has X` with `[[Has type::X]]`.  
Create `Subject` wikipage with `Value`/`Object` `[[Has X::Value|Display-Value]]` is called annotating.  

`{{#show: Subject |?Has X}}` shows a `Value/Object`.  

```
{{#ask: [[Has X::+]] [[Subject]] <!---->
 [[Category:X]] <!--selects Pages-->
 [[Has X::+]] <!--selects Pages-->
 |?=X|+width=40% <!--formatting mainlabel column-->
 |?Has X=year|+align=center|+width=5% <!--query conditions;column labels;alignment;width-->
 |intro=Bla bla bla <!--sentence above the table-->
 |mainlabel=X  <!--first column name-->
 |searchlabel=... X <!--custom expand table text-->
 |default=<b>No X have been stored yet.</b> <!--text if there is nothing to display-->
 |headers=plain <!--remove column label links-->
 |sort=Has X, Has Y <!--sort by column-->
 |order=descending,ascending <!--order sort columns-->
 |limit=3 <!--show only a few rows-->
 |class=datatable <!--enables +width=x% formatting-->
 |outro=  {{#ask: Second-Query }} <!--create a download link-->
}}

Second-Query:
{{#ask:
 |... <!--similar to the previous query-->
 |searchlabel=... X <!--download link text-->
 |format=csv <!--download format-->
}}
```

### [Download Tutorial PDF](https://www.semantic-mediawiki.org/w/images/8/80/20171004_Beginners_tutorial_to_Semantic_MediaWiki.pdf)
