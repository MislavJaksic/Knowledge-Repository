## [yq](https://github.com/mikefarah/yq)

### Install

#### Linux

```
$: snap install yq
```

### Usage

```
# Note: piping `|` and `-`

$: yq yq-Operation File-Name.yaml Path-Expression | yq yq-Operation - Path-Expression | ...
```

```
$: yq delete File-Name.yaml Path-Expression
```

[Path Expressions](Docs/Usage/PathExpressions)
