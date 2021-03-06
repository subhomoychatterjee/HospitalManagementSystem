package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.service.PatientService;

/**
 * Servlet implementation class PatientUpdate
 */
@WebServlet("/PatientUpdate")
public class PatientUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientUpdate() {
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
		int id = Integer.parseInt(request.getParameter("patient_id"));
		String btn_clicked = request.getParameter("btn");
		
		if(btn_clicked.equals("Search"))
		{
		try{
                pat = ps.SearchPatient(id);
                request.setAttribute("id", pat.getPatient_id());
        	    request.setAttribute("name", pat.getPatient_name());
        	    request.setAttribute("age", pat.getAge());
        	    request.setAttribute("doj", pat.getDoj());
        	    request.setAttribute("room_type", pat.getRoom_type());
        	    request.setAttribute("address", pat.getAddress());
        		request.getRequestDispatcher("PatientUpdate.jsp").forward(request, response);
            
		} catch(Exception e) 
	    {
	         pr.println("data not found"+e);
	    }
		}
		
		else if(btn_clicked.equals("Update"))
		{
		String name = request.getParameter("patient_name");
		int age = Integer.parseInt(request.getParameter("age"));
		Date doj = null;
		try {
			doj = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("doj"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(doj.getTime());
		String room_type = request.getParameter("room_type");
		String address = request.getParameter("address");//+", "+request.getParameter("state")+", "+request.getParameter("city");
		
		try {
			if(ps.EditPatient(name, address, age, sqlDate, room_type, id))
				pr.println("<script language='javascript'>alert('Patient updated successfully!!');window.location.href='index.jsp'</script>");
			else
				pr.println("<script language='javascript'>alert('Patient not updated!!');</script>");
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
