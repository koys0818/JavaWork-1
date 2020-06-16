package com.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxCategoryList;
import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CategoryListCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CategoryDTO[] dtoArr = null;
		CategoryDAO dao = new CategoryDAO();
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		String param;
		int depth = 0;
		int parent= 0;
		
		// page 값 : 현재 몇 페이지?
		param = request.getParameter("depth");
		if(param != null && param.trim().length() != 0) {
			try {				
				depth = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		param = request.getParameter("parent");
		if(param != null && param.trim().length() != 0) {
			try {				
				parent = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		
		try {
			
			if(depth == 0 || depth < 0 || parent == 0 || parent < 0) {
				dtoArr = dao.selectByDepth(1);
				status = "OK";
			} else {
				
				dtoArr = dao.selectByDepthParent(depth, parent);
				if(dtoArr != null) {
					status = "OK";
					
				} else {
					message.append("해당하는 데이터가 없습니다");
					
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		AjaxCategoryList result = new AjaxCategoryList();		
		
		
		result.setStatus(status);
		result.setMessage(message.toString());
		
		
		if(dtoArr != null) {
		result.setCount(dtoArr.length);
		result.setList(Arrays.asList(dtoArr));
		}
			
		ObjectMapper mapper = new ObjectMapper();  // Json 매핑할 객체
		
		try {
			String jsonString =
					mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(result);
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
