package com.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.purchase.entity.User;
import com.purchase.service.UserServiceInterface;

@RestController
public class UserController {
	@Autowired
	private UserServiceInterface userService;
	
	@RequestMapping("/user/regist")
	public String regist(String username,String password,String email) {
		User user = new User();
		user.setMAIL_ADDRESS(email);
		user.setPASSWORD(password);
		user.setUSER_NAME(username);
		userService.addUser(user);
		System.out.println("consle---/user/regist");
		return "registSucceful";
	}
	
    @RequestMapping("/")
    @ResponseBody
    public String getHello() {
        return "hello";
    }
}
