package testing;

public class Calculator {
	private int reset_value = 0;
	
	private int last_result;
	
	
	
	public Calculator() {
		this.last_result = this.reset_value;
	}
	
	
	
	public Calculator add(int a) {
		this.last_result += a;
		return this;
	}
	
	public Calculator subtract(int a) {
		this.last_result -= a;
		return this;
	}
	
	
	
	public int result() {
		return this.last_result;
	}
	
	public void reset() {
		this.last_result = this.reset_value;
	}
}
