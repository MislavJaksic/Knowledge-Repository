package mocking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class UserServiceTest {
	// Test data: inputs and outputs
	User enabled_user = new User("enabled_id", "enabled_password_hash", true);
	User disabled_user = new User("disabled_id", "disabled_password_hash", false);

	String enabled_password = "enabled_password";
	String disabled_password = "disabled_password";
	
	UserRepository user_repository = createUserRepository();
	PasswordEncoder password_encoder = createPasswordEncoder();
	UserService user_service = new UserService(user_repository, password_encoder);
	
	
	
	// Mock classes and stub method behaviour
	UserRepository createUserRepository() {
		UserRepository mock = mock(UserRepository.class);

		when(mock.findById(this.enabled_user.getId())).thenReturn(this.enabled_user);
		when(mock.findById(this.disabled_user.getId())).thenReturn(this.disabled_user);

		return mock;
	}

	PasswordEncoder createPasswordEncoder() {
		PasswordEncoder mock = mock(PasswordEncoder.class);
		
		when(mock.encode(anyString())).thenReturn("random_password_hash");
		when(mock.encode(this.enabled_password)).thenReturn(this.enabled_user.getPasswordHash());
		when(mock.encode(this.disabled_password)).thenReturn(this.disabled_user.getPasswordHash());
		
		return mock;
	}

	
	
	@Nested
	class InvalidPasswordTests {
		@Test
		void isInvalidIdInvalidPassword() {
			assertFalse(user_service.isValidUser("", ""));
		}

		@Test
		void isInvalidIdValidPassword() {
			assertFalse(user_service.isValidUser("", enabled_password));
		}
		
		@Test
		void isValidIdInvalidPassword() {
			assertFalse(user_service.isValidUser(enabled_user.getId(), ""));
		}
	}
	
	@Nested
	class ValidPasswordTests {
		@Test
		void isValidEnabledPassword() {
			assertTrue(user_service.isValidUser(enabled_user.getId(), enabled_password));
		}
		
		@Test
		void isValidDisabledPassword() {
			assertFalse(user_service.isValidUser(disabled_user.getId(), disabled_password));
		}
	}
	
	@Nested
	class PasswordValidationBehaviourTests {
		@Test
		void isMethodCalled() {
			user_service.isValidUser(enabled_user.getId(), enabled_password);
			
			verify(user_repository).findById(enabled_user.getId());
			verify(password_encoder).encode(enabled_password);
		}
		
		@Test
		void isNotMethodCalled() {
			user_service.isValidUser(disabled_user.getId(), disabled_password);
			
			verifyZeroInteractions(password_encoder);
		}
	}
	
	@Nested
	class PasswordValidationInnerStateTests {
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		@Test
		void isPasswordCorrect() {
			String expected = enabled_password;
			
			user_service.isValidUser(enabled_user.getId(), expected);
			verify(password_encoder).encode(captor.capture());
			String actual = captor.getValue();
			
			assertEquals(expected, actual);
		}
	}
}
