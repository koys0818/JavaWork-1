package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO(); //DAO 객체 생성
		WriteDTO [] arr = null;		
		
		
		try {
			arr = dao.selectByUid(Integer.parseInt(request.getParameter("uid")));
			
			
			request.setAttribute("select", arr);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
