package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.service.PatientService;

/**
 * Servlet implementation class PatientRegistration
 */
@WebServlet("/PatientRegistration")
public class PatientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegistration() {
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
		PatientService ps = new PatientService();
		Patient pat = new Patient();
		
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		int id = Integer.parseInt(request.getParameter("patient_id"));
		String name = request.getParameter("patient_name");
		int age = Integer.parseInt(request.getParameter("age"));
		Date doj = null, dod = null;
		try {
			doj = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("doj"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			dod = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dod"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		java.sql.Date sqlDate1 = new java.sql.Date(doj.getTime());
		java.sql.Date sqlDate2 = new java.sql.Date(dod.getTime());
		String room_type = request.getParameter("room_type");
		String address = request.getParameter("address")+", "+request.getParameter("city")+", "+request.getParameter("state");
		
		pat.setSsn(ssn);
		pat.setPatient_id(id);
		pat.setPatient_name(name);
		pat.setAge(age);
		pat.setDoj(sqlDate1);
		pat.setDod(sqlDate2);
		pat.setRoom_type(room_type);
		pat.setAddress(address);
		
		try {
			if(ps.AddPatient(pat))
				pr.println("<script language='javascript'>alert('Patient added successfully!!');window.location.href='index.jsp'</script>");
			else
				pr.println("<script language='javascript'>alert('Patient not added!!');</script>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
