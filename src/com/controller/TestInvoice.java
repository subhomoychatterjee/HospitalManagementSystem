package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Diagonostics;
import com.service.DiagonosticService;

/**
 * Servlet implementation class TestInvoice
 */
@WebServlet("/TestInvoice")
public class TestInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter pr = response.getWriter(); 
		DiagonosticService ds = new DiagonosticService();
		List<Diagonostics> diag = new ArrayList<Diagonostics>();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		try{
			diag = ds.SearchTests(patient_id);
			int bill = ds.TestInvoice(patient_id);
			request.setAttribute("bill", bill);
			request.setAttribute("testList", diag);
    		request.getRequestDispatcher("DiagonosticInvoice.jsp").forward(request, response);
        
	} catch(Exception e) 
    {
         pr.println("data not found"+e);
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
