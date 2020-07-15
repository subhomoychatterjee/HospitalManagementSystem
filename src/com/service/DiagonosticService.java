/**
 * 
 */
package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Diagonostics;
import com.dao.DiagonosticDAO;

/**
 * @author Suneha Ghosh
 *
 */
public class DiagonosticService {
	
	public boolean AddDiagonostic(Diagonostics diag) throws SQLException, ClassNotFoundException{
		
		return DiagonosticDAO.AddDiagonostic(diag);
	}
	
	public List<Diagonostics> SearchTests(int patient_id) throws SQLException, ClassNotFoundException{
		
		return DiagonosticDAO.SearchTests(patient_id);
	}
	
	public int TestInvoice(int patient_id) throws SQLException, ClassNotFoundException{
		
		return DiagonosticDAO.TestInvoice(patient_id);
	}

}
