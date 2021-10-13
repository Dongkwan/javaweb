package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Board2;
import com.rubypaper.domain.Member;
import com.rubypaper.service.BoardService;

//@SessionAttributes("member")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board); 
		return "forward:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board); 
		return "redirect:getBoardList";
	}
	
	
	@GetMapping("/getBoard") 
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard"; //게시글 상세 페이지
	}
	
	@GetMapping("/insertBoard") 
	public String insertBoardView() {
		return "insertBoard"; //게시글 작성 페이지
	}	
	
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board); 
		return "redirect:getBoardList";
	}

	
	
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "getBoardList";	
	}
	
	
//	@GetMapping("/getBoardList")
//	public String getBoardList(Model model, Board board) {
//		//List<Board2> boardList = new ArrayList<Board2>();
//		
//		/*for(int i=1; i <=10; i++) {
//			Board2 b = new Board2();
//			b.setSeq((long)i);
//			b.setTitle("제목" + i);
//			b.setWriter("테스터");
//			b.setContent(i+"번 내용입니다.");
//			b.setCreateDate(new Date());
//			b.setCnt(0L);
//			boardList.add(b);
//		}*/
//		
//		List<Board> boardList = boardService.getBoardList(board);
//
//		model.addAttribute("boardList", boardList);
//		return "getBoardList";	}

	/*
	@RequestMapping("/getBoardList2")
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		List<Board> boardList = boardService.getBoardList(board);

		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		return "insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
*/
}
