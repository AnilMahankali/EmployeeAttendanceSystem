package com.inet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;


public class Display extends ActionSupport implements ServletRequestAware{	
	
	
	HttpServletRequest request;
	
	   String driver = null;
	    String url = null;
	    String username = null;
	    String password = null;
		
	public Display(){
		System.out.println("Display object is created");
	}
	public String execute()
	{
	System.out.println("entered execute() of Display class");
		Class c = Display.class;
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
	Statement st=con.createStatement(); 
	ResultSet rs = st.executeQuery("select * from employeeattendance");
	
    	List<Mybean> li = null;
    	li = new ArrayList<Mybean>();   
    	Mybean mb = null;
    
		while(rs.next()) 
			{ 	
			    mb = new Mybean();
			 
			    mb.setEmp_id(rs.getInt("emp_id"));
			    mb.setEmp_name(rs.getString("emp_name"));
			    mb.setAttendance(rs.getString("attendance"));		  
			    
			    li.add(mb);
			    
			}
			
		request.setAttribute("disp", li);
		
		rs.close(); 
 		st.close(); 
		con.close();

		    } 
		catch(Exception e){ 
 			e.printStackTrace(); 
 		}

		
			return SUCCESS;
		
	}

	public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getServletRequest() {
        return request;
}
	
}
