package uemf.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;





@SpringBootApplication

/*                    external property sources    */

/*
@PropertySources({
  @PropertySource("classpath:application.properties")
  , @PropertySource(value = "file:C:\\Users\\hindberouyat\\OneDrive\\Bureau\\Hanae Berouylat\\CompileTest\\application.properties",
  ignoreResourceNotFound = true)
}) */
public class SanProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanProjectApplication.class, args);
	}

}
