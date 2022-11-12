package com.prueba.pruebamary.configuracion;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Value("${usr}")
    private String usuario;

    @Value("${cls}")
    private String clave;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;databaseName=marylu;trustServerCertificate=true");
        dataSourceBuilder.username(usuario);
        dataSourceBuilder.password(clave);
        return dataSourceBuilder.build();

    }
}
