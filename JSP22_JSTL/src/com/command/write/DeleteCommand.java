package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		WriteDAO dao = new WriteDAO(); //DAO 객체 생성
		int uid = Integer.parseInt(request.getParameter("uid"));
		int cnt = 0;
		
		try {
			cnt = dao.deleteByUid(uid);			
			
			request.setAttribute("result", cnt);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
