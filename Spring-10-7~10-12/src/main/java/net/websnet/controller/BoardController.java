package net.websnet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import net.websnet.domain.BoardVO;
import net.websnet.service.BoardService;

@Controller
@RequestMapping("/Board/*")
@AllArgsConstructor
public class BoardController {
	private static final Logger log = 
			LoggerFactory.getLogger(BoardController.class);
	
	private BoardService service;
	
	@GetMapping("board_list")
	public void boardList(Model model) {
		log.info("boardList()......");
		model.addAttribute("list", service.boardList());
	}
	
	@GetMapping("board_write")
	public void boardWrite() {
		log.info("boardWrite()");
	}
	
	@PostMapping("board_write")
	public String boardWritePro(BoardVO vo) {
		int parent = vo.getParent();
		int indent = vo.getIndent();
		int depth = vo.getDepth();
		int idx=0;
		idx = service.boardMaxIdx();
		if(parent != 0) {// 답변글 일경우 처리
			service.boardDepth(vo);
			vo.setDepth(depth+1);
			vo.setIndent(indent+1);
		}else{ // 처음 작성된 글 일 경우
			vo.setParent(idx);			
		}
		
		vo.setIdx(idx);
		service.boardWrite(vo);
		
		return "redirect:/Board/board_list";		
	}
	
	@GetMapping("board_view")
	public void boardView(@RequestParam("idx") int idx, Model model) {
		log.info("boardView()");
		service.boardCount(idx);
		model.addAttribute("vo", service.boardSelect(idx));
	}
	// 답변입력 폼
	@GetMapping("board_reply")
	public void boardReply(@RequestParam("idx") int idx, Model model) {
		log.info("boardReply()");
		
		model.addAttribute("vo", service.boardSelect(idx));
	}
	//수정 입력폼
	@GetMapping("board_modify")
	public void boardModify(@RequestParam("idx") int idx, Model model) {
		log.info("boardModify()");
		
		model.addAttribute("vo", service.boardSelect(idx));
	}
/*	//수정 처리
	@PostMapping("board_modify")
	public String boardModifyPro(BoardVO vo) {
		log.info("boardModifyPro()..");
		int row=service.boardModify(vo);
		return "redirect:/Board/board_list";
	}
*/	
	// 수정처리(비번 체크)
	@PostMapping("board_modify")
	public void boardModifyPro(BoardVO vo, Model model) {
		log.info("boardModifyPro()..");
		int row=service.boardModify(vo);
		model.addAttribute("row", row);
	}
	// 삭제(비번입력 폼)
	@GetMapping("board_delete")
	public void boardDelete(@ModelAttribute("idx") int idx) {
		log.info("boardDelete()..");
	}

	// 삭제처리
	@PostMapping("board_delete_pro")
	public void boardDeletePro(BoardVO vo, Model model) {
		log.info("boardDeletePro()..");
		int cnt = service.boardRealparent(vo.getIdx());// 답변글 수 카운트
		int row=0;
		if(cnt==0) {//답변글이 없을 경우
			row=service.boardDelete(vo);
		}else {
			row=-1; // 답변글이 있을 경우
		}
		model.addAttribute("row", row);
	}
}
