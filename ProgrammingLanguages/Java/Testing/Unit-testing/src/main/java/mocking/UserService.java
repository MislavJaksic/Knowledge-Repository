package mocking;

public class UserService {
	private final UserRepository user_repository;
	private final PasswordEncoder password_encoder;

	
	
	
	public UserService(UserRepository user_repository, PasswordEncoder password_encoder) {
		this.user_repository = user_repository;
		this.password_encoder = password_encoder;
	}

	
	
	public boolean isValidUser(String id, String password) {
		User user = user_repository.findById(id);
		return isEnabledUser(user) && isValidPassword(user, password);
	}

	private boolean isEnabledUser(User user) {
		return user != null && user.isEnabled();
	}

	private boolean isValidPassword(User user, String password) {
		String encodedPassword = password_encoder.encode(password);
		return encodedPassword.equals(user.getPasswordHash());
	}
}
