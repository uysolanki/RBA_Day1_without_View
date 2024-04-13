package com.rbaintro.RoleBasedAuthorisationIntroduction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	
	@GetMapping("/getAPI")
	public String greet()
	{
		return "GET API Invoked";
	}
	
	@GetMapping("/insertAPI")
	public String insert()
	{
		return "Insert API Invoked";
	}
	
	@GetMapping("/updateAPI")
	public String update()
	{
		return "Update API Invoked";
	}
	
	@GetMapping("/deleteAPI")
	public String delete()
	{
		return "Delete API Invoked";
	}
	
	@RequestMapping("/unauthUser")
	public String unauthUser()
	{
		return "Sorry, You do not have Access to this Page";
	}
}
