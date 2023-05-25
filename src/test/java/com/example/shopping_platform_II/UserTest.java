package com.example.shopping_platform_II;

import com.example.shopping_platform_II.service.ifs.UserService;
import com.example.shopping_platform_II.vo.UpdateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ShoppingPlatformIiApplication.class)
class UserTest {
@Autowired
private UserService userService;

	@Test
	void updateTest() {
		String account = "Nancy1234";
		String pwd ="NANCY123@";
		UpdateRequest request = new UpdateRequest(account,pwd);
	userService.updatePwd(request);
	}

}
