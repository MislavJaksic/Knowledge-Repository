## [Good Integration Practices](https://docs.pytest.org/en/latest/goodpractices.html)


Install package with pip

For development, we recommend you use venv for virtual environments and pip for installing your application and any dependencies, as well as the pytest package itself. This ensures your code and dependencies are isolated from your system Python installation.

Next, place a setup.py file in the root of your package with the following minimum content:

from setuptools import setup, find_packages

setup(name="PACKAGENAME", packages=find_packages())

Where PACKAGENAME is the name of your package. You can then install your package in "editable" mode by running from the same directory:

pip install -e .

which lets you change your source code (both tests and application) and rerun tests at will. This is similar to running python setup.py develop or conda develop in that it installs your package using a symlink to your development code.
Conventions for Python test discovery

pytest implements the following standard test discovery:

    If no arguments are specified then collection starts from testpaths (if configured) or the current directory. Alternatively, command line arguments can be used in any combination of directories, file names or node ids.

    Recurse into directories, unless they match norecursedirs.

    In those directories, search for test_*.py or *_test.py files, imported by their test package name.

    From those files, collect test items:

        test prefixed test functions or methods outside of class

        test prefixed test functions or methods inside Test prefixed test classes (without an __init__ method)

For examples of how to customize your test discovery Changing standard (Python) test discovery.

Within Python modules, pytest also discovers tests using the standard unittest.TestCase subclassing technique.
Choosing a test layout / import rules

pytest supports two common test layouts:
Tests outside application code

Putting tests into an extra directory outside your actual application code might be useful if you have many functional tests or for other reasons want to keep tests separate from actual application code (often a good idea):

setup.py
mypkg/
    __init__.py
    app.py
    view.py
tests/
    test_app.py
    test_view.py
    ...

This has the following benefits:

    Your tests can run against an installed version after executing pip install ..

    Your tests can run against the local copy with an editable install after executing pip install --editable ..

    If you don't have a setup.py file and are relying on the fact that Python by default puts the current directory in sys.path to import your package, you can execute python -m pytest to execute the tests against the local copy directly, without using pip.

Note

See Invoking pytest versus python -m pytest for more information about the difference between calling pytest and python -m pytest.

Note that this scheme has a drawback if you are using prepend import mode (which is the default): your test files must have unique names, because pytest will import them as top-level modules since there are no packages to derive a full package name from. In other words, the test files in the example above will be imported as test_app and test_view top-level modules by adding tests/ to sys.path.

If you need to have test modules with the same name, you might add __init__.py files to your tests folder and subfolders, changing them to packages:

setup.py
mypkg/
    ...
tests/
    __init__.py
    foo/
        __init__.py
        test_view.py
    bar/
        __init__.py
        test_view.py

Now pytest will load the modules as tests.foo.test_view and tests.bar.test_view, allowing you to have modules with the same name. But now this introduces a subtle problem: in order to load the test modules from the tests directory, pytest prepends the root of the repository to sys.path, which adds the side-effect that now mypkg is also importable.

This is problematic if you are using a tool like tox to test your package in a virtual environment, because you want to test the installed version of your package, not the local code from the repository.

In this situation, it is strongly suggested to use a src layout where application root package resides in a sub-directory of your root:

setup.py
src/
    mypkg/
        __init__.py
        app.py
        view.py
tests/
    __init__.py
    foo/
        __init__.py
        test_view.py
    bar/
        __init__.py
        test_view.py

This layout prevents a lot of common pitfalls and has many benefits, which are better explained in this excellent blog post by Ionel Cristian Mărieș.

Note

The new --import-mode=importlib (see Import modes) doesn't have any of the drawbacks above because sys.path and sys.modules are not changed when importing test modules, so users that run into this issue are strongly encouraged to try it and report if the new option works well for them.

The src directory layout is still strongly recommended however.
Tests as part of application code

Inlining test directories into your application package is useful if you have direct relation between tests and application modules and want to distribute them along with your application:

setup.py
mypkg/
    __init__.py
    app.py
    view.py
    test/
        __init__.py
        test_app.py
        test_view.py
        ...

In this scheme, it is easy to run your tests using the --pyargs option:

pytest --pyargs mypkg

pytest will discover where mypkg is installed and collect tests from there.

Note that this layout also works in conjunction with the src layout mentioned in the previous section.

Note

You can use Python3 namespace packages (PEP420) for your application but pytest will still perform test package name discovery based on the presence of __init__.py files. If you use one of the two recommended file system layouts above but leave away the __init__.py files from your directories it should just work on Python3.3 and above. From "inlined tests", however, you will need to use absolute imports for getting at your application code.

Note

In prepend and append import-modes, if pytest finds a "a/b/test_module.py" test file while recursing into the filesystem it determines the import name as follows:

    determine basedir: this is the first "upward" (towards the root) directory not containing an __init__.py. If e.g. both a and b contain an __init__.py file then the parent directory of a will become the basedir.

    perform sys.path.insert(0, basedir) to make the test module importable under the fully qualified import name.

    import a.b.test_module where the path is determined by converting path separators / into "." characters. This means you must follow the convention of having directory and file names map directly to the import names.

The reason for this somewhat evolved importing technique is that in larger projects multiple test modules might import from each other and thus deriving a canonical import name helps to avoid surprises such as a test module getting imported twice.

With --import-mode=importlib things are less convoluted because pytest doesn't need to change sys.path or sys.modules, making things much less surprising.
tox

Once you are done with your work and want to make sure that your actual package passes all tests you may want to look into tox, the virtualenv test automation tool and its pytest support. tox helps you to setup virtualenv environments with pre-defined dependencies and then executing a pre-configured test command with options. It will run tests against the installed package and not against your source code checkout, helping to detect packaging glitches.
