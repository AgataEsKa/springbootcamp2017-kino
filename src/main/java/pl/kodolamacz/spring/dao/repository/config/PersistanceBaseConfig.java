package pl.kodolamacz.spring.dao.repository.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by acacko on 18.11.17
 */
public class PersistanceBaseConfig {

  @Bean
  public PropertiesFactoryBean jpaProperties() {
    PropertiesFactoryBean factoryBean =  new PropertiesFactoryBean();
    factoryBean.setLocation(new ClassPathResource("db/jpa.properties"));
    return factoryBean;
  }

  @Bean
  @Autowired
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties jpaProperties) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setPackagesToScan("pl.kodolamacz.spring.dao");
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaProperties(jpaProperties);
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    return entityManagerFactoryBean;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

}
