package pl.kodolamacz.spring.dao.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by acacko on 04.11.17
 */
@Configuration
public class PersistanceConfig {

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
