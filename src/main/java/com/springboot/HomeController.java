package com.springboot;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Alien;

@Controller
public class HomeController {
	
	@ModelAttribute
	public void ModelData(Model m)
	{
		m.addAttribute("name", "Pranjali");
		//before calling any request mapping this will be called and name will be present from the beginning and can be fetched in current session.
	}
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Home Controller is called.");
		return "index";//Telling Dispatcher Servlet that we need to call index.jsp --> Downloading the jsp page.
	}
	
	/*@RequestMapping("add")
	public String add(HttpServletRequest req)
	{
		System.out.println("Add Controller is called.");
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int num3 = i + j;
		HttpSession session = req.getSession();//Set value through seesion and send back.
		session.setAttribute("num3", num3);
		return "result.jsp";//or return "result.jsp?num3"+num3;
	}*/
	
	/*@RequestMapping("add")
	public String add(@RequestParam("num1")int i,@RequestParam("num2")int j , HttpSession session)
	{
		//Same as we can pass HttpServletRequest object in parameter we can do the same for HTTP SESSION.
		//@RequestParam will assign value getting from a parameter called num1 to i and num2 to j-- Fetching from Address Bar.
		System.out.println("Add Controller2 is called.");
		int num3 = i + j;
		session.setAttribute("num3", num3);
		return "result.jsp";
	}*/
	
	/*@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1")int i, @RequestParam("num2")int j)
	{
		System.out.println("Add Controller3 is called.");
		ModelAndView mv = new ModelAndView();
		//Use ModelAndView to eliminate the use of HttpSession. Set view and model data in one go.
		mv.setViewName("result");
		//View set. or ModelAndView mv = new ModelAndView("result.jsp"); -- Can be passed in Parameter itself.
		int num3 = i + j;
		mv.addObject("num3", num3);//Model data object
		return mv;
	}*/
	@RequestMapping("add")
	public String add(@RequestParam("num1")int i, @RequestParam("num2")int j, Model m)
	{
		System.out.println("Add Controller4 is called.");
		//Use Model when we don't know if the data will be used by the view or we can use ModelMap to arrange every data in the form of MAP.
		int num3 = i + j;
		m.addAttribute("num3", num3);//Model data object
		return "result";
	}
	
	/*@RequestMapping("addAlien")
	public String addAlien(@RequestParam("aid")int aid, @RequestParam("aname")String aname, Model m)
	{
		System.out.println("Add Controller5 is called.");
		Alien a = new Alien();
		a.setAid(aid);
		a.setAname(aname);
		m.addAttribute("alien", a);//Model data object
		return "result";
	}*/

	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("alien") Alien a)
	{
		System.out.println("Add Controller5 is called.");
		//Model Attribute adds data to alien object on its own and sets it as a model too , but if object name doesn't match then we can 
		//change it by @ModelAttribute("alien") Alien a , or if we remove @ModelAttribute as a whole and Alien class matches name with alien.
		return "result";
	}
	/*
	 * @PostMapping is used for post methods.
	 * @RequestMapping can do both get or post.
	 * we can make changes in request mapping  but passing end-point name as value.
	 * value="getAliens", method=RequestMethod.GET;
	 * or value="getAliens", method=RequestMethod.POST;
	 */
	@GetMapping("getAliens")
	public String getAlien(Model m)
	{
		System.out.println("Add Controller6 is called.");
		List<Alien> aliens = Arrays.asList(new Alien(1,"Pranjali"), new Alien(2,"Abul")); 
		m.addAttribute("aliens", aliens);
		return "getAliens";
	}

}
