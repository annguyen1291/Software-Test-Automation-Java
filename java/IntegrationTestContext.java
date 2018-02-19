package eu.company.hosel.bsl.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;

import eu.company.hosel.bsl.test.dao.UserDao;
import eu.company.hosel.bsl.test.dao.UserDaoImpl;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

/**
 * @author Martin.Pokorny
 */
@Configuration
@ComponentScan("net.serenitybdd.demo")
public class IntegrationTestContext {

/*    @Autowired
    private EnvironmentVariables environmentVariables;*/

    @Bean
    public EnvironmentVariables getSystemEnvironmentVariables() {
        return SystemEnvironmentVariables.createEnvironmentVariables();
    }

   /* @Bean
    public JdbcTemplate getBslJdbcTemplate() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environmentVariables.getProperty("db.driver"));
        dataSource.setUrl(environmentVariables.getProperty("db.url"));
        dataSource.setUsername(environmentVariables.getProperty("db.username"));
        dataSource.setPassword(environmentVariables.getProperty("db.password"));
        return new JdbcTemplate(dataSource);
    }*/
    
    @Bean
    public UserDao getUserDaoImpl(){
    	return new UserDaoImpl();
    }
    
    
}
