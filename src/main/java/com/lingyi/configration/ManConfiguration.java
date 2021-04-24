package com.lingyi.configration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.lingyi.dao.man"}, sqlSessionTemplateRef  = "manSqlSessionTemplate")
public class ManConfiguration {

    @Bean(name = "manDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.man")
    public DataSource manDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "manSqlSessionFactory")
    public SqlSessionFactory manSqlSessionFactory(@Qualifier("manDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/man/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "manTransactionManager")
    public DataSourceTransactionManager manTransactionManager(@Qualifier("manDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "manSqlSessionTemplate")
    public SqlSessionTemplate manSqlSessionTemplate(@Qualifier("manSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
