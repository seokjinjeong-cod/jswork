package co.seokjin.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seokjin.prj.comm.Command;
import co.seokjin.prj.member.service.MemberService;
import co.seokjin.prj.member.serviceImpl.MemberServiceImpl;
import co.seokjin.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인
		HttpSession session = request.getSession();	// 세션객체를 불러온다.
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id")); // 폼에서 입력된값을 vo객체에 담음
		vo.setPassword(request.getParameter("password"));

		vo = memberDao.memberLogin(vo);
		
		String page = null;
		if (vo.getName() != null) {
			request.setAttribute("member", vo);
			session.setAttribute("id", vo.getId());
			page = "member/memberLoginSuccess";
		} else {
			page = "member/memberLoginFail";
		}

		return page;
	}

}
