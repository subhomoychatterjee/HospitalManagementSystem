package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Medicines;
import com.service.MedicineService;
import com.service.PatientService;

/**
 * Servlet implementation class AddMedicine
 */
@WebServlet("/AddMedicine")
public class AddMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedicine() {
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
		MedicineService ms = new MedicineService();
		Medicines med = new Medicines();
		PatientService ps = new PatientService();
		
		int id = Integer.parseInt(request.getParameter("patient_id"));
		String btn_clicked = request.getParameter("btn");
		
		if(btn_clicked.equals("Search"))
		{
			try{
                if(ps.checkPatID(id))
                {
                /*request.setAttribute("id", id);
                request.getRequestDispatcher("MedsToBeIssued.jsp").forward(request, response);*/
                	pr.println(id);
                }
                
			} catch(Exception e) 
		    {
		         pr.println("data not found"+e);
		    }
		}
		
		else if(btn_clicked.equals("Add"))
		{
			
			String med_name = request.getParameter("med_name");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int rate = Integer.parseInt(request.getParameter("rate"));
			int amount = quantity*rate;
			
		med.setPatient_id(id);
		med.setMedicine_name(med_name);
		med.setQuantity(quantity);
		med.setRate(rate);
		med.setAmount(amount);
		
		try {
			if(ms.AddMedicine(med))
				pr.println("<script language='javascript'>alert('Medicine added successfully!!');window.location.href='index.jsp'</script>");
			else
				pr.println("<script language='javascript'>alert('Medicine not added!!');</script>");
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
