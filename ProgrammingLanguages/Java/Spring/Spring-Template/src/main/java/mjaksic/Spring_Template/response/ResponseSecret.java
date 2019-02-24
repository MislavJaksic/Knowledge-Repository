package mjaksic.Spring_Template.response;

public class ResponseSecret {
	private final int number;
	private final String passphrase;
	
	
	
	public ResponseSecret(int number, String passphrase) {
		this.number = number;
		this.passphrase = passphrase;
	}
	
	
	
	public int getNumber() {
		return number;
	}
	public String getPassphrase() {
		return passphrase;
	}
}
