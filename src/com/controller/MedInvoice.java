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
import com.service.MedicineService;

/**
 * Servlet implementation class MedInvoice
 */
@WebServlet("/MedInvoice")
public class MedInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter pr = response.getWriter();  
		MedicineService ms = new MedicineService();
		List<Medicines> med = new ArrayList<Medicines>();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		try{
			med = ms.SearchMedicines(patient_id);
			int bill = ms.MedInvoice(patient_id);
			request.setAttribute("bill", bill);
			request.setAttribute("medList", med);
    		request.getRequestDispatcher("PharmacyInvoice.jsp").forward(request, response);
		
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
