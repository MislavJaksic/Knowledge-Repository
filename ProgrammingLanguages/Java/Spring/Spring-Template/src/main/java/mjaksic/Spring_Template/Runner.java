package mjaksic.Spring_Template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Visit http://localhost:8080/swagger-ui.html to see the REST interface
 * Send HTTP requests using, for example, Postman
 */

/*
 * SpringBootApplication -> scan packages for components and auto configures and registers configuration Beans
 */
@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }
}
