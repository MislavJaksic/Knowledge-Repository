## [jq](https://stedolan.github.io/jq/)

Like `sed` for JSON data: slice, filter and map data.  

### Install

[Download](https://stedolan.github.io/jq/download/), then make it executable using `chmod +x jq` or just run it.  

#### Scoop for Windows

```
$: scoop install jq
```

WARNING! On Windows, you need to escape the double quotes `"` like so `\"`. If you don't do this you'll get an error `jq: error: String-You-Did-Not-Escape/0 is not defined at <top-level>, line 1:`.  

### [Tutorial](https://stedolan.github.io/jq/tutorial/)

```
$: jq '.'  # select all
$: jq '.[0]'  # select first
$: jq '.[0] | {message: .commit.message, name: .commit.committer.name}'  # select first, access fields and construct a new object
$: jq '[].[0] | {message: ..., name: ...}]'  # collect previous results into a single array
```

### Commands

When creating commands, always construct them piece by piece and check their output.  

```
$: jq -c '. | select(.foo | contains("bar")) | select(.alice | contains("bruce"))'  # output JSONs that contain the value 'bar' in key 'foo' and ...
```

```
$: cat input.json | jq [-s] -c 'sort_by(.Key-Name) | .[]' > output.json  # sort JSONs by value
```
