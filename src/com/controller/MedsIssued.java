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

import com.bean.Medicines;
import com.bean.Patient;
import com.service.MedicineService;
import com.service.PatientService;

/**
 * Servlet implementation class MedsIssued
 */
@WebServlet("/MedsIssued")
public class MedsIssued extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedsIssued() {
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
		MedicineService ms = new MedicineService();
		List<Medicines> med = new ArrayList<Medicines>();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		try{
                pat = ps.SearchPatient(patient_id);
                med = ms.SearchMedicines(patient_id);
                request.setAttribute("id", patient_id);
        	    request.setAttribute("name", pat.getPatient_name());
        	    request.setAttribute("age", pat.getAge());
        	    request.setAttribute("doj", pat.getDoj());
        	    request.setAttribute("room_type", pat.getRoom_type());
        	    request.setAttribute("address", pat.getAddress());
        	    
        	    request.setAttribute("medList", med);
        		request.getRequestDispatcher("MedsIssued.jsp").forward(request, response);
            
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
