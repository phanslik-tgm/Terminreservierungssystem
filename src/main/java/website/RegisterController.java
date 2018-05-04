package website;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

public class RegisterController
{
	@RequestMapping("/register")
	public String index()
	{
		//TODO
		return "Register";
	}
}
