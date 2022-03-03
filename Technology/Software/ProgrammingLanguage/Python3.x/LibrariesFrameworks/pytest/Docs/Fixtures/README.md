## [pytest fixtures: explicit, modular, scalable](https://docs.pytest.org/en/stable/fixture.html)

Pytest fixtures:
* initialize a test state
* are access through arguments/parameters
* have names, scopes,
* are modular and can be nested
* are reusable and scalable

Pytest has many built-in fixtures.  

### Fixtures as Function arguments

Test functions can receive fixture objects by naming them as an input argument. For each argument name, a fixture function with that name provides the fixture object. Fixture functions are registered by marking them with @pytest.fixture. Let's look at a simple self-contained test module containing a fixture and a test function using it:

# content of ./test_smtpsimple.py
import pytest


@pytest.fixture
def smtp_connection():
    import smtplib

    return smtplib.SMTP("smtp.gmail.com", 587, timeout=5)


def test_ehlo(smtp_connection):
    response, msg = smtp_connection.ehlo()
    assert response == 250
    assert 0  # for demo purposes

Here, the test_ehlo needs the smtp_connection fixture value. pytest will discover and call the @pytest.fixture marked smtp_connection fixture function. Running the test looks like this:

$ pytest test_smtpsimple.py
=========================== test session starts ============================
platform linux -- Python 3.x.y, pytest-6.x.y, py-1.x.y, pluggy-0.x.y
cachedir: $PYTHON_PREFIX/.pytest_cache
rootdir: $REGENDOC_TMPDIR
collected 1 item

test_smtpsimple.py F                                                 [100%]

================================= FAILURES =================================
________________________________ test_ehlo _________________________________

smtp_connection = <smtplib.SMTP object at 0xdeadbeef>

    def test_ehlo(smtp_connection):
        response, msg = smtp_connection.ehlo()
        assert response == 250
>       assert 0  # for demo purposes
E       assert 0

test_smtpsimple.py:14: AssertionError
========================= short test summary info ==========================
FAILED test_smtpsimple.py::test_ehlo - assert 0
============================ 1 failed in 0.12s =============================

In the failure traceback we see that the test function was called with a smtp_connection argument, the smtplib.SMTP() instance created by the fixture function. The test function fails on our deliberate assert 0. Here is the exact protocol used by pytest to call the test function this way:

    pytest finds the test test_ehlo because of the test_ prefix. The test function needs a function argument named smtp_connection. A matching fixture function is discovered by looking for a fixture-marked function named smtp_connection.

    smtp_connection() is called to create an instance.

    test_ehlo(<smtp_connection instance>) is called and fails in the last line of the test function.

Note that if you misspell a function argument or want to use one that isn't available, you'll see an error with a list of available function arguments.

Note

You can always issue:

pytest --fixtures test_simplefactory.py

to see available fixtures (fixtures with leading _ are only shown if you add the -v option).
Fixtures: a prime example of dependency injection

Fixtures allow test functions to easily receive and work against specific pre-initialized application objects without having to care about import/setup/cleanup details. It's a prime example of dependency injection where fixture functions take the role of the injector and test functions are the consumers of fixture objects.
conftest.py: sharing fixture functions

If during implementing your tests you realize that you want to use a fixture function from multiple test files you can move it to a conftest.py file. You don't need to import the fixture you want to use in a test, it automatically gets discovered by pytest. The discovery of fixture functions starts at test classes, then test modules, then conftest.py files and finally builtin and third party plugins.

You can also use the conftest.py file to implement local per-directory plugins.
Sharing test data

If you want to make test data from files available to your tests, a good way to do this is by loading these data in a fixture for use by your tests. This makes use of the automatic caching mechanisms of pytest.

Another good approach is by adding the data files in the tests folder. There are also community plugins available to help managing this aspect of testing, e.g. pytest-datadir and pytest-datafiles.
Scope: sharing fixtures across classes, modules, packages or session

Fixtures requiring network access depend on connectivity and are usually time-expensive to create. Extending the previous example, we can add a scope="module" parameter to the @pytest.fixture invocation to cause the decorated smtp_connection fixture function to only be invoked once per test module (the default is to invoke once per test function). Multiple test functions in a test module will thus each receive the same smtp_connection fixture instance, thus saving time. Possible values for scope are: function, class, module, package or session.

The next example puts the fixture function into a separate conftest.py file so that tests from multiple test modules in the directory can access the fixture function:

# content of conftest.py
import pytest
import smtplib


@pytest.fixture(scope="module")
def smtp_connection():
    return smtplib.SMTP("smtp.gmail.com", 587, timeout=5)

