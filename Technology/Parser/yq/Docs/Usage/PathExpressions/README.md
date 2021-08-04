## [Path Expressions](https://mikefarah.gitbook.io/yq/usage/path-expressions)

Simple expressions:
* `a.b.c`
* `a.b[1].c`
* `a.b[+].c`
* `a.b[-1].c`

Splat:
* `a.*.c`
* `bob.item*.cats`
* `a.b[*].c`

Deep splat:
* `a.**.c`

Search by children nodes:
* `a.(b.d==cat).b.c`
* `a.(b.d==cat*).c`
* `animals(.==cat)`
* `animals(.==c*)`

Special characters:
* `'b."foo.bar"'`
