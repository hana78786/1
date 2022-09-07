package com.kh.junspring.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.junspring.board.domain.Board;
import com.kh.junspring.board.service.BoradService;

@Controller
public class BoradController {
	
	@Autowired
	BoradService bService;
	
	@RequestMapping(value="/board/writeView.kh", method=RequestMethod.GET)
	public ModelAndView shoWBoardWirte(ModelAndView mv) {
		
		mv.setViewName("board/boardWriteForm");
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/board/register.kh", method = RequestMethod.POST)
	public ModelAndView registBoard(ModelAndView mv,
			@ModelAttribute Board board
			) {
		
		try {
			int result = bService.registerBoard(board);
			mv.setViewName("redirect:/board/list.kh");
			
		}catch (Exception e) {
			mv.addObject("mgs",e.getMessage());
			mv.setViewName("/common/errorPage");
		}
		
		
		return mv;
	}

}
