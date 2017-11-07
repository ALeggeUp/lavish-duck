/*
 * Config.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.config;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.riskysolid.lavishduck.filter.JwtFilter;

@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class Config {

    protected static final String PREFIX = "lavish.duck";

    private static final Log LOG = LogFactory.getLog(Config.class);

    @Autowired
    private AppProperties properties;

    @Bean
    DataSource datasource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("embedded");
        dataSource.setPassword("embedded");
        dataSource.setUrl("jdbc:h2:~/embeddedLavishDuckDb;DB_CLOSE_ON_EXIT=FALSE");
        LOG.debug("Initialized datasource " + properties.getName());

        return dataSource;
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
