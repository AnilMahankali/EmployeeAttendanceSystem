package com.inet;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.opensymphony.xwork2.ActionSupport;
public class Updates extends ActionSupport{	

	
	
	Mybean mb = new Mybean();
	
	public Mybean getMb() {
		System.out.println("getMb is called in Updates");
		return mb;
	}
	public void setMb(Mybean mb) {
		this.mb = mb;
		System.out.println("setMb is called in Updates");
	}

	String driver = null;
    String url = null;
    String username = null;
    String password = null;
	
    
    @Override
    public void validate() {
           if (mb.getEmp_name() == null || mb.getEmp_name().trim().equals(""))
	       {
	          addFieldError("emp_name","EMP_NAME is required");
	       }
	       if (mb.getAttendance() == null || mb.getAttendance().trim().equals(""))
	       {
	          addFieldError("attendance","ATTENDANCE is requried");
	       }
	    }    
    

    public String execute()
    {

	Class c = Updates.class;
	Properties props = new Properties();
	try {
		props.load(c.getResourceAsStream("DBConnection.properties"));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
	} catch (IOException e1) {
		e1.printStackTrace();
	}		
	try{
	Class.forName(driver); 
    java.sql.Connection con =DriverManager.getConnection(url,username,password);
	
	String s = "update employeeattendance set emp_name=?,attendance=? where emp_id=(?)";	
	System.out.println(s);
	PreparedStatement ps=con.prepareStatement(s);
	ps.setInt(3, mb.getEmp_id());
	ps.setString(1, mb.getEmp_name());
	ps.setString(2, mb.getAttendance());
	
	ps.executeUpdate();
	con.commit();
	
		ps.close();  		
		con.close();

		    } 
		catch(Exception e){
			System.out.println("EXCEPTION OCCURED");
 			e.printStackTrace(); 
 		}

		
			return SUCCESS;
		
	}
	
}
