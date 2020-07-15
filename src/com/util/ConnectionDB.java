/**
 * 
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Suneha Ghosh
 *
 */
public class ConnectionDB {
	Connection con=null;
    public static Connection connect ()
    {
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db","root","Subhomoy@98");	
    		return con;
    	}
    	catch(Exception e)
    	{ 		
    		return null;
    	}
    }
    
    public static void closeConnection(Connection con)
    {
    	if(con!=null)
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
    
    public static void closeStatement(PreparedStatement ps)
    {
    	if(ps!=null)
    	{
    		try
    		{
    			ps.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
}