The name of the fixture again is smtp_connection and you can access its result by listing the name smtp_connection as an input parameter in any test or fixture function (in or below the directory where conftest.py is located):

# content of test_module.py


def test_ehlo(smtp_connection):
    response, msg = smtp_connection.ehlo()
    assert response == 250
    assert b"smtp.gmail.com" in msg
    assert 0  # for demo purposes


def test_noop(smtp_connection):
    response, msg = smtp_connection.noop()
    assert response == 250
    assert 0  # for demo purposes

We deliberately insert failing assert 0 statements in order to inspect what is going on and can now run the tests:

$ pytest test_module.py
=========================== test session starts ============================
platform linux -- Python 3.x.y, pytest-6.x.y, py-1.x.y, pluggy-0.x.y
cachedir: $PYTHON_PREFIX/.pytest_cache
rootdir: $REGENDOC_TMPDIR
collected 2 items

test_module.py FF                                                    [100%]

================================= FAILURES =================================
________________________________ test_ehlo _________________________________

smtp_connection = <smtplib.SMTP object at 0xdeadbeef>

    def test_ehlo(smtp_connection):
        response, msg = smtp_connection.ehlo()
        assert response == 250
        assert b"smtp.gmail.com" in msg
>       assert 0  # for demo purposes
E       assert 0

test_module.py:7: AssertionError
________________________________ test_noop _________________________________

smtp_connection = <smtplib.SMTP object at 0xdeadbeef>

    def test_noop(smtp_connection):
        response, msg = smtp_connection.noop()
        assert response == 250
>       assert 0  # for demo purposes
E       assert 0

test_module.py:13: AssertionError
========================= short test summary info ==========================
FAILED test_module.py::test_ehlo - assert 0
FAILED test_module.py::test_noop - assert 0
============================ 2 failed in 0.12s =============================

You see the two assert 0 failing and more importantly you can also see that the same (module-scoped) smtp_connection object was passed into the two test functions because pytest shows the incoming argument values in the traceback. As a result, the two test functions using smtp_connection run as quick as a single one because they reuse the same instance.

If you decide that you rather want to have a session-scoped smtp_connection instance, you can simply declare it:

@pytest.fixture(scope="session")
def smtp_connection():
    # the returned fixture value will be shared for
    # all tests needing it
    ...

Fixture scopes

Fixtures are created when first requested by a test, and are destroyed based on their scope:

    function: the default scope, the fixture is destroyed at the end of the test.

    class: the fixture is destroyed during teardown of the last test in the class.

    module: the fixture is destroyed during teardown of the last test in the module.

    package: the fixture is destroyed during teardown of the last test in the package.

    session: the fixture is destroyed at the end of the test session.

Note

Pytest only caches one instance of a fixture at a time, which means that when using a parametrized fixture, pytest may invoke a fixture more than once in the given scope.
Dynamic scope

New in version 5.2.

In some cases, you might want to change the scope of the fixture without changing the code. To do that, pass a callable to scope. The callable must return a string with a valid scope and will be executed only once - during the fixture definition. It will be called with two keyword arguments - fixture_name as a string and config with a configuration object.

This can be especially useful when dealing with fixtures that need time for setup, like spawning a docker container. You can use the command-line argument to control the scope of the spawned containers for different environments. See the example below.

def determine_scope(fixture_name, config):
    if config.getoption("--keep-containers", None):
        return "session"
    return "function"


@pytest.fixture(scope=determine_scope)
def docker_container():
    yield spawn_container()

Order: Higher-scoped fixtures are instantiated first

Within a function request for fixtures, those of higher-scopes (such as session) are instantiated before lower-scoped fixtures (such as function or class). The relative order of fixtures of same scope follows the declared order in the test function and honours dependencies between fixtures. Autouse fixtures will be instantiated before explicitly used fixtures.

Consider the code below:

import pytest

# fixtures documentation order example
order = []


@pytest.fixture(scope="session")
def s1():
    order.append("s1")


@pytest.fixture(scope="module")
def m1():
    order.append("m1")


@pytest.fixture
def f1(f3):
    order.append("f1")


@pytest.fixture
def f3():
    order.append("f3")


@pytest.fixture(autouse=True)
def a1():
    order.append("a1")


@pytest.fixture
def f2():
    order.append("f2")


def test_order(f1, m1, f2, s1):
    assert order == ["s1", "m1", "a1", "f3", "f1", "f2"]

The fixtures requested by test_order will be instantiated in the following order:

    s1: is the highest-scoped fixture (session).

    m1: is the second highest-scoped fixture (module).

    a1: is a function-scoped autouse fixture: it will be instantiated before other fixtures within the same scope.

    f3: is a function-scoped fixture, required by f1: it needs to be instantiated at this point

    f1: is the first function-scoped fixture in test_order parameter list.

    f2: is the last function-scoped fixture in test_order parameter list.

