package com.inet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport implements ServletRequestAware{	

	
	
	HttpServletRequest request;	    
    String driver = null;
    String url = null;
    String username = null;
    String password = null;
    PreparedStatement ps = null;
    Connection con = null;
	
	
	public String execute(){
		Class c = Delete.class;
		Properties props = new Properties();
			try {
				props.load(c.getResourceAsStream("DBConnection.properties"));
			} catch (IOException e2) {
				
				e2.printStackTrace();
			}
			 driver = props.getProperty("driver");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			
	
	try {
		Class.forName(driver);
		 
		  
			
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} 
   
    String cv[]=request.getParameterValues("rdel");
   if(cv!=null){
    	for(int i=0;i<cv.length;i++){
    		try {
    			con =DriverManager.getConnection(url,username,password);
				ps = con.prepareStatement("delete from employeeattendance where emp_id=(?)");
				int k = Integer.parseInt(cv[i]);
	    		System.out.println("this is" +k);
	    		ps.setInt(1,k);		
	    		ps.executeUpdate();
	    		con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}try {
				ps.close();
				con.close();
			   	} catch (SQLException e) {
				e.printStackTrace();
			   	}  
		       		
    	}
    	 return SUCCESS;
   }
   return "error";
	}    
	

 	
	public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getServletRequest() {
        return request;
    }
	
}
