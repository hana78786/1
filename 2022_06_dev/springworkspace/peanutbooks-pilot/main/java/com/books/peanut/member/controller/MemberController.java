package com.books.peanut.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.books.peanut.member.domain.Member;
import com.books.peanut.member.service.MemberService;
import com.books.peanut.pay.domain.SeasonTicket;
import com.books.peanut.pay.payService.PayService;


@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	@Autowired
	private PayService pService;
	
	/**
	 * 회원가입 화면
	 * @return
	 */
	@RequestMapping(value="/member/joinView.pb", method=RequestMethod.GET)
	public String memberJoinView() {
		return "member/join";
	}
	
	/**
	 * 회원가입 기능
	 * @param member
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/member/join.pb", method=RequestMethod.POST)
	public ModelAndView memberJoin(
			@ModelAttribute Member member,
			ModelAndView mv) {
		try {
			int result = mService.registerMember(member);
			if(result > 0) {
				mv.setViewName("redirect:/"); // 회원가입 성공 시 로그인 전 메인 페이지로 이동
			} else {
				mv.setViewName("redirect:/member/joinView.pb"); // 회원가입 실패 시 회원가입 페이지로 이동(임시)
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage"); // 에러 확인용
		}
		return mv;
	}
	
	/**
	 * 별명 유효성 검사
	 * @param mNickname
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/member/checkNickname.pb", method=RequestMethod.GET)
	public String checkNickname(
			@RequestParam("mNickname") String mNickname) {
		int result = mService.checkNickname(mNickname);
		return String.valueOf(result);
	}
	
	/**
	 * 아이디 유효성 검사
	 * @param memberId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/member/checkId.pb", method=RequestMethod.GET)
	public String checkId(
			@RequestParam("memberId") String memberId) {
		int result = mService.checkId(memberId);
		return String.valueOf(result);
	}
	
	/**
	 * 이메일 유효성 검사
	 * @param mEmail
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/member/checkEmail.pb", method=RequestMethod.GET)
	public String checkEmail(
			@RequestParam("mEmail") String mEmail) {
		int result = mService.checkEmail(mEmail);
		return String.valueOf(result);
	}
	
	/**
	 * 로그인 화면
	 * @return
	 */
	@RequestMapping(value="/member/loginView.pb", method=RequestMethod.GET)
	public String memberLoginView() {
		return "member/login";
	}
	
	/**
	 * 로그인 기능
	 * @param member
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/member/login.pb", method=RequestMethod.POST)
	public ModelAndView memberLogin(
			@ModelAttribute Member member,
			ModelAndView mv,
			HttpServletRequest request) {
		try {
			Member loginMember = mService.loginMember(member);
			if(loginMember != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMember); // session에 로그인한 회원의 모든 정보(loginMember) 저장

				// 구독권 가져오는 부분
				String lastDate = pService.seasonTicketDate(loginMember.getMemberId());			
				session.setAttribute("lastDate", lastDate);
				//구독권 가져오는부분 종료
				mv.setViewName("redirect:/main"); // 로그인 성공 시 로그인 후 메인 페이지로 이동

			} else {
				mv.setViewName("redirect:/member/loginView.pb"); // 로그인 실패 시 로그인 페이지로 이동(임시)
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage"); // 에러 확인용
		}
		return mv;
	}
	
	/**
	 * 로그아웃 기능
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/member/logout.pb", method=RequestMethod.GET)
	public ModelAndView memberLogout(
			ModelAndView mv,
			HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			if(session != null) {
				session.invalidate();
				mv.setViewName("redirect:/"); // 로그아웃 성공 시 로그인 전 메인 페이지로 이동
			}else {
				mv.setViewName("redirect:/main"); // 로그아웃 실패 시 로그인 후 메인 페이지로 이동(임시)
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage"); // 에러 확인용
		}
		return mv;
	}
	
	/**
	 * 아이디 찾기 화면
	 * @return
	 */
	@RequestMapping(value="/member/forgotId.pb", method=RequestMethod.GET)
	public String forgotIdView() {
		return "member/forgotId";
	}
	
	/**
	 * 아이디 찾기 - 결과 화면
	 * @return
	 */
	@RequestMapping(value="/member/idResult.pb", method=RequestMethod.GET)
	public String idResultView() {
		return "member/idResult";
	}
	
	/**
	 * 비밀번호 재설정 화면
	 * @return
	 */
	@RequestMapping(value="/member/forgotPw.pb", method=RequestMethod.GET)
	public String forgotPwView() {
		return "member/forgotPw";
	}
	
	/**
	 * 비밀번호 재설정 - 새 비밀번호 입력 화면
	 * @return
	 */
	@RequestMapping(value="/member/resetPw.pb", method=RequestMethod.GET)
	public String resetPwView() {
		return "member/resetPw";
	}
	
	/**
	 * 이메일 인증 확인 화면
	 * @return
	 */
	@RequestMapping(value="/member/confirmEmailView.pb", method=RequestMethod.GET)
	public String confirmEmailView() {
		return "member/confirmEmail";
	}
	
	/**
	 * 정보 관리 화면
	 * @return
	 */
	@RequestMapping(value="/member/memberInfo.pb", method=RequestMethod.GET)
	public String memberInfoView() {
		return "member/memberInfo";
	}
	

	//은정이가 잠깐 사용할 예정
	@RequestMapping(value="/member/login.kh", method=RequestMethod.POST)
	public ModelAndView memberLogin2(
			@ModelAttribute Member member,
			ModelAndView mv,
			HttpServletRequest request) {
		try {
			Member loginMember = mService.loginMember(member);
			if(loginMember != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMember); // session에 로그인한 회원의 모든 정보(loginMember) 저장
				mv.addObject("loginMember", loginMember);  //추가함//
				mv.setViewName("redirect:/ej.kh");
			} else {
				mv.setViewName("error");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("error"); // 에러 확인용
		}
		return mv;

		
	}
	
}
