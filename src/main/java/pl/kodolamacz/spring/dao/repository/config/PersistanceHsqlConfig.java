package pl.kodolamacz.spring.dao.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by acacko on 04.11.17
 */
@Configuration
@EnableTransactionManagement // odpowiednik <tx:annotation-driven /> w XML
@EnableJpaRepositories(basePackages = "pl.kodolamacz.spring.dao")
// aby aktywować -> w VM options: -Dspring.profiles.active=hsql
public class PersistanceHsqlConfig extends PersistanceBaseConfig {

    @Bean
    public DataSource getHSQLDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("db/schema.sql")
            .addScript("db/insertData.sql")
            .build();
    }
}
