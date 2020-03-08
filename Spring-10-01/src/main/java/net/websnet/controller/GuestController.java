package net.websnet.controller;

import java.util.List;

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
import net.websnet.domain.PageVO;
import net.websnet.service.GuestService;
import net.websnet.util.PgIndex;
import net.websnet.util.SqlMark;

@Controller
@AllArgsConstructor
@RequestMapping("Guest")
public class GuestController {
	private static final Logger log = 
			LoggerFactory.getLogger(GuestController.class);
	
	private GuestService service;
	
	@GetMapping("guest_list")
	public void guestList(Model model, @RequestParam(value="page",required=false, defaultValue = "1") int page) {
		log.info("guestList()......");
		String url="guest_list";
		String s_query="", addtag="", query="", key="";
		
		int nowpage=1;
		int maxlist=10;
		int totpage=1;
		int totcount = service.guestCount();//전체 게시물 카운트
		if(totcount % maxlist == 0) {  // 페이지 수 계산
			totpage=totcount / maxlist;
		}else {
			totpage=totcount / maxlist + 1;
		}
		if(totpage == 0)	// 총 페이지가 0이면 1로 초기화
			totpage=1;
		if(page != 0)		// 현재페이지
			nowpage=page;
		if(nowpage > totpage) //현재페이지가 총페이지보다 크면 마지막 페이지로 변환
			nowpage=totpage;
		
		int pagestart = (nowpage-1)*maxlist +1 ;// 현재페이지 시작번호 
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		PageVO vo = new PageVO();
		vo.setEndpage(endpage);
		vo.setPagestart(pagestart);
		List list = service.guestList(vo);
		
		model.addAttribute("addtag",addtag);
		model.addAttribute("url",url);
		model.addAttribute("nowpage",nowpage);
		model.addAttribute("totpage",totpage);
		model.addAttribute("totcount",totcount);
		model.addAttribute("pagestart",pagestart);
		model.addAttribute("listcount",listcount);
		model.addAttribute("list",list);
		
		model.addAttribute("listPage", PgIndex.pageList(nowpage, totpage, url, addtag));
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
	public void guestView(@RequestParam("idx") int idx, @RequestParam("page") int nowpage, Model model) {
		log.info("guestView()......");
		//service.guestReadCnt(idx);
		GuestVO vo = service.guestView(idx);
		
		vo.setContents(SqlMark.lineBreak(vo.getContents()));
		model.addAttribute("vo", vo);
		model.addAttribute("page", nowpage);
	}
	
	@GetMapping("guestReadCnt")
	public String guestReadCnt(@RequestParam("idx") int idx,@RequestParam("page") int nowpage, 
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
		return "redirect:/Guest/guest_view?idx="+idx+"&page="+nowpage;
	}

}
