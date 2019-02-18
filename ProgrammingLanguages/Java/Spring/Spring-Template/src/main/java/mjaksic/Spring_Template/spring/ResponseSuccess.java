package mjaksic.Spring_Template.spring;

public class ResponseSuccess {
	private final boolean is_successful;
	
	
	
	public ResponseSuccess(boolean is_successful) {
		super();
		this.is_successful = is_successful;
	}
	
	
	
	public boolean isIs_successful() {
		return is_successful;
	}
	
	
	
	@Override
	public String toString() {
		return "ResponseSuccess [is_successful=" + is_successful + "]";
	}
}
