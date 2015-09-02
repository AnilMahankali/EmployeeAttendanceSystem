package com.inet;
import com.opensymphony.xwork2.ActionSupport;
public class Links extends ActionSupport{	
	
	public String save()
	{
		System.out.println("In Links Class,save() method");
		return "save";	
		
	}
	public String display()
	{
		System.out.println("In Links Class,display() method");
		return "display";	
		
	}
	
}
