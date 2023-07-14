package com.example.shopping_platform_II;

import com.example.shopping_platform_II.service.ifs.UserService;
import com.example.shopping_platform_II.vo.UpdateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest(classes = ShoppingPlatformIiApplication.class)
class UserTest {
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender javaMailSender;

	@Test
	void mailTest(){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("a321006363@yahoo.com.tw");
		message.setTo("yu86923@gmail.com");
		message.setSubject("主旨: Hello Yu-Zhe");
		message.setText("內容: 測試拉測試");

		javaMailSender.send(message);
	}
    @Test
    void updateTest() {
//		String account = "Nancy1234";
//		String pwd ="NANCY123@";
//		UpdateRequest request = new UpdateRequest(account,pwd);
//	userService.updatePwd(request);
    }

}
