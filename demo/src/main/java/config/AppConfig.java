package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public DataSource MySqlDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("myDbUrl");
        dataSourceBuilder.username("myDbUser");
        dataSourceBuilder.password("myDbPass");
        return dataSourceBuilder.build();

    }
    @Autowired
    DataSource datasource;
}
