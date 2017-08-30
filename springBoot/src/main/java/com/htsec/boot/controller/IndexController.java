package com.htsec.boot.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.htsec.boot.controller.bo.UserBo;

@Controller
public class IndexController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", "thymeleaf模板");
		
		 List<UserBo> list = new ArrayList<UserBo>(); 
	        for(int i=0;i<10;i++) {
	        	UserBo bo = new UserBo();
	        	bo.setId(Long.parseLong(""+i));
	        	bo.setName("name"+i);
	        	bo.setCode("code"+i);
	        	list.add(bo);
	        }
	     model.addAttribute("users", "list");
		return "index";
	}

}
