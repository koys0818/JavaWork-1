package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		// 매개변수 받아오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//Ajax 리턴에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; //기본 FAIL
		
		if(name != null && subject != null &&
				name.trim().length() > 0 && subject.trim().length() > 0) {
			
			try {
				cnt = dao.insert(subject, content, name);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("status", status);
			request.setAttribute("message", message.toString());
			
		} // end if
			
		request.setAttribute("result", cnt);

	} // end execute()

} // end Command