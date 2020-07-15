/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Medicines;
import com.util.ConnectionDB;

/**
 * @author Suneha Ghosh
 *
 */
public class MedicineDAO {
	
	static Connection con= null;
	static PreparedStatement ps = null;
	static ResultSet result = null;
	
	public static boolean AddMedicine(Medicines med) throws SQLException, ClassNotFoundException{
		
		boolean flag = false;
		con = ConnectionDB.connect();
		ps = con.prepareStatement("insert into medicines(patient_id, medicine_name, quantity, rate, amount) values (?,?,?,?,?)");
		ps.setInt(1, med.getPatient_id());
		ps.setString(2, med.getMedicine_name());
		ps.setInt(3, med.getQuantity());
		ps.setInt(4, med.getRate());
		ps.setInt(5, med.getAmount());
		
		int rowstatus = ps.executeUpdate();
		ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		if(rowstatus>0)
			return true;
		return flag;
		
	}
	
	public static List<Medicines> SearchMedicines(int patient_id) throws SQLException, ClassNotFoundException{
		
		Medicines med = null;
		List<Medicines> medList = new ArrayList<Medicines>();
		con = ConnectionDB.connect();
    	ps=con.prepareStatement("select * from medicines where patient_id=?");
    	ps.setInt(1, patient_id);
    	
        result = ps.executeQuery();
        
        while(result.next())
        {
        	med = new Medicines();
        	med.setMedicine_name(result.getString(2));
        	med.setQuantity(result.getInt(3));
        	med.setRate(result.getInt(4));
        	med.setAmount(result.getInt(5));
        	
        	medList.add(med);
        }
        
        ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		
        return medList;
	}
	
    public static int MedInvoice(int patient_id) throws SQLException, ClassNotFoundException{
		
		con = ConnectionDB.connect();
		int bill = 0;
    	ps=con.prepareStatement("select sum(amount) from medicines where patient_id=?");
    	ps.setInt(1, patient_id);
    	
        result = ps.executeQuery();
        
        while(result.next())
        {
        	bill=result.getInt(1);
        }

        ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		
        return bill;	
    }
}
