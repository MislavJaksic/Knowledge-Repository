## [Installation and Getting Started](https://docs.pytest.org/en/latest/getting-started.html)

### Install pytest

```
$: pip install -U pytest
$: pytest --version
```

### Create your first test

```
def func(x):
    return x + 2
def test_answer():
    assert func(3) == 5
```

```
$: pytest
```

### Run multiple tests

[Test discovery rules](../GoodIntegrationPractices)

### Assert that a certain exception is raised

```
import pytest
def f():
    raise SystemExit(1)
def test_mytest():
    with pytest.raises(SystemExit):
        f()
```

### Group multiple tests in a class

Group for:
* Test organization
* Sharing fixtures for tests only in that particular class
* Applying marks at the class level and having them implicitly apply to all tests

Each test has a unique instance of the class.

```
class TestClass:
    def test_one(self):
        x = "this"
        assert "h" in x
    def test_two(self):
        x = "hello"
        assert hasattr(x, "check")
```

### Request a unique temporary directory for functional tests

```
def test_needsfiles(tmpdir):
    print(tmpdir)
    assert 0
```
