package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
	Calculator calculator = new Calculator(); // fixture; instantiated for each test
	
	public static Stream<Arguments> numberProvider() {
		return Stream.of(
				Arguments.of(1, 2, 3),
				Arguments.of(4, 5, 9)
				);
	}
	
	@BeforeEach
	void reset() { // set object state before every test
		calculator.reset();
	}
	
	@Test
	@DisplayName("1 + 1 = 2")
	void onePlusOne() {
		int expected = 2;
		
		int actual = calculator.add(1).add(1).result();
		
		String message = "1 + 1 equals 2";
		
		assertEquals(expected, actual, message);
	}
	
	
	
	@ParameterizedTest
	@MethodSource("numberProvider")
	public void massAddTest(int a, int b, int expected) { // vary arguments, let the test stay the same
		assertEquals(expected, calculator.add(a).add(b).result());
	}
	
	@RepeatedTest(5)
	void repeatAddTest() {
		int expected = -11;
		
		int actual = calculator.add(-5).add(-6).result();
		
		String message = "-5 + -6 should equal -11";
		assertEquals(expected, actual, message);
	}
	
	@Nested
	class SubtractTests{
		// ...		
	}
}
