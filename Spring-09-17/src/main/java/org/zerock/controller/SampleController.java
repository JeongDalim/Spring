package org.zerock.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

@Controller
@RequestMapping("/sample/*")//sample 이라고 쳐야됨 

public class SampleController {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController.class);
	@RequestMapping("")
	public void basic() {
		logger.info("basic() call . . . ");
	}
	
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET, RequestMethod.POST}) // 두개 다 쓰겠다. 
	public void basicGet() {
		logger.info("basicGet() call . . . ");
		
		
	}
	
	@GetMapping("basic2")
	public void basicGetOnly(){
		logger.info("basicGetOnly() call . . .");
		
	}
	
	// Parameter 수집하는 방법 
	//(1) 하나의 객체를 이용해서 받을 때
	@GetMapping("ex01")
	public String ex01(SampleDTO dto) { 
		logger.info("SampleDTO:" + dto );
		return "ex01";
	}
	
	
	// Parameter 수집하는 방법 
	//(2) 개별적으로 받을 때, 따로 따로 받을때
	
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age){
		logger.info("name:" + name );
		logger.info("age:" + age );
		return "ex02";	
	}
	
	
	// Parameter 수집하는 방법 
	//(2) 개별적으로 받을 때, 따로 따로 받을때 / 라디오 버튼 같이 리스트로 담아와야 할 때 쓰는 방법
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")List<String> ids) {
		logger.info("ids:" + ids);
		
		return "exo2List";
		
	}
	
	// Parameter 수집하는 방법 
	//(2) 개별적으로 받을 때, 따로 따로 받을때 / 라디오 버튼 같이 배열로 담아와야 할 때 쓰는 방법
		
	@GetMapping("ex/02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		logger.info("array ids:" + Arrays.toString(ids));
		
		return "ex02Array";

	}

	// 이렇게 하면 자바Date형식에 맞추지 않으면 나오지 않아. 
	@GetMapping("ex03")
	public String ex3(TodoDTO dto) {
		logger.info("TodoDTO" + dto);
		
		return "ex03";

	}
	
	
 
	

}
