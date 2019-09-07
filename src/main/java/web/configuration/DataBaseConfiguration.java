package web.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {

    @Bean(name = "data-source")
    public DataSource createDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:8080/db");

        return dataSource;
    }

    @Bean(name = "template")
    public JdbcTemplate jdbcTemplate(@Qualifier("data-source") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