Fixture finalization / executing teardown code

pytest supports execution of fixture specific finalization code when the fixture goes out of scope. By using a yield statement instead of return, all the code after the yield statement serves as the teardown code:

# content of conftest.py

import smtplib
import pytest


@pytest.fixture(scope="module")
def smtp_connection():
    smtp_connection = smtplib.SMTP("smtp.gmail.com", 587, timeout=5)
    yield smtp_connection  # provide the fixture value
    print("teardown smtp")
    smtp_connection.close()

The print and smtp.close() statements will execute when the last test in the module has finished execution, regardless of the exception status of the tests.

Let's execute it:

$ pytest -s -q --tb=no
FFteardown smtp

========================= short test summary info ==========================
FAILED test_module.py::test_ehlo - assert 0
FAILED test_module.py::test_noop - assert 0
2 failed in 0.12s

We see that the smtp_connection instance is finalized after the two tests finished execution. Note that if we decorated our fixture function with scope='function' then fixture setup and cleanup would occur around each single test. In either case the test module itself does not need to change or know about these details of fixture setup.

Note that we can also seamlessly use the yield syntax with with statements:

# content of test_yield2.py

import smtplib
import pytest


@pytest.fixture(scope="module")
def smtp_connection():
    with smtplib.SMTP("smtp.gmail.com", 587, timeout=5) as smtp_connection:
        yield smtp_connection  # provide the fixture value

The smtp_connection connection will be closed after the test finished execution because the smtp_connection object automatically closes when the with statement ends.

Using the contextlib.ExitStack context manager finalizers will always be called regardless if the fixture setup code raises an exception. This is handy to properly close all resources created by a fixture even if one of them fails to be created/acquired:

# content of test_yield3.py

import contextlib

import pytest


@contextlib.contextmanager
def connect(port):
    ...  # create connection
    yield
    ...  # close connection


@pytest.fixture
def equipments():
    with contextlib.ExitStack() as stack:
        yield [stack.enter_context(connect(port)) for port in ("C1", "C3", "C28")]

In the example above, if "C28" fails with an exception, "C1" and "C3" will still be properly closed.

Note that if an exception happens during the setup code (before the yield keyword), the teardown code (after the yield) will not be called.

An alternative option for executing teardown code is to make use of the addfinalizer method of the request-context object to register finalization functions.

Here's the smtp_connection fixture changed to use addfinalizer for cleanup:

# content of conftest.py
import smtplib
import pytest


@pytest.fixture(scope="module")
def smtp_connection(request):
    smtp_connection = smtplib.SMTP("smtp.gmail.com", 587, timeout=5)

    def fin():
        print("teardown smtp_connection")
        smtp_connection.close()

    request.addfinalizer(fin)
    return smtp_connection  # provide the fixture value

Here's the equipments fixture changed to use addfinalizer for cleanup:

# content of test_yield3.py

import contextlib
import functools

import pytest


@contextlib.contextmanager
def connect(port):
    ...  # create connection
    yield
    ...  # close connection


@pytest.fixture
def equipments(request):
    r = []
    for port in ("C1", "C3", "C28"):
        cm = connect(port)
        equip = cm.__enter__()
        request.addfinalizer(functools.partial(cm.__exit__, None, None, None))
        r.append(equip)
    return r

Both yield and addfinalizer methods work similarly by calling their code after the test ends. Of course, if an exception happens before the finalize function is registered then it will not be executed.
Fixtures can introspect the requesting test context

Fixture functions can accept the request object to introspect the "requesting" test function, class or module context. Further extending the previous smtp_connection fixture example, let's read an optional server URL from the test module which uses our fixture:

# content of conftest.py
import pytest
import smtplib


@pytest.fixture(scope="module")
def smtp_connection(request):
    server = getattr(request.module, "smtpserver", "smtp.gmail.com")
    smtp_connection = smtplib.SMTP(server, 587, timeout=5)
    yield smtp_connection
    print("finalizing {} ({})".format(smtp_connection, server))
    smtp_connection.close()

We use the request.module attribute to optionally obtain an smtpserver attribute from the test module. If we just execute again, nothing much has changed:

$ pytest -s -q --tb=no
FFfinalizing <smtplib.SMTP object at 0xdeadbeef> (smtp.gmail.com)

========================= short test summary info ==========================
FAILED test_module.py::test_ehlo - assert 0
FAILED test_module.py::test_noop - assert 0
2 failed in 0.12s

Let's quickly create another test module that actually sets the server URL in its module namespace:

# content of test_anothersmtp.py

