package com.kyle.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		int count = 1;
		if (session.getAttribute("countX") == null) {
			session.setAttribute("countX", count);
		}
		else {
			session.setAttribute("countX", (int)session.getAttribute("countX")+1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}
}
