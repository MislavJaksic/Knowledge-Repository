### [Testing](https://ci.apache.org/projects/flink/flink-docs-release-1.13/docs/dev/datastream/testing/#junit-rule-miniclusterwithclientresource)

#### Testing user Defined Functions

##### Unit Testing Stateless, Timeless UDFs

Simple.  

##### Unit Testing Stateful or Timely UDFs & Custom Operators

Add the appropriate dependencies.  

```
public class StatefulFlatMapTest {
    private OneInputStreamOperatorTestHarness<Long, Long> testHarness;
    private StatefulFlatMap statefulFlatMapFunction;

    @Before
    public void setupTestHarness() throws Exception {
        statefulFlatMapFunction = new StatefulFlatMapFunction();
        testHarness = new OneInputStreamOperatorTestHarness<>(new StreamFlatMap<>(statefulFlatMapFunction));
        testHarness.getExecutionConfig().setAutoWatermarkInterval(50);
        testHarness.open();
    }

    @Test
    public void testingStatefulFlatMapFunction() throws Exception {
        testHarness.processElement(2L, 100L);  // push (timestamped) element
        testHarness.processWatermark(100L);  // advance event time and trigger event time timers
        testHarness.setProcessingTime(100L);  // advance processing time and trigger processing time timers
        assertThat(testHarness.getOutput(), containsInExactlyThisOrder(3L));  // retrieve list of emitted records for assertions

        //retrieve list of records emitted to a specific side output for assertions (ProcessFunction only)
        //assertThat(testHarness.getSideOutput(new OutputTag<>("invalidRecords")), hasSize(0))
    }
}

public class StatefulFlatMapFunctionTest {
    private OneInputStreamOperatorTestHarness<String, Long, Long> testHarness;
    private StatefulFlatMap statefulFlatMapFunction;

    @Before
    public void setupTestHarness() throws Exception {
        statefulFlatMapFunction = new StatefulFlatMapFunction();
        testHarness = new KeyedOneInputStreamOperatorTestHarness<>(new StreamFlatMap<>(statefulFlatMapFunction), new MyStringKeySelector(), Types.STRING);
        testHarness.open();
    }

    // Tests
    // ...

}
```

##### Unit Testing ProcessFunction

```
public static class PassThroughProcessFunction extends ProcessFunction<Integer, Integer> {

	@Override
	public void processElement(Integer value, Context ctx, Collector<Integer> out) throws Exception {
        out.collect(value);
	}
}

public class PassThroughProcessFunctionTest {

    @Test
    public void testPassThrough() throws Exception {
        PassThroughProcessFunction processFunction = new PassThroughProcessFunction();
        OneInputStreamOperatorTestHarness<Integer, Integer> harness = ProcessFunctionTestHarnesses
        	.forProcessFunction(processFunction);
        harness.processElement(1, 10);  // push (timestamped) element
        assertEquals(harness.extractOutputValues(), Collections.singletonList(1));  // retrieve list of emitted records for assertions
    }
}
```

#### Testing Flink Jobs