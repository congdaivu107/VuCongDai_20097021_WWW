/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author longt
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.client")
@PropertySource({"classpath:application.properties"})
public class ConfigApp implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path photo = Paths.get("/Photo-BaiTapLon/");
        Path image = Paths.get("/Image-BaiTapLon/");
        String pathPhoto = photo.toFile().getAbsolutePath();
        String pathImage = image.toFile().getAbsolutePath();
        registry.addResourceHandler("/Image-BaiTapLon/**")
                .addResourceLocations("file:/"+pathImage+"/");
        registry.addResourceHandler("/Photo-BaiTapLon/**")
                .addResourceLocations("file:/"+pathPhoto+"/");
        registry.addResourceHandler("/Resources/**")
                .addResourceLocations("/Resources/");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private Environment environment;

    @Bean
    public DataSource myDataSource() {
//        Khoi tao
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
//        set dirver la jdbc
        try {
            myDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
//        Config jdbc
        myDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        myDataSource.setUser(environment.getProperty("jdbc.user"));
        myDataSource.setPassword(environment.getProperty("jdbc.password"));
//        Set connection pool 
        myDataSource.setInitialPoolSize(environment.getProperty("connection.pool.initialPoolSize", int.class));
        myDataSource.setMinPoolSize(environment.getProperty("connection.pool.minPoolSize", int.class));
        myDataSource.setMaxPoolSize(environment.getProperty("connection.pool.maxPoolSize", int.class));
        myDataSource.setMaxIdleTime(environment.getProperty("connection.pool.maxIdleTime", int.class));
        return myDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        Set data source
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
//        Create properties
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.current_session_context_class", environment.getProperty("hibernate.current_session_context_class"));
//        Set properties
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        Set transaction manager
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10000000);
        return multipartResolver;
    }
}
