/*
 * AppTest.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck;

import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.riskysolid.lavishduck.config.Config;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Config.class})
public class ApplicationTest {

    @MockBean
    DataSource mockDatasource;

    @MockBean
    FilterRegistrationBean mockFilterRegistrationBean;

    @Test
    public void applicationContextLoad() {
        assertTrue(true);
    }
}
