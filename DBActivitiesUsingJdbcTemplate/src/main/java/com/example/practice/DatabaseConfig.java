package com.gurucul.d3;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {
   @Bean(name = "mysql")
   @ConfigurationProperties(prefix = "spring.mysql")
   @Primary
   public DataSource mysqlDatasource() {
      return DataSourceBuilder.create().build();
   }
   @Bean(name = "crate")
   @ConfigurationProperties(prefix = "spring.crate")
   public DataSource crateDatasource() {
      return DataSourceBuilder.create().build();
   }
   @Bean(name = "mysqlService")
   @Autowired
   public JdbcTemplate createMysqlJdbcTemplate(@Qualifier("mysql") DataSource mysqlDS) {
      return new JdbcTemplate(mysqlDS);
   }
   @Bean(name = "crateService")
   @Autowired
   public JdbcTemplate createCrateJdbcTemplate(@Qualifier("crate") DataSource crateDS) {
      return new JdbcTemplate(crateDS);
   }
}