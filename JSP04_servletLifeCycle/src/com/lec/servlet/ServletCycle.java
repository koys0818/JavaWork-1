package com.lec.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCycle
 */
@WebServlet("/Cycle")
public class ServletCycle extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	// 서블릿 생성자, 첫 request 발생시 최초 단 한번 생성
    public ServletCycle() {
        super();
        System.out.println("서블릿 생성");
    }
    
    //서블릿 객체 생성 이후(직후)
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	System.out.println("init 호출");
    }
    
    //서블릿 객체 소멸시
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	System.out.println("destroy 호출");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("service() 호출");
	}

}
