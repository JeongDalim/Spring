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

@Controller //컨트롤러인거 알려줘야지
@AllArgsConstructor 
@RequestMapping("Guest/*") //jsp가 있는 폴더이름이랑 맞춰야됨 
public class GuestController {
	private static final Logger log = LoggerFactory.getLogger(GuestController.class);
	
	private GuestService service; //주입
	@GetMapping("guest_list") //jsp 파일 이름과 맞춰야됨
	public void guestList(Model model) {//db에서 가져와서 전달할때 많이 사용 model은 전달자  // 어떠한거든지 다 담아서 전달할 수 있어.
											//내장객체라고 생각하면 됨, 루트컨텍스에 등록해줄 필요없이 바로 선언하면 쓸수 있음  
		log.info("guestList()....");
		model.addAttribute("list", service.guestList()); 
		 //이걸 모델에 담아서 jsp를 수행하라 
	}
	 
	@GetMapping("guest_write")
	public void getWrite() {
		log.info("guest_write()....");
	}
	
	
	@PostMapping("guest_write")
		public void postWrite() {
			
		}
	
	
	
}
