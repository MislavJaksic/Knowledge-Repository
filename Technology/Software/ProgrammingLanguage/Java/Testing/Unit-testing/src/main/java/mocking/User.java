package mocking;

public class User {
	private String id;
	private String password_hash;
	private boolean enabled;

	
	
	public User(String id, String password_hash, boolean enabled) {
		this.id = id;
		this.password_hash = password_hash;
		this.enabled = enabled;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswordHash() {
		return password_hash;
	}

	public void setPasswordHash(String password_hash) {
		this.password_hash = password_hash;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}