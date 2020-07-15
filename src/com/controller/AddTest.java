package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Diagonostics;
import com.service.DiagonosticService;
import com.service.PatientService;

/**
 * Servlet implementation class AddTest
 */
@WebServlet("/AddTest")
public class AddTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		DiagonosticService ds = new DiagonosticService();
		Diagonostics diag = new Diagonostics();
		PatientService ps = new PatientService();
		
		int id = Integer.parseInt(request.getParameter("patient_id"));
		String btn_clicked = request.getParameter("btn");
		
		if(btn_clicked.equals("Search"))
		{
			try{
                ps.SearchPatient(id);
                request.setAttribute("id", id);
                request.getRequestDispatcher("TestsToBeIssued.jsp").forward(request, response);
                
			} catch(Exception e) 
		    {
		         pr.println("data not found"+e);
		    }
		}
		
		else if(btn_clicked.equals("Add"))
		{
			
			
		String test_name = request.getParameter("test_name");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		diag.setPatient_id(id);
		diag.setDiagonosis(test_name);
		diag.setAmount(amount);
		
		try {
			if(ds.AddDiagonostic(diag))
				pr.println("<script language='javascript'>alert('Test added successfully!!');window.location.href='index.jsp'</script>");
			else
				pr.println("<script language='javascript'>alert('Test not added!!');</script>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
