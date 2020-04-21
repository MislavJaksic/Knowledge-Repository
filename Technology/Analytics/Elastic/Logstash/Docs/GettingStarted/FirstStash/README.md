## [Stashing your first event](https://www.elastic.co/guide/en/logstash/current/first-event.html)

You will use:
* an input plugin to consume
* a filter plugin to modify
* an output plugin to produce

```
$: pwd  # -> ../path/to/logstash-x.y.z

$: bin/logstash -e 'input { stdin { } } output { stdout {} }' [--path.data Writable-Path]
```

Stop with `CTRL+D`.  
