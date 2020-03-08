package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list.....");
		model.addAttribute("list", service.getList());
		// service에서 정보를 얻어서 보내자 		
	}
	
	
	
	
}
