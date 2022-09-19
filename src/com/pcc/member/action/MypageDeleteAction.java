package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class MypageDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		// DB에 정보 저장
		
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
						
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();
		dto.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
		dto.setPassword(request.getParameter("password"));


		int result = dao.deleteMember(dto);
		
		ActionForward forward = new ActionForward();
		
				
		if(result == 1){
			session.invalidate();
			//페이지 이동정보 저장(리턴)
//			forward.setPath("./mypageContent.me");
//			forward.setRedirect(true);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>alert('회원 삭제 성공!'); "
					+ "location.href='./mypageContent.me';</script>");
			out.flush();
					
		}
		else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>alert('회원 삭제 실패!'); "
					+ "history.back();</script>");
			out.flush();
		}
				
		return forward;
	}

}
