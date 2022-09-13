package com.kh.pilot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testController {
	
	@RequestMapping (value="/test.do" , method = RequestMethod.GET)
	public ModelAndView test(ModelAndView mv) {
		mv.setViewName("test");
		return mv;
	}

}
