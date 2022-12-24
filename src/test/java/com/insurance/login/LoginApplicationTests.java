package com.insurance.login;

import com.insurance.login.Service.UserService;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApplicationTests {

	@Test
	void validateLoginSuccessTest() {
		/*UserService service = new UserService();
		JSONObject userCreds = new JSONObject();
		userCreds.put("username","Abhishek");
		userCreds.put("password","Abhishek123");
		JSONObject response = service.validate(userCreds);
		assertEquals(response.get("Msg").toString(),"Success")*/;

	}

}
