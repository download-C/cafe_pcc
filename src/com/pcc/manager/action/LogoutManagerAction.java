package com.pcc.manager.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class LogoutManagerAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String mgr_num = (String) session.getAttribute("mgr_num");
		System.out.println("mgr_num: "+mgr_num);
		System.out.println("세션 아이디: "+session.getId());
		
		if(session != null) {
			session.invalidate();	
			System.out.println("세션 정보 초기화 완료");
			System.out.println("session: "+session);
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("./MainPage.pcc");
		forward.setRedirect(true);
		System.out.println("MainPage로 이동");
		
		return forward;
	}

}
