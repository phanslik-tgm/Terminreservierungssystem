package website;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CreateEventController
{
	@RequestMapping("/createevent")
	public String index()
	{
		//TODO
		return "Create Event";
	}
    
}
