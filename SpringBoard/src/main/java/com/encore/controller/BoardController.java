package com.encore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.domain.PageDTO;
import com.encore.service.BoardService;

@Controller
@RequestMapping("/board/*")// 공통매핑 정의
public class BoardController {

	@Autowired
	BoardService service;

	// 게시물 목록보기
	@GetMapping("/list")
	public String list(Criteria cri, Model m) {
		
		m.addAttribute("list", service.getList(cri));// getList(3페이지)
		int total = service.getTotal(cri); // DB의 total값(검색어를 만족하는 레코드)

		m.addAttribute("pageMaker", new PageDTO(cri, total));
		return "board/list";
	}

	// 게시물 입력폼보기
	@GetMapping("/register")
	public void getRegister() {

	}

	// 게시물 DB입력
	@PostMapping("/register") // inset 요청
	public String postRegister(BoardVO vo, RedirectAttributes attr) {
		int bno = service.register(vo);
		attr.addFlashAttribute("result", bno);
		return "redirect:/board/list";
	}

	// 특정번호의 게시물 읽기
	@GetMapping("/get")
	public String get(int bno, Model m, Criteria cri) {
		m.addAttribute("board", service.get(bno));
		m.addAttribute("cri", cri);
		return "board/get";
	}

	// 게시물 수정 폼 보기
	@GetMapping("/modify")
	public String getModify(int bno, Model m, Criteria cri) {
		m.addAttribute("board", service.get(bno));
		m.addAttribute("cri", cri);
		return "board/modify";
	}

	// 게시물 DB수정
	@PostMapping("/modify")
	public String postModify(BoardVO board, RedirectAttributes attr, Criteria cri) {
		if (service.modify(board)) {// 수정요청
			attr.addFlashAttribute("result", "success");
			attr.addFlashAttribute("cir", cri);
		}
		return "redirect:/board/list?pageNum=" + cri.getPageNum();
	}

	// 게시물 삭제
	@GetMapping("/remove")
	public String getRemove(int bno, RedirectAttributes attr) {
		if (service.remove(bno)) {
			attr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}
