package co.seokjin.prj.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.prj.comm.Command;
import co.seokjin.prj.member.service.MemberService;
import co.seokjin.prj.member.serviceImpl.MemberServiceImpl;
import co.seokjin.prj.member.vo.MemberVO;

public class MemberSelectList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.memberSelectList();
		
		request.setAttribute("members", list);
		
		return "member/memberSelectList";
	}

}
