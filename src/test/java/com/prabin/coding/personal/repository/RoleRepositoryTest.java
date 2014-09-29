package com.prabin.coding.personal.repository;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.prabin.coding.personal.config.Initializer;
import com.prabin.coding.personal.config.WebAppConfig;
import com.prabin.coding.personal.entity.Role;
import com.prabin.coding.personal.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppConfig.class, Initializer.class })
@Transactional
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository testObject;

	@Test
	public void testSave() {
		Role roleCreated = createRole();
		Role savedRole = testObject.saveAndFlush(roleCreated);

		assertEquals("testuser", savedRole.getName());

		List<Role> findAll = testObject.findAll();
		assertEquals(1, findAll.size());

	}

	private Role createRole() {
		Role role = new Role();
		role.setName("testuser");
		role.setUsers(createUsers());
		return role;
	}

	private List<User> createUsers() {
		User user = new User();
		user.setEmail("pnamatya@gmail.com");
		user.setName("testuser");
		user.setPassword("passwd");
		return Arrays.asList(user);
	}

}