smtpserver = "mail.python.org"  # will be read by smtp fixture


def test_showhelo(smtp_connection):
    assert 0, smtp_connection.helo()

Running it:

$ pytest -qq --tb=short test_anothersmtp.py
F                                                                    [100%]
================================= FAILURES =================================
______________________________ test_showhelo _______________________________
test_anothersmtp.py:6: in test_showhelo
    assert 0, smtp_connection.helo()
E   AssertionError: (250, b'mail.python.org')
E   assert 0
------------------------- Captured stdout teardown -------------------------
finalizing <smtplib.SMTP object at 0xdeadbeef> (mail.python.org)
========================= short test summary info ==========================
FAILED test_anothersmtp.py::test_showhelo - AssertionError: (250, b'mail....

voila! The smtp_connection fixture function picked up our mail server name from the module namespace.
Using markers to pass data to fixtures

Using the request object, a fixture can also access markers which are applied to a test function. This can be useful to pass data into a fixture from a test:

import pytest


@pytest.fixture
def fixt(request):
    marker = request.node.get_closest_marker("fixt_data")
    if marker is None:
        # Handle missing marker in some way...
        data = None
    else:
        data = marker.args[0]

    # Do something with the data
    return data


@pytest.mark.fixt_data(42)
def test_fixt(fixt):
    assert fixt == 42

Factories as fixtures

The "factory as fixture" pattern can help in situations where the result of a fixture is needed multiple times in a single test. Instead of returning data directly, the fixture instead returns a function which generates the data. This function can then be called multiple times in the test.

Factories can have parameters as needed:

@pytest.fixture
def make_customer_record():
    def _make_customer_record(name):
        return {"name": name, "orders": []}

    return _make_customer_record


def test_customer_records(make_customer_record):
    customer_1 = make_customer_record("Lisa")
    customer_2 = make_customer_record("Mike")
    customer_3 = make_customer_record("Meredith")

If the data created by the factory requires managing, the fixture can take care of that:

@pytest.fixture
def make_customer_record():

    created_records = []

    def _make_customer_record(name):
        record = models.Customer(name=name, orders=[])
        created_records.append(record)
        return record

    yield _make_customer_record

    for record in created_records:
        record.destroy()


def test_customer_records(make_customer_record):
    customer_1 = make_customer_record("Lisa")
    customer_2 = make_customer_record("Mike")
    customer_3 = make_customer_record("Meredith")

Parametrizing fixtures

Fixture functions can be parametrized in which case they will be called multiple times, each time executing the set of dependent tests, i. e. the tests that depend on this fixture. Test functions usually do not need to be aware of their re-running. Fixture parametrization helps to write exhaustive functional tests for components which themselves can be configured in multiple ways.

Extending the previous example, we can flag the fixture to create two smtp_connection fixture instances which will cause all tests using the fixture to run twice. The fixture function gets access to each parameter through the special request object:

# content of conftest.py
import pytest
import smtplib


@pytest.fixture(scope="module", params=["smtp.gmail.com", "mail.python.org"])
def smtp_connection(request):
    smtp_connection = smtplib.SMTP(request.param, 587, timeout=5)
    yield smtp_connection
    print("finalizing {}".format(smtp_connection))
    smtp_connection.close()

The main change is the declaration of params with @pytest.fixture, a list of values for each of which the fixture function will execute and can access a value via request.param. No test function code needs to change. So let's just do another run:

$ pytest -q test_module.py
FFFF                                                                 [100%]
================================= FAILURES =================================
________________________ test_ehlo[smtp.gmail.com] _________________________

smtp_connection = <smtplib.SMTP object at 0xdeadbeef>

    def test_ehlo(smtp_connection):
        response, msg = smtp_connection.ehlo()
        assert response == 250
        assert b"smtp.gmail.com" in msg
>       assert 0  # for demo purposes
E       assert 0

test_module.py:7: AssertionError
________________________ test_noop[smtp.gmail.com] _________________________

smtp_connection = <smtplib.SMTP object at 0xdeadbeef>

    def test_noop(smtp_connection):
        response, msg = smtp_connection.noop()
        assert response == 250
>       assert 0  # for demo purposes
E       assert 0

test_module.py:13: AssertionError
________________________ test_ehlo[mail.python.org] ________________________

smtp_connection = <smtplib.SMTP object at 0xdeadbeef>

    def test_ehlo(smtp_connection):
        response, msg = smtp_connection.ehlo()
        assert response == 250
>       assert b"smtp.gmail.com" in msg
E       AssertionError: assert b'smtp.gmail.com' in b'mail.python.org\nPIPELINING\nSIZE 51200000\nETRN\nSTARTTLS\nAUTH DIGEST-MD5 NTLM CRAM-MD5\nENHANCEDSTATUSCODES\n8BITMIME\nDSN\nSMTPUTF8\nCHUNKING'

test_module.py:6: AssertionError
-------------------------- Captured stdout setup ---------------------------
finalizing <smtplib.SMTP object at 0xdeadbeef>
________________________ test_noop[mail.python.org] ________________________

smtp_connection = <smtplib.SMTP object at 0xdeadbeef>

    def test_noop(smtp_connection):
        response, msg = smtp_connection.noop()
        assert response == 250
>       assert 0  # for demo purposes
E       assert 0

test_module.py:13: AssertionError
------------------------- Captured stdout teardown -------------------------
finalizing <smtplib.SMTP object at 0xdeadbeef>
========================= short test summary info ==========================
FAILED test_module.py::test_ehlo[smtp.gmail.com] - assert 0
FAILED test_module.py::test_noop[smtp.gmail.com] - assert 0
FAILED test_module.py::test_ehlo[mail.python.org] - AssertionError: asser...
FAILED test_module.py::test_noop[mail.python.org] - assert 0
4 failed in 0.12s

We see that our two test functions each ran twice, against the different smtp_connection instances. Note also, that with the mail.python.org connection the second test fails in test_ehlo because a different server string is expected than what arrived.

pytest will build a string that is the test ID for each fixture value in a parametrized fixture, e.g. test_ehlo[smtp.gmail.com] and test_ehlo[mail.python.org] in the above examples. These IDs can be used with -k to select specific cases to run, and they will also identify the specific case when one is failing. Running pytest with --collect-only will show the generated IDs.

Numbers, strings, booleans and None will have their usual string representation used in the test ID. For other objects, pytest will make a string based on the argument name. It is possible to customise the string used in a test ID for a certain fixture value by using the ids keyword argument:

# content of test_ids.py
import pytest


@pytest.fixture(params=[0, 1], ids=["spam", "ham"])
def a(request):
    return request.param


def test_a(a):
    pass


def idfn(fixture_value):
    if fixture_value == 0:
        return "eggs"
    else:
        return None


@pytest.fixture(params=[0, 1], ids=idfn)
def b(request):
    return request.param


def test_b(b):
    pass

The above shows how ids can be either a list of strings to use or a function which will be called with the fixture value and then has to return a string to use. In the latter case if the function returns None then pytest's auto-generated ID will be used.

Running the above tests results in the following test IDs being used:

$ pytest --collect-only
=========================== test session starts ============================
platform linux -- Python 3.x.y, pytest-6.x.y, py-1.x.y, pluggy-0.x.y
cachedir: $PYTHON_PREFIX/.pytest_cache
rootdir: $REGENDOC_TMPDIR
collected 10 items

<Module test_anothersmtp.py>
  <Function test_showhelo[smtp.gmail.com]>
  <Function test_showhelo[mail.python.org]>
<Module test_ids.py>
  <Function test_a[spam]>
  <Function test_a[ham]>
  <Function test_b[eggs]>
  <Function test_b[1]>
<Module test_module.py>
  <Function test_ehlo[smtp.gmail.com]>
  <Function test_noop[smtp.gmail.com]>
  <Function test_ehlo[mail.python.org]>
  <Function test_noop[mail.python.org]>

======================= 10 tests collected in 0.12s ========================

Using marks with parametrized fixtures

pytest.param() can be used to apply marks in values sets of parametrized fixtures in the same way that they can be used with @pytest.mark.parametrize.

Example:

# content of test_fixture_marks.py
import pytest


@pytest.fixture(params=[0, 1, pytest.param(2, marks=pytest.mark.skip)])
def data_set(request):
    return request.param


def test_data(data_set):
    pass

Running this test will skip the invocation of data_set with value 2:

$ pytest test_fixture_marks.py -v
=========================== test session starts ============================
platform linux -- Python 3.x.y, pytest-6.x.y, py-1.x.y, pluggy-0.x.y -- $PYTHON_PREFIX/bin/python
cachedir: $PYTHON_PREFIX/.pytest_cache
rootdir: $REGENDOC_TMPDIR
collecting ... collected 3 items

test_fixture_marks.py::test_data[0] PASSED                           [ 33%]
test_fixture_marks.py::test_data[1] PASSED                           [ 66%]
test_fixture_marks.py::test_data[2] SKIPPED (unconditional skip)     [100%]

======================= 2 passed, 1 skipped in 0.12s =======================

Modularity: using fixtures from a fixture function

In addition to using fixtures in test functions, fixture functions can use other fixtures themselves. This contributes to a modular design of your fixtures and allows re-use of framework-specific fixtures across many projects. As a simple example, we can extend the previous example and instantiate an object app where we stick the already defined smtp_connection resource into it:

# content of test_appsetup.py

import pytest


class App:
    def __init__(self, smtp_connection):
        self.smtp_connection = smtp_connection


@pytest.fixture(scope="module")
def app(smtp_connection):
    return App(smtp_connection)


def test_smtp_connection_exists(app):
    assert app.smtp_connection

Here we declare an app fixture which receives the previously defined smtp_connection fixture and instantiates an App object with it. Let's run it:

$ pytest -v test_appsetup.py
=========================== test session starts ============================
platform linux -- Python 3.x.y, pytest-6.x.y, py-1.x.y, pluggy-0.x.y -- $PYTHON_PREFIX/bin/python
cachedir: $PYTHON_PREFIX/.pytest_cache
rootdir: $REGENDOC_TMPDIR
collecting ... collected 2 items

test_appsetup.py::test_smtp_connection_exists[smtp.gmail.com] PASSED [ 50%]
test_appsetup.py::test_smtp_connection_exists[mail.python.org] PASSED [100%]

============================ 2 passed in 0.12s =============================

Due to the parametrization of smtp_connection, the test will run twice with two different App instances and respective smtp servers. There is no need for the app fixture to be aware of the smtp_connection parametrization because pytest will fully analyse the fixture dependency graph.

Note that the app fixture has a scope of module and uses a module-scoped smtp_connection fixture. The example would still work if smtp_connection was cached on a session scope: it is fine for fixtures to use "broader" scoped fixtures but not the other way round: A session-scoped fixture could not use a module-scoped one in a meaningful way.
Automatic grouping of tests by fixture instances

pytest minimizes the number of active fixtures during test runs. If you have a parametrized fixture, then all the tests using it will first execute with one instance and then finalizers are called before the next fixture instance is created. Among other things, this eases testing of applications which create and use global state.

The following example uses two parametrized fixtures, one of which is scoped on a per-module basis, and all the functions perform print calls to show the setup/teardown flow:

# content of test_module.py
import pytest


@pytest.fixture(scope="module", params=["mod1", "mod2"])
def modarg(request):
    param = request.param
    print("  SETUP modarg", param)
    yield param
    print("  TEARDOWN modarg", param)


@pytest.fixture(scope="function", params=[1, 2])
def otherarg(request):
    param = request.param
    print("  SETUP otherarg", param)
    yield param
    print("  TEARDOWN otherarg", param)


def test_0(otherarg):
    print("  RUN test0 with otherarg", otherarg)


def test_1(modarg):
    print("  RUN test1 with modarg", modarg)


def test_2(otherarg, modarg):
    print("  RUN test2 with otherarg {} and modarg {}".format(otherarg, modarg))

Let's run the tests in verbose mode and with looking at the print-output:

$ pytest -v -s test_module.py
=========================== test session starts ============================
platform linux -- Python 3.x.y, pytest-6.x.y, py-1.x.y, pluggy-0.x.y -- $PYTHON_PREFIX/bin/python
cachedir: $PYTHON_PREFIX/.pytest_cache
rootdir: $REGENDOC_TMPDIR
collecting ... collected 8 items

test_module.py::test_0[1]   SETUP otherarg 1
  RUN test0 with otherarg 1
PASSED  TEARDOWN otherarg 1

test_module.py::test_0[2]   SETUP otherarg 2
  RUN test0 with otherarg 2
PASSED  TEARDOWN otherarg 2

test_module.py::test_1[mod1]   SETUP modarg mod1
  RUN test1 with modarg mod1
PASSED
test_module.py::test_2[mod1-1]   SETUP otherarg 1
  RUN test2 with otherarg 1 and modarg mod1
PASSED  TEARDOWN otherarg 1

test_module.py::test_2[mod1-2]   SETUP otherarg 2
  RUN test2 with otherarg 2 and modarg mod1
PASSED  TEARDOWN otherarg 2

test_module.py::test_1[mod2]   TEARDOWN modarg mod1
  SETUP modarg mod2
  RUN test1 with modarg mod2
PASSED
test_module.py::test_2[mod2-1]   SETUP otherarg 1
  RUN test2 with otherarg 1 and modarg mod2
PASSED  TEARDOWN otherarg 1

test_module.py::test_2[mod2-2]   SETUP otherarg 2
  RUN test2 with otherarg 2 and modarg mod2
PASSED  TEARDOWN otherarg 2
  TEARDOWN modarg mod2


============================ 8 passed in 0.12s =============================

You can see that the parametrized module-scoped modarg resource caused an ordering of test execution that lead to the fewest possible "active" resources. The finalizer for the mod1 parametrized resource was executed before the mod2 resource was setup.

In particular notice that test_0 is completely independent and finishes first. Then test_1 is executed with mod1, then test_2 with mod1, then test_1 with mod2 and finally test_2 with mod2.

The otherarg parametrized resource (having function scope) was set up before and teared down after every test that used it.
Use fixtures in classes and modules with usefixtures

Sometimes test functions do not directly need access to a fixture object. For example, tests may require to operate with an empty directory as the current working directory but otherwise do not care for the concrete directory. Here is how you can use the standard tempfile and pytest fixtures to achieve it. We separate the creation of the fixture into a conftest.py file:

# content of conftest.py

import os
import shutil
import tempfile

import pytest


@pytest.fixture
def cleandir():
    old_cwd = os.getcwd()
    newpath = tempfile.mkdtemp()
    os.chdir(newpath)
    yield
    os.chdir(old_cwd)
    shutil.rmtree(newpath)

and declare its use in a test module via a usefixtures marker:

# content of test_setenv.py
import os
import pytest


@pytest.mark.usefixtures("cleandir")
class TestDirectoryInit:
    def test_cwd_starts_empty(self):
        assert os.listdir(os.getcwd()) == []
        with open("myfile", "w") as f:
            f.write("hello")

    def test_cwd_again_starts_empty(self):
        assert os.listdir(os.getcwd()) == []

Due to the usefixtures marker, the cleandir fixture will be required for the execution of each test method, just as if you specified a "cleandir" function argument to each of them. Let's run it to verify our fixture is activated and the tests pass:

$ pytest -q
..                                                                   [100%]
2 passed in 0.12s

You can specify multiple fixtures like this:

@pytest.mark.usefixtures("cleandir", "anotherfixture")
def test():
    ...

and you may specify fixture usage at the test module level using pytestmark:

pytestmark = pytest.mark.usefixtures("cleandir")

It is also possible to put fixtures required by all tests in your project into an ini-file:

# content of pytest.ini
[pytest]
usefixtures = cleandir

Warning

Note this mark has no effect in fixture functions. For example, this will not work as expected:

@pytest.mark.usefixtures("my_other_fixture")
@pytest.fixture
def my_fixture_that_sadly_wont_use_my_other_fixture():
    ...

Currently this will not generate any error or warning, but this is intended to be handled by #3664.
Autouse fixtures (xUnit setup on steroids)

Occasionally, you may want to have fixtures get invoked automatically without declaring a function argument explicitly or a usefixtures decorator. As a practical example, suppose we have a database fixture which has a begin/rollback/commit architecture and we want to automatically surround each test method by a transaction and a rollback. Here is a dummy self-contained implementation of this idea:

# content of test_db_transact.py

import pytest


class DB:
    def __init__(self):
        self.intransaction = []

    def begin(self, name):
        self.intransaction.append(name)

    def rollback(self):
        self.intransaction.pop()


@pytest.fixture(scope="module")
def db():
    return DB()


class TestClass:
    @pytest.fixture(autouse=True)
    def transact(self, request, db):
        db.begin(request.function.__name__)
        yield
        db.rollback()

    def test_method1(self, db):
        assert db.intransaction == ["test_method1"]

    def test_method2(self, db):
        assert db.intransaction == ["test_method2"]

The class-level transact fixture is marked with autouse=true which implies that all test methods in the class will use this fixture without a need to state it in the test function signature or with a class-level usefixtures decorator.

If we run it, we get two passing tests:

$ pytest -q
..                                                                   [100%]
2 passed in 0.12s

Here is how autouse fixtures work in other scopes:

    autouse fixtures obey the scope= keyword-argument: if an autouse fixture has scope='session' it will only be run once, no matter where it is defined. scope='class' means it will be run once per class, etc.

    if an autouse fixture is defined in a test module, all its test functions automatically use it.

    if an autouse fixture is defined in a conftest.py file then all tests in all test modules below its directory will invoke the fixture.

    lastly, and please use that with care: if you define an autouse fixture in a plugin, it will be invoked for all tests in all projects where the plugin is installed. This can be useful if a fixture only anyway works in the presence of certain settings e. g. in the ini-file. Such a global fixture should always quickly determine if it should do any work and avoid otherwise expensive imports or computation.

Note that the above transact fixture may very well be a fixture that you want to make available in your project without having it generally active. The canonical way to do that is to put the transact definition into a conftest.py file without using autouse:

# content of conftest.py
@pytest.fixture
def transact(request, db):
    db.begin()
    yield
    db.rollback()

and then e.g. have a TestClass using it by declaring the need:

@pytest.mark.usefixtures("transact")
class TestClass:
    def test_method1(self):
        ...

All test methods in this TestClass will use the transaction fixture while other test classes or functions in the module will not use it unless they also add a transact reference.
Overriding fixtures on various levels

In relatively large test suite, you most likely need to override a global or root fixture with a locally defined one, keeping the test code readable and maintainable.
Override a fixture on a folder (conftest) level

Given the tests file structure is:

tests/
    __init__.py

    conftest.py
        # content of tests/conftest.py
        import pytest

        @pytest.fixture
        def username():
            return 'username'

    test_something.py
        # content of tests/test_something.py
        def test_username(username):
            assert username == 'username'

    subfolder/
        __init__.py

        conftest.py
            # content of tests/subfolder/conftest.py
            import pytest

            @pytest.fixture
            def username(username):
                return 'overridden-' + username

        test_something.py
            # content of tests/subfolder/test_something.py
            def test_username(username):
                assert username == 'overridden-username'

As you can see, a fixture with the same name can be overridden for certain test folder level. Note that the base or super fixture can be accessed from the overriding fixture easily - used in the example above.
Override a fixture on a test module level

Given the tests file structure is:

tests/
    __init__.py

    conftest.py
        # content of tests/conftest.py
        import pytest

        @pytest.fixture
        def username():
            return 'username'

    test_something.py
        # content of tests/test_something.py
        import pytest

        @pytest.fixture
        def username(username):
            return 'overridden-' + username

        def test_username(username):
            assert username == 'overridden-username'

    test_something_else.py
        # content of tests/test_something_else.py
        import pytest

        @pytest.fixture
        def username(username):
            return 'overridden-else-' + username

        def test_username(username):
            assert username == 'overridden-else-username'

In the example above, a fixture with the same name can be overridden for certain test module.
Override a fixture with direct test parametrization

Given the tests file structure is:

tests/
    __init__.py

    conftest.py
        # content of tests/conftest.py
        import pytest

        @pytest.fixture
        def username():
            return 'username'

        @pytest.fixture
        def other_username(username):
            return 'other-' + username

    test_something.py
        # content of tests/test_something.py
        import pytest

        @pytest.mark.parametrize('username', ['directly-overridden-username'])
        def test_username(username):
            assert username == 'directly-overridden-username'

        @pytest.mark.parametrize('username', ['directly-overridden-username-other'])
        def test_username_other(other_username):
            assert other_username == 'other-directly-overridden-username-other'

In the example above, a fixture value is overridden by the test parameter value. Note that the value of the fixture can be overridden this way even if the test doesn't use it directly (doesn't mention it in the function prototype).
Override a parametrized fixture with non-parametrized one and vice versa

