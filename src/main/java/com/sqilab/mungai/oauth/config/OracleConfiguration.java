package com.sqilab.mungai.oauth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

/**
 * Created by mungai on 17/07/2017.
 */
@Configuration
@ConfigurationProperties("oracle")
@Data
public class OracleConfiguration {
    @NotNull
    String username;
    @NotNull
    String password;
    @NotNull
    String url;
}
