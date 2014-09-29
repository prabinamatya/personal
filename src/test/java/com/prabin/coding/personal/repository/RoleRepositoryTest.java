package com.prabin.coding.personal.repository;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prabin.coding.personal.context.BaseEntitiesTest;
import com.prabin.coding.personal.entity.Role;
import com.prabin.coding.personal.entity.User;

public class RoleRepositoryTest extends BaseEntitiesTest {

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
