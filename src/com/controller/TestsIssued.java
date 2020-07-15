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
import com.bean.Patient;
import com.service.DiagonosticService;
import com.service.PatientService;

/**
 * Servlet implementation class TestsIssued
 */
@WebServlet("/TestsIssued")
public class TestsIssued extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestsIssued() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter pr = response.getWriter();  
		PatientService ps = new PatientService();
		Patient pat = new Patient(); 
		DiagonosticService ds = new DiagonosticService();
		List<Diagonostics> diag = new ArrayList<Diagonostics>();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		try{
                pat = ps.SearchPatient(patient_id);
                diag = ds.SearchTests(patient_id);
                request.setAttribute("id", patient_id);
        	    request.setAttribute("name", pat.getPatient_name());
        	    request.setAttribute("age", pat.getAge());
        	    request.setAttribute("doj", pat.getDoj());
        	    request.setAttribute("room_type", pat.getRoom_type());
        	    request.setAttribute("address", pat.getAddress());
        	    
        	    request.setAttribute("testList", diag);
        		request.getRequestDispatcher("TestsConducted.jsp").forward(request, response);
            
		} catch(Exception e) 
	    {
	         pr.println("data not found"+e);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
