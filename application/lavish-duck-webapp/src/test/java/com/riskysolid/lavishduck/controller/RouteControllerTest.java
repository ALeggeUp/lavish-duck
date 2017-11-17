/*
 * RouteControllerTest.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.riskysolid.lavishduck.config.Config;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Config.class})
@WebAppConfiguration
public class RouteControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @MockBean
    DataSource mockDatasource;

    @MockBean
    FilterRegistrationBean mockFilterRegistrationBean;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new RouteController()).build();
    }

    @Test
    public void testFrontendRoutes() throws Exception {

        final List<String> routes = Arrays.asList(
                "/login",
                "/create",
                "/existing",
                "/intro",
                "/more");

        for (final String route : routes) {
            this.mockMvc.perform(get(route))
            .andExpect(status().isOk())
            .andExpect(view().name("forward:/index.html"))
            .andExpect(forwardedUrl("/index.html"))
            .andExpect(content().string(""));
        }
    }
}
