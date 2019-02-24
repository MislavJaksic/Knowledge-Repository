package mjaksic.Spring_Template.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties("custom")
public class CustomProperties {
	private int secretNumber;
	private String secretPassphrase;
	
	
	
	public int getSecretNumber() {
		return secretNumber;
	}
	
	public void setSecretNumber(int secretNumber) {
		this.secretNumber = secretNumber;
	}
	
	public String getSecretPassphrase() {
		return secretPassphrase;
	}
	
	public void setSecretPassphrase(String secretPassphrase) {
		this.secretPassphrase = secretPassphrase;
	}
}