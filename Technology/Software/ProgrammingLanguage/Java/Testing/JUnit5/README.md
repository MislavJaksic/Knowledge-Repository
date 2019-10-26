## [JUnit5](https://junit.org/junit5/)

### Setup

#### Gradle

```
testImplementation 'org.junit.jupiter:junit-jupiter:5.5.1'
```

#### Maven

```
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.5.1</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

### IDE: Eclipse

You can generate JUnit tests with:
```
Select class -> File -> New... -> JUnit Test Case -> ...
```

### Annotations

```
BeforeAll - build up before any other build ups or test
BeforeEach - build up before each test

Test - assert what is true
RepeatedTest - repeat the assertion

ParameterizedTest - one test; many different inputs
MethodSource - input generator

AfterEach - tear down after each test
AfterAll - teat down after all other tears downs or tests

Nested - for test organization
DisplayName - custom test name
```

### Assertions

```
assertEquals
assertArrayEquals
assertTrue
assertThrows
assertTimeout
```