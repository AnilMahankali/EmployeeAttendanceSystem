package com.inet;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Update extends ActionSupport implements ServletRequestAware,ApplicationAware{	

	
	HttpServletRequest request;
	Map m;
	
	
	public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getServletRequest() {
        return request;
    }

    public void setApplication(Map m)
	{
		this.m=m;
	}   
    String driver = null;
    String url = null;
    String username = null;
    String password = null;
	
	public String execute()
	{		
		Class c = Update.class;
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
    PreparedStatement ps=null;	
   
    
	    ps=con.prepareStatement("select * from employeeattendance where emp_id=?");
	    String a = request.getParameter("fid");
		int k = Integer.parseInt(a);
		ps.setInt(1,k);			
	    System.out.println("This is : " +k);
		
		ResultSet res = ps.executeQuery();		
		List l=new ArrayList();
		
		while(res.next())
		{			
			m.put("a",res.getInt("emp_id"));
			m.put("b", res.getString("emp_name"));
			m.put("c",res.getString("attendance"));
		}
	
		ps.close();  		
		con.close();

	    }  catch(Exception e){ 
 		e.printStackTrace(); 
		}

		
			return SUCCESS;
		
	}


}
