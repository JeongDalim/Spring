package net.websnet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import net.websnet.service.GuestService;

@Controller //��Ʈ�ѷ��ΰ� �˷������
@AllArgsConstructor 
@RequestMapping("Guest/*") //jsp�� �ִ� �����̸��̶� ����ߵ� 
public class GuestController {
	private static final Logger log = LoggerFactory.getLogger(GuestController.class);
	
	private GuestService service; //����
	@GetMapping("guest_list") //jsp ���� �̸��� ����ߵ�
	public void guestList(Model model) {//db���� �����ͼ� �����Ҷ� ���� ��� model�� ������  // ��Ѱŵ��� �� ��Ƽ� ������ �� �־�.
											//���尴ü��� �����ϸ� ��, ��Ʈ���ؽ��� ������� �ʿ���� �ٷ� �����ϸ� ���� ����  
		log.info("guestList()....");
		model.addAttribute("list", service.guestList()); 
		 //�̰� �𵨿� ��Ƽ� jsp�� �����϶� 
	}
	 
	@GetMapping("guest_write")
	public void getWrite() {
		log.info("guest_write()....");
	}
	
	
	@PostMapping("guest_write")
		public void postWrite() {
			
		}
	
	
	
}
