## [Testing made sweet with a Mockito](https://www.youtube.com/watch?v=DJDBl0vURD4)

Tests should be fast.  
Unit tests test only one thing.  
Tests either always fail or succeed.  

Isolate classes to increase reliability.  

```
Test double: doppelganger; pretends to be the real class

Test double types:
  Mock: generated; does nothing; verify behaviour
  Stub: hardcoded; returns responses; state verification
```

### Mock

```
RealObject mock_real_object = mock(RealObject.class);

OR

@Rule
public MockitoRule rule = MockitoJUnit.rule();
@Mock
public RealObject mock_real_object;
```

### Verify

```
Arrangement - setup mock
Action - do an action

verify(mock_real_object, [How-Many-Times]).doAction([_param1, _param2]);

How-Many-Times:
  # times
  # atLeast
  # atMost
  # ...
_paramX:
  # anyInt
  # anyString
  # eq
  # contains
  # start
  # isNotNull
```

You can test the order in which actions are executed.  

### Stubbing

```
when(mock_real_object.doAction()).thenReturn(_value);
                                 .thenThrow(_exception);
OR
given(mock_real_object.doAction()).willReturn(_value);
```

### Capturing arguments

```
# Note: use ONLY when you must
@Captor
public ArgumentCaptor<Response-Type> captor;

verify(mock_real_object).doAction(captor.capture());
Response-Type response = captor.getValue();

response.doAction();

verify(mock_real_object).doAction(captor.capture());
```

### Test data

```
public class TestUserData extends UserData {
  @Override
  public String getData1() {
    return "value"
  }
  ...
}
```

### Tips

Isolate untestable code.  
Don't use spies.  
Don't nest mocks.  
Setup a testing strategy.  
Avoid an object creating an object. It's impossible to test and mock those.  
```
DON'T:
public User(...) {
  this.internal_object = new InternalObject();
}

DO (dependency injection):
public User(InternalObject internal_object, ...) {
  if (internal_object == null) {
    ...
  }

  this.internal_object = internal_object;
}

DO (factory pattern):
public User(InternalObjectFactory internal_object_factory, ...) {
  this.internal_object = internal_object_factory.create();
}
```
