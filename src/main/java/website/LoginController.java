package website;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController
{
	@RequestMapping("/login")
	public String index()
	{
		//TODO
		return "Login";
	}
}
