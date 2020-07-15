/**
 * 
 */
package com.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.bean.Patient;
import com.dao.PatientDAO;

/**
 * @author Suneha Ghosh
 *
 */
public class PatientService {
	
	public boolean AddPatient(Patient pat) throws SQLException, ClassNotFoundException{
		
		return PatientDAO.AddPatient(pat);	
	}
	
	public boolean EditPatient(String patient_name, String address, int age, Date sqlDate, String room_type, int patient_id) throws SQLException, ClassNotFoundException{
		
		return PatientDAO.EditPatient(patient_name, address, age, sqlDate, room_type, patient_id);
	}
	
	public boolean DeletePatient(int patient_id) throws SQLException, ClassNotFoundException{
		
		return PatientDAO.DeletePatient(patient_id);
	}
	
	public boolean checkPatID(int patient_id) throws SQLException, ClassNotFoundException{
		
		return PatientDAO.checkPatID(patient_id);
	}
	
	public Patient SearchPatient(int patient_id) throws SQLException, ClassNotFoundException{
		
		return PatientDAO.SearchPatient(patient_id);
	}
	
	public List<Patient> ViewPatient() throws SQLException, ClassNotFoundException{
		
		return PatientDAO.ViewPatient();
	}

}
