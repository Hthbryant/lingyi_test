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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.lingyi.dao.player"}, sqlSessionTemplateRef  = "playerSqlSessionTemplate")
public class PlayerConfiguration {

    @Bean(name = "playerDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.player")
    public DataSource playerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "playerSqlSessionFactory")
    @Primary
    public SqlSessionFactory playerSqlSessionFactory(@Qualifier("playerDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/player/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "playerTransactionManager")
    @Primary
    public DataSourceTransactionManager playerTransactionManager(@Qualifier("playerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "playerSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate playerSqlSessionTemplate(@Qualifier("playerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
