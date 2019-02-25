package mjaksic.Spring_Template.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * Configuration -> registers configuration
 * PropertySource -> location of the _name.properties file; classpath is "src/main/resources/..."
 * ConfigurationProperties -> configuration prefix
 */
@Configuration
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties("custom")
public class ExternalConfig {
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