Given the tests file structure is:

tests/
    __init__.py

    conftest.py
        # content of tests/conftest.py
        import pytest

        @pytest.fixture(params=['one', 'two', 'three'])
        def parametrized_username(request):
            return request.param

        @pytest.fixture
        def non_parametrized_username(request):
            return 'username'

    test_something.py
        # content of tests/test_something.py
        import pytest

        @pytest.fixture
        def parametrized_username():
            return 'overridden-username'

        @pytest.fixture(params=['one', 'two', 'three'])
        def non_parametrized_username(request):
            return request.param

        def test_username(parametrized_username):
            assert parametrized_username == 'overridden-username'

        def test_parametrized_username(non_parametrized_username):
            assert non_parametrized_username in ['one', 'two', 'three']

    test_something_else.py
        # content of tests/test_something_else.py
        def test_username(parametrized_username):
            assert parametrized_username in ['one', 'two', 'three']

        def test_username(non_parametrized_username):
            assert non_parametrized_username == 'username'

In the example above, a parametrized fixture is overridden with a non-parametrized version, and a non-parametrized fixture is overridden with a parametrized version for certain test module. The same applies for the test folder level obviously.
Using fixtures from other projects

Usually projects that provide pytest support will use entry points, so just installing those projects into an environment will make those fixtures available for use.

In case you want to use fixtures from a project that does not use entry points, you can define pytest_plugins in your top conftest.py file to register that module as a plugin.

Suppose you have some fixtures in mylibrary.fixtures and you want to reuse them into your app/tests directory.

All you need to do is to define pytest_plugins in app/tests/conftest.py pointing to that module.

pytest_plugins = "mylibrary.fixtures"

This effectively registers mylibrary.fixtures as a plugin, making all its fixtures and hooks available to tests in app/tests.

Note

Sometimes users will import fixtures from other projects for use, however this is not recommended: importing fixtures into a module will register them in pytest as defined in that module.

This has minor consequences, such as appearing multiple times in pytest --help, but it is not recommended because this behavior might change/stop working in future versions.
