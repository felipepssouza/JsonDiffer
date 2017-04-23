package br.com.felipe.config;

import org.springframework.stereotype.Component;

@Component
public class DataSourceConfigJPA implements DataSourceConfig {

    @Override
    public String getDialect() {
        return "org.hibernate.dialect.MySQL5Dialect";
    }

    @Override
    public String getDriverClassName() {
        return "com.mysql.jdbc.Driver";
    }

    @Override
    public String getUrl() {
        return "jdbc:mysql://localhost:3306/meld";
    }

    @Override
    public String getUser() {
        return "root";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public int getPollMaxSize() {
        return 100;
    }

    @Override
    public int getPollMinIdleSize() {
        return 5;
    }

    @Override
    public String getDDLMode() {
        return "update";
    }
}
