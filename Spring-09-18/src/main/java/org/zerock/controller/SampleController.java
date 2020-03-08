package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;


@Controller
@RequestMapping("/sample/*") //redirect 할때 꼮 controller 매핑정보 잡아줘야해 
								// void 로 메소드를 만들 경우  views 에 sample이라는 매핑이름의 폴더를 만들어줘야 경로를 찾아감
								//String 타입의 경우 그냥 views 로찾아감
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("")
	public void basic() {
		logger.info("basic() Call . . . ");
		
		
	}
	
	@RequestMapping(value="/basic1", method= {RequestMethod.GET, RequestMethod.POST})
	public String basicGet1() {
		logger.info("basicGet() Call . . . ");
		
		return "basic1";
		
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		logger.info("basicGet() Call . . . ");
	}
	
	@GetMapping("basic2")
	public void basicGetOnly() {
		logger.info("basicGetOnly() Call . . . ");
	}
	
	@GetMapping("ex01")
	public String ex01(SampleDTO dto) {
		logger.info("SampleDTO :" + dto);
		
		return "ex01";
	}
	
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {	
		logger.info("name :" + name);
		logger.info("age :" + age);
		
		return "ex02";
	}
	
	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids") List<String> ids) {
		logger.info("ids :" + ids);
		
		return "ex02List";
	}
	
	@GetMapping("ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		logger.info("array ids : " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	@GetMapping("ex03")
	public String ex03(TodoDTO dto) {
		logger.info("TodoDTO :" + dto);
		
		return "ex03";
	}
	
	@GetMapping("exModel")
	public String exModel(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("AAAA");
		list.add("BBBB");
		list.add("CCCC");
		list.add("DDDD");
		list.add("EEEE");
		
		//request.setAttribute("list",list);
		model.addAttribute("list", list);
		
		logger.info("list :" + list);
		logger.info("model :" + model);
		return "exModel";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page) {
		logger.info("dto :" + dto);
		logger.info("page" + page);
		
		return "ex04";
		
	}
	
	
	@GetMapping("/ex04_1")
	public String ex04_1(SampleDTO dto, @ModelAttribute("page") int page) {
		logger.info("dto :" + dto);
		logger.info("page" + page);
		
		return "ex04"; //jsp 명이랑 맞아야함 
		
	}
	
	//redirect Test 
	@GetMapping("/ex05")
	public String ex05() {
			
		return "redirect:/sample/ex01?page=5";
		//위에 컨트롤러 매핑정보 꼭 잡아줘야해 !
	}
	
	
 	//redirect Test 값줘서 넘기기 
	@GetMapping("/ex05_1")
	public String ex05_1(RedirectAttributes rttr) { //rttr을 받아서 
		rttr.addFlashAttribute("page", 5); //이렇게 담아주는거야 
		
		return "redirect:/sample/ex01";
		//위에 컨트롤러 매핑정보 꼭 잡아줘야해 !
	}

	// 제이슨 
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		logger.info("ex/06 . ... . ..");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		 return dto;
	}
	
	
	
}
