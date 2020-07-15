/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Patient;
import com.util.ConnectionDB;



/**
 * @author Suneha Ghosh
 *
 */
public class PatientDAO {
	
	static Connection con= null;
	static PreparedStatement ps = null;
	static ResultSet result = null;
	
	public static boolean AddPatient(Patient pat) throws SQLException, ClassNotFoundException{
		
		boolean flag = false;
		con = ConnectionDB.connect();
		
		ps = con.prepareStatement("select * from room_type where room_type=?");
		ps.setString(1, pat.getRoom_type());
		
        result = ps.executeQuery();
        
        while(result.next())
        {
        	pat.setRoom_id(result.getInt(1));
        }
        
        ps = null;
		
		ps = con.prepareStatement("insert into patient(ssn, patient_id, patient_name, address, age, doj, dod, room_id) values (?,?,?,?,?,?,?,?)");
		ps.setInt(1, pat.getSsn());
		ps.setInt(2, pat.getPatient_id());
		ps.setString(3, pat.getPatient_name());
		ps.setString(4, pat.getAddress());
		ps.setInt(5, pat.getAge());
		ps.setDate(6, (Date) pat.getDoj());
		ps.setDate(7, (Date) pat.getDod());
		ps.setInt(8, pat.getRoom_id());
		
		int rowstatus = ps.executeUpdate();
		ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		if(rowstatus>0)
			return true;
		return flag;
	}
	
    public static boolean EditPatient(String patient_name, String address, int age, Date sqlDate, String room_type, int patient_id) throws SQLException, ClassNotFoundException{	
    	
    	boolean flag=false;
    	Patient pat = null;
    	con=ConnectionDB.connect();
    	
    	ps = con.prepareStatement("select * from room_type where room_type=?");
		ps.setString(1, room_type);
		
        result = ps.executeQuery();
        
        while(result.next())
        {
        	pat = new Patient();
        	pat.setRoom_id(result.getInt(1));
        }
        
        ps = null;
    	
    	ps=con.prepareStatement("UPDATE patient SET patient_name=?, address=?, age=?, doj=?, room_id=? WHERE patient_id=?");
    	ps.setString(1, patient_name);
    	ps.setString(2, address);
    	ps.setInt(3, age);
    	ps.setDate(4, sqlDate);
    	ps.setInt(5, pat.getRoom_id());
    	ps.setInt(6, patient_id);
    	
    	int rowstatus = ps.executeUpdate();
    	ConnectionDB.closeConnection(con);
    	ConnectionDB.closeStatement(ps);
    	
    	if(rowstatus>0)
    	{
    		return true;
    	}
		
		return flag;
    }
    
    public static boolean DeletePatient(int patient_id) throws SQLException, ClassNotFoundException{
		
    	boolean flag = false;
		con = ConnectionDB.connect();
        
        ps = con.prepareStatement("delete from medicines where patient_id="+patient_id);
        int rowstatus1 = ps.executeUpdate();
        
        ps = con.prepareStatement("delete from diagonostics where patient_id="+patient_id);
        int rowstatus2 = ps.executeUpdate();
        
        ps = con.prepareStatement("delete from patient where patient_id="+patient_id);
        int rowstatus3 = ps.executeUpdate();
        
		ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		if(rowstatus1>0 && rowstatus2>0 && rowstatus3>0)
		{
			return true;
		}		
		return flag;
	} 
    
    public static boolean checkPatID(int patient_id) throws SQLException, ClassNotFoundException{
    	
    	boolean flag=false;
    	con=ConnectionDB.connect();
    	ps = con.prepareStatement("select patient_id from patient where patient_id=?");
		ps.setInt(1, patient_id);
		
        result = ps.executeQuery();
        
        while(result.next())
        {
        	return true;
        }
        
        return flag;
    }
    
    public static Patient SearchPatient(int patient_id) throws SQLException, ClassNotFoundException{
		
    	Patient pat=null;
		con = ConnectionDB.connect();
		
		ps = con.prepareStatement("select * from patient, room_type where patient.room_id=room_type.id and patient_id=?");
        ps.setInt(1, patient_id);
        
        result = ps.executeQuery();
        
        while(result.next())
        {
        	pat = new Patient();
        	pat.setPatient_name(result.getString(3));
        	pat.setAddress(result.getString(4));
        	pat.setAge(result.getInt(5));
        	pat.setDoj(result.getDate(6));
        	pat.setDod(result.getDate(7));
        	pat.setRoom_type(result.getString(10));
        	pat.setRate(result.getInt(11));
        }
		
		ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		
		return pat;
	
	}
    
    public static List<Patient> ViewPatient() throws SQLException, ClassNotFoundException{
    	
    	Patient pat=null;
    	List<Patient> patList = new ArrayList<Patient>();
		con = ConnectionDB.connect();
    	ps=con.prepareStatement("select * from patient");
    	
        result = ps.executeQuery();
        
        while(result.next())
        {
        	pat = new Patient();
        	pat.setPatient_id(result.getInt(2));
        	pat.setPatient_name(result.getString(3));
        	pat.setAddress(result.getString(4));
        	pat.setAge(result.getInt(5));
        	pat.setDoj(result.getDate(6));
        	pat.setRoom_type(result.getString(7));
        	
        	patList.add(pat);
        }
		
		ConnectionDB.closeConnection(con);
		ConnectionDB.closeStatement(ps);
		
		return patList;
    	
    }

}
