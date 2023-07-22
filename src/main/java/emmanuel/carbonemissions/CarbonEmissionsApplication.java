package emmanuel.carbonemissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "emmanuel.carbonemissions.window")
public class CarbonEmissionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarbonEmissionsApplication.class, args);
	}

}
