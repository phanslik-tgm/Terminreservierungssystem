package website;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EventController
{
	@RequestMapping("/event")
	public String index()
	{
		//TODO
		return "Event";
	}
    
}