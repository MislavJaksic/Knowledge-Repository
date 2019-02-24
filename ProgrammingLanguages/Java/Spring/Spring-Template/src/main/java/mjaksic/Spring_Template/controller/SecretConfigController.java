package mjaksic.Spring_Template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mjaksic.Spring_Template.configuration.CustomProperties;
import mjaksic.Spring_Template.response.ResponseSecret;

@RestController
public class SecretConfigController {
	@Autowired
	private CustomProperties config;
	
	
	
	@GetMapping("/secret")
	public ResponseSecret GetSecretConfigNumber() {
		ResponseSecret answer = new ResponseSecret(config.getSecretNumber(), config.getSecretPassphrase());
		return answer;
	}
}
