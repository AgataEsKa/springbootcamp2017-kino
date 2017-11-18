package pl.kodolamacz.spring.dao.repository.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by acacko on 04.11.17
 */
@Configuration
@EnableTransactionManagement // odpowiednik <tx:annotation-driven /> w XML
@EnableJpaRepositories(basePackages = "pl.kodolamacz.spring.dao")
@Profile("postgres")  // -> możliwość oznaczenia profilem per @Bean
// aby aktywować -> w VM options: -Dspring.profiles.active=postgres
public class PersistancePostgresBaseConfig extends PersistanceBaseConfig {

    //    gdybyśmy chcieli np. Postgres zamiast naszego Mocka Bazy
    //  System.getenv("DATABASE_URL") <-- zaczytuje dane ze zmiennych środowiskowych (HEROKU)
    //  https://devcenter.heroku.com/articles/heroku-postgresql#connecting-in-java
    @Bean
    @Primary
    public DataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
//    to samo co:
//    <bean id="dataSource"
//        class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//
//        <property name="driverClassName" value="com.mysql.jdbc.Driver" />
//        <property name="url" value="jdbc:mysql://localhost:3306/mkyongjava" />
//        <property name="username" value="root" />
//        <property name="password" value="password" />
//	  </bean>

}
