package web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"controller", "components", "dao", "exception"})
@Import(DataBaseConfiguration.class)
public class AppConfig {
}
