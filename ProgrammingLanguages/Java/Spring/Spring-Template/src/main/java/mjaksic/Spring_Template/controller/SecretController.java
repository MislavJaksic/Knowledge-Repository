package mjaksic.Spring_Template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mjaksic.Spring_Template.config.ExternalConfig;
import mjaksic.Spring_Template.response.ResponseSecret;

/*
 * Autowired -> dependency injection
 */
@RestController
public class SecretController {
	private ExternalConfig config;
	
	
	
	@Autowired
	public SecretController(ExternalConfig config) {
		this.config = config;
	}
	
	@GetMapping("/secret")
	public ResponseSecret GetSecretConfigNumber() {
		ResponseSecret answer = new ResponseSecret(config.getSecretNumber(), config.getSecretPassphrase());
		return answer;
	}
}
