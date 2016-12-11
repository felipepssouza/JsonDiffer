package br.com.felipe.config;

public interface DataSourceConfig {

    String getDialect();

    String getDriverClassName();

    String getUrl();

    String getUser();

    String getPassword();

    int getPollMaxSize();

    int getPollMinIdleSize();

    String getDDLMode();

}
