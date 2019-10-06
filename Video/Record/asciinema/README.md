## [Asciinema](https://asciinema.org/)

Record and playback terminal output.  

```
$: sudo apt-get install asciinema
```

```
$: asciinema rec demo.cast
# Note: type "exit" or press CTRL+D end the recording

$: asciinema play demo.cast

$: asciinema upload demo.cast
```

### Editing

```
{"version": 2, "width": A, "height": B, "timestamp": C, "idle_time_limit": Max-Sec-No-Output, "env": D, "title": "Project-Title"}
...
[[5.5, "o", "Hello world!\n"]]
...
```
