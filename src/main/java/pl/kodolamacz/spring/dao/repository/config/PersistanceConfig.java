package pl.kodolamacz.spring.dao.repository.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by acacko on 04.11.17
 */
@Configuration
@EnableTransactionManagement // odpowiednik <tx:annotation-driven /> w XML
@PropertySource({"classpath:db/hibernate.properties"})
public class PersistanceConfig {

    @Autowired
    private Environment env;

//    @Bean
//    public NamedParameterJdbcTemplate getJdbcTemplate() {
//        return new NamedParameterJdbcTemplate(getHSQLDataSource());
//    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        // LocalSessionFactoryBean implementuje FactoryBean<SessionFactory>
        // czyli wie jak wyprodukować SessionFactory

        LocalSessionFactoryBean localSessionFactoryBean =
                new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getHSQLDataSource());
        localSessionFactoryBean.setPackagesToScan("pl.kodolamacz.spring.dao");
        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());

        return localSessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) { // bierze z LocalSessionFactoryBean
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties getHibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//                setProperty("hibernate.globally_quoted_identifiers", "true");   <--- not working with it
                setProperty("hibernate.default_schema", "PUBLIC");
                setProperty("show_sql", "true");
//                setProperty("hibernate.jdbc.use_streams_for_binary", "true");
//                setProperty("hibernate.jdbc.batch_size", "1000");
            }
        };
    }



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
