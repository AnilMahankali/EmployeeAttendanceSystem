package com.inet;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.opensymphony.xwork2.ActionSupport;
public class Save extends ActionSupport{	
		
	Mybean mb=new Mybean();	
	
	public Mybean getMb() {
		return mb;
	}
	public void setMb(Mybean mb) {
		this.mb = mb;
	}
	   String driver = null;
	    String url = null;
	    String username = null;
	    String password = null;
		
	    
	    public void validate()
	    {
	    	
/*	    System.out.println("EMP ID : "+mb.getEmp_id());
	    System.out.println("EMP Name : "+mb.getEmp_name());
	    System.out.println("Attendance : "+mb.getAttendance());*/
	       if (mb.getEmp_id() == 0 )
	       {
	          addFieldError("emp_id","EMP_ID is required");
	       }
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
		System.out.println("In Save class, execute method()");
		Class c = Save.class;
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
	
	String s = "insert into employeeattendance values(?,?,?)";	
	PreparedStatement ps=con.prepareStatement(s);
	ps.setInt(1, mb.getEmp_id());
	ps.setString(2, mb.getEmp_name());
	ps.setString(3, mb.getAttendance());
	
	ps.executeUpdate();
	con.commit();
	
		ps.close();  		
		con.close();

		    } 
		catch(Exception e){ 
 			e.printStackTrace(); 
 		}

		
			return SUCCESS;
		
	}
	
}
