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

import com.bean.Diagonostics;
import com.util.ConnectionDB;

/**
 * @author Suneha Ghosh
 *
 */
public class DiagonosticDAO {
	
	static Connection con= null;
	static PreparedStatement ps = null;
	static ResultSet result = null;
	
	public static boolean AddDiagonostic(Diagonostics diag) throws SQLException, ClassNotFoundException{
		
		boolean flag = false;
		con = ConnectionDB.connect();
		ps = con.prepareStatement("insert into diagonostics(patient_id, test, amount) values(?,?,?)");
		ps.setInt(1, diag.getPatient_id());
		ps.setString(2, diag.getDiagonosis());
		ps.setInt(3, diag.getAmount());
		
		int rowstatus = ps.executeUpdate();
		ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		if(rowstatus>0)
			return true;
		return flag;
	}
	
        public static List<Diagonostics> SearchTests(int patient_id) throws SQLException, ClassNotFoundException{
		
		Diagonostics diag = null;
		List<Diagonostics> testList = new ArrayList<Diagonostics>();
		con = ConnectionDB.connect();
    	ps=con.prepareStatement("select * from diagonostics where patient_id=?");
    	ps.setInt(1, patient_id);
    	
        result = ps.executeQuery();
        
        while(result.next())
        {
        	diag = new Diagonostics();
        	diag.setDiagonosis(result.getString(2));
        	diag.setAmount(result.getInt(3));
        	
        	testList.add(diag);
        }
        
        ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		
        return testList;
	}
        
    public static int TestInvoice(int patient_id) throws SQLException, ClassNotFoundException{
		
		con = ConnectionDB.connect();
		int bill = 0;
    	ps=con.prepareStatement("select sum(amount) from diagonostics where patient_id=?");
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
