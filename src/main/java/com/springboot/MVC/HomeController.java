package com.springboot.MVC;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("add")
	public String add(HttpServletRequest req)
	{
		System.out.println("Add Controller is called.");
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int num3 = i + j;
		HttpSession session = req.getSession();//Set value through seesion and send back.
		session.setAttribute("num3", num3);
		return "result.jsp";//or return "result.jsp?num3"+num3;
	}

}
