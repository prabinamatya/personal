package com.prabin.coding.personal.context;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.prabin.coding.personal.config.Initializer;
import com.prabin.coding.personal.config.WebAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppConfig.class, Initializer.class })
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@WebAppConfiguration
public abstract class BaseEntitiesTest {

}
