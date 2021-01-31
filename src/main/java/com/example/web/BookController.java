package com.example.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.model.*;

public class BookController {
	@RequestMapping("/index")
	public String book(Model model) {
		return "index";
	}
}
