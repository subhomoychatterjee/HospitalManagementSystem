/**
 * 
 */
package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Medicines;
import com.dao.MedicineDAO;

/**
 * @author Suneha Ghosh
 *
 */
public class MedicineService {
	
	public boolean AddMedicine(Medicines med) throws SQLException, ClassNotFoundException{
		
		return MedicineDAO.AddMedicine(med);
	}
	
	public List<Medicines> SearchMedicines(int patient_id) throws SQLException, ClassNotFoundException{
		
		return MedicineDAO.SearchMedicines(patient_id);
	}
	
    public int MedInvoice(int patient_id) throws SQLException, ClassNotFoundException{
		
		return MedicineDAO.MedInvoice(patient_id);
	}

}
