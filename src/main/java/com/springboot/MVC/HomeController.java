package com.springboot.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Home Controller is called.");
		return "index.jsp";//Telling Dispatcher Servlet that we need to call index.jsp --> Downloading the jsp page.
	}

}
