package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.service.PatientService;

/**
 * Servlet implementation class PatientInvoice
 */
@WebServlet("/PatientInvoice")
public class PatientInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientInvoice() {
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
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		try{
                pat = ps.SearchPatient(patient_id);
                request.setAttribute("id", patient_id);
        	    request.setAttribute("name", pat.getPatient_name());
        	    request.setAttribute("age", pat.getAge());
        	    request.setAttribute("doj", pat.getDoj());
        	    request.setAttribute("dod", pat.getDod());
        	    request.setAttribute("room_type", pat.getRoom_type());
        	    request.setAttribute("address", pat.getAddress());
        	    request.setAttribute("rate", pat.getRate());
        	    
        	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	    int nod = (int)ChronoUnit.DAYS.between(LocalDate.parse(pat.getDoj().toString(),dtf),LocalDate.parse(pat.getDod().toString(),dtf));
        	    request.setAttribute("nod", nod);
        	    request.setAttribute("amount", nod*pat.getRate());
        	    
        	    request.getRequestDispatcher("PatientInvoice.jsp").forward(request, response);
                
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
