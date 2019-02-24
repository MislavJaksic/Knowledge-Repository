package mjaksic.Spring_Template.response;

public class ResponseData {
	private final int number;
    private final String text;
    
    
    
	public ResponseData(int number, String text) {
		this.number = number;
		this.text = text;
	}
	
	
	
	public int getNumber() {
		return number;
	}
	public String getText() {
		return text;
	}
	
	
	
	@Override
	public String toString() {
		return "ResponseData [number=" + number + ", text=" + text + "]";
	}
}
