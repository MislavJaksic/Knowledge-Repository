## [Temporary directories and files](https://docs.pytest.org/en/stable/tmpdir.html)  

### The `tmp_path` fixture

`tmp_path` is a `pathlib.Path` built-in fixture that provides a temporary directory unique to the test invocation.  

```
CONTENT = "content"
def test_create_file(tmp_path):
    d = tmp_path / "sub"
    d.mkdir()
    p = d / "hello.txt"
    p.write_text(CONTENT)
    assert p.read_text() == CONTENT
    assert len(list(tmp_path.iterdir())) == 1
```

### The `tmp_path_factory` fixture

`tmp_path_factory` is a `pathlib.Path` instance session-scoped fixture for creating temporary directories from any other fixture or test.  

### The ‘tmpdir’ fixture

`py` library recommends using `tmp_path`.  

### The ‘tmpdir_factory’ fixture

`py` library recommends using `tmp_path_factory`.  

### The default base temporary directory

Temporary directories are by default created as sub-directories of the system temporary directory.  

The base name will be `pytest-NUM` where `NUM` will be incremented with each test run and only the last three will be kept.  
