## [Mockito](https://site.mockito.org/)

### Setup

#### Gradle

```
repositories { jcenter() }
dependencies { testCompile "org.mockito:mockito-core:2.+" }
```

#### Maven

```
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>3.0.0</version>
</dependency>
```

### [Testing made sweet with a Mockito](https://www.youtube.com/watch?v=DJDBl0vURD4)

Test should be fast.  
Unit tests should test only one thing.  
Tests should either always fail or succssed.  

Isolate classes to increase reliability.  

```
Test double - doppleganger; pretends to be the real class
```

Test double types:
```
Mock - generated; does nothing; verify behaviour
Stub - hardcoded; returns responses; state verification
```

Mock:
```
RealObject mock_real_object = mock(RealObject.class);

OR

@Rule
public MockitoRule rule = MockitoJUnit.rule();
@Mock
public RealObject mock_real_object;
```

Verify:
```
Arrangement - setup mock
Action - do an action

verify(mock_real_object, [How-Many-Times]).doAction([_param1, _param2]);
```
Can test order of actions.  

How-Many-Times: times, atLeast, atMost, ...
_paramX: anyInt, anyString, eq, contains, start, isNotNull, and, ... - argument matcher

Stubbing:
```
when(mock_real_object.doAction()).thenReturn(_value);
                                 .thenThrow(_exception);
OR
given(mock_real_object.doAction()).willReturn(_value);
```

Capturing arguments (use only when you need to):
```
@Captor
public ArgumentCaptor<Response-Type> captor;

verify(mock_real_object).doAction(captor.capture());
Response-Type response = captor.getValue();

response.doAction();

verify(mock_real_object).doAction(captor.capture());
```

Test data:
```
public class TestUserData extends UserData {
  @Override
  public String getData1() {
    return "value"
  }
  ...
}
```

Avoid an object creating an object. It is impossible to test.  
```
DON'T:
public User(...) {
  this.internal_object = new InternalObject();
}

DO(dependency injection):
public User(InternalObject internal_object, ...) {
  if (internal_object == null) {
    ...
  }
  
  this.internal_object = internal_object;
}

DO(factory pattern):
public User(InternalObjectFactory internal_object_factory, ...) {
  this.internal_object = internal_object_factory.create();
}
```

Isolate untestable code.  
Don't use spies.  
Don't nest mocks.  
Setup a testing strategy.  
