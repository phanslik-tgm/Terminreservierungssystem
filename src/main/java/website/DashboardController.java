package website;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

public class DashboardController
{
	@RequestMapping("/dashboard")
	public String index()
	{
		return "Dashboard";
	}
}
