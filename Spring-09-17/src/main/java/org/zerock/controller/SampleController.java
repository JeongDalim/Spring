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
@RequestMapping("/sample/*")//sample �̶�� �ľߵ� 

public class SampleController {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController.class);
	@RequestMapping("")
	public void basic() {
		logger.info("basic() call . . . ");
	}
	
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET, RequestMethod.POST}) // �ΰ� �� ���ڴ�. 
	public void basicGet() {
		logger.info("basicGet() call . . . ");
		
		
	}
	
	@GetMapping("basic2")
	public void basicGetOnly(){
		logger.info("basicGetOnly() call . . .");
		
	}
	
	// Parameter �����ϴ� ��� 
	//(1) �ϳ��� ��ü�� �̿��ؼ� ���� ��
	@GetMapping("ex01")
	public String ex01(SampleDTO dto) { 
		logger.info("SampleDTO:" + dto );
		return "ex01";
	}
	
	
	// Parameter �����ϴ� ��� 
	//(2) ���������� ���� ��, ���� ���� ������
	
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age){
		logger.info("name:" + name );
		logger.info("age:" + age );
		return "ex02";	
	}
	
	
	// Parameter �����ϴ� ��� 
	//(2) ���������� ���� ��, ���� ���� ������ / ���� ��ư ���� ����Ʈ�� ��ƿ;� �� �� ���� ���
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")List<String> ids) {
		logger.info("ids:" + ids);
		
		return "exo2List";
		
	}
	
	// Parameter �����ϴ� ��� 
	//(2) ���������� ���� ��, ���� ���� ������ / ���� ��ư ���� �迭�� ��ƿ;� �� �� ���� ���
		
	@GetMapping("ex/02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		logger.info("array ids:" + Arrays.toString(ids));
		
		return "ex02Array";

	}

	// �̷��� �ϸ� �ڹ�Date���Ŀ� ������ ������ ������ �ʾ�. 
	@GetMapping("ex03")
	public String ex3(TodoDTO dto) {
		logger.info("TodoDTO" + dto);
		
		return "ex03";

	}
	
	
 
	

}
