package com.dendnight.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dendnight.LoginInfo;
import com.dendnight.basis.model.User;
import com.dendnight.basis.service.UserService;

@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		LoginInfo info = new LoginInfo();
		info.setUsertype("ADMIN");
		info.setId(1);

		User user = new User();
		user.setNickname("Dendnight");
		user.setUsername("dendnight");
		user.setPassword("123");
		try {
			userService.add(user, info);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// fail("Not yet implemented");
	}

}
