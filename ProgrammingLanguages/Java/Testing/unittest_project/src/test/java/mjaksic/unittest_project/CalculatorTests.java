package mjaksic.unittest_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {
	/*
	 * Instantiated for each test. A fixture.
	 */
	Calculator calculator = new Calculator();
	
	/*
	 * Group up tests into a class.
	 */
	@Nested
	class AddOperation{
		/*
		 * Set object state before every test.
		 */
		@BeforeEach
		void SetLastResult() {
			calculator.SetResult(-1);
		}
		
		/*
		 * Typical unit test.
		 */
		@Test
		@DisplayName("1 + 1 = 2")
		void AddOneAndOne() {
			int expected = 2;
			
			int actual = calculator.Add(1, 1);
			
			String message = "1 + 1 should equal 2";
			
			assertEquals(expected, actual, message);
		}

		/*
		 * Set a pattern. Write the input parameters in that pattern.
		 */
		@ParameterizedTest(name = "{0} + {1} = {2}")
		@CsvSource({ "0,1,1", "1,2,3", "49,51,100", "1,100,101" })
		void AddMany(int first, int second, int expected) {
			int actual = calculator.Add(first, second);
			String message = first + " + " + second + " should equal " + expected;
			assertEquals(expected, actual, message);
		}
		
		/*
		 * Repeat the test multiple times.
		 */
		@RepeatedTest(5)
		void AddMultipleTimes() {
			int expected = -11;
			
			int actual = calculator.Add(-5, -6);
			
			String message = "-5 + -6 should equal -11";
			assertEquals(expected, actual, message);
		}
	}
	
	/*
	 * Another group of tests.
	 */
	@Nested
	class AdminOperations {
		@Test
		void LastResultIsZero() {
			int expected = 0;
			
			int actual = calculator.GetResult();
			
			assertEquals(expected, actual);
		}
		
		@Test
		void LastResultIsNonZero() {
			int expected = -5;
			
			calculator.SetResult(-5);
			
			int actual = calculator.GetResult();
			
			assertEquals(expected, actual);
		}
	}
}