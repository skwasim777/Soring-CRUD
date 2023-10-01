package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.bean.EmpBean;
import com.spring.dao.EmpDao;

@Controller
public class EmpController {
	@Autowired
	// will inject dao from xml
	EmpDao dao;

	// it desplay from to input data
	@RequestMapping("/empform")
	public String showForm(Model m) {
		m.addAttribute("command", new EmpBean());
		return "empform";
	}
	// it saves object into database
	  @RequestMapping(value="/save",method = RequestMethod.POST)   
	public String save(@ModelAttribute("emp")EmpDao emp) {
		  dao.save(emp);
		  return "";
	}
}
