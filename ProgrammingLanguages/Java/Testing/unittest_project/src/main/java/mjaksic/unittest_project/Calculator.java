package mjaksic.unittest_project;

public class Calculator {
	private int last_result;
	
	public int Add(int a, int b) {
		int result = a + b;
		this.SetResult(result);
		return result;
	}
	
	public int GetResult() {
		return this.last_result;
	}
	
	public void SetResult(int result) {
		this.last_result = result;
	}
}