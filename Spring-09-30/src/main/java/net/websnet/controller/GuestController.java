package net.websnet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import net.websnet.domain.GuestVO;
import net.websnet.service.GuestService;

@Controller
@AllArgsConstructor
@RequestMapping("Guest")
public class GuestController {
	private static final Logger log = 
			LoggerFactory.getLogger(GuestController.class);
	
	private GuestService service;
	
	@GetMapping("guest_list")
	public void guestList(Model model) {
		log.info("guestList()......");
		model.addAttribute("list", service.guestList());
		//List list = service.guestList();
		//model.addAttribute("list", list);
	}
	// 등록 폼으로 이동
	@GetMapping("guest_write")
	public void guestWrite() {
		log.info("guestWrite()......");
	}
	// 등록처리
	@PostMapping("guest_write")
	public String guestWritePro(GuestVO vo) {
		log.info("guestWritePro()......");
		service.guestWrite(vo);
		return "redirect:/Guest/guest_list";
	}
	
	@GetMapping("guest_view")
	public void guestView(@RequestParam("idx") int idx, Model model) {
		log.info("guestView()......");
		//service.guestReadCnt(idx);
		GuestVO vo = service.guestView(idx);
		model.addAttribute("vo", vo);
	}
	
	@GetMapping("guestReadCnt")
	public String guestReadCnt(@RequestParam("idx") int idx, 
			HttpServletRequest request, HttpServletResponse response) {
		boolean found=false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i<cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("guestCookie"+idx)) {
				found = true;
				break;
			}
		}
		String str = ""+System.currentTimeMillis();
		if(!found) {
			info=new Cookie("guestCookie"+idx, str);
			info.setMaxAge(60*60);
			response.addCookie(info);
			service.guestReadCnt(idx);
		}
		log.info("guestReadCnt()......");
		return "redirect:/Guest/guest_view?idx="+idx;
	}

}
