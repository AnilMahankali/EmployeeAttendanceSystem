<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*;" %>

<head>
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
<script type="text/javascript">
function deleteRecord()
	{	     
	    document.fom.action="del.action";
	    document.fom.submit();
	}
function editr(val)
{	     
    document.fom.action="update.action?fid="+val;
    document.fom.submit();
}	
</script>
</head>

<a href="<s:url action="saveLink.action"/>">Insert</a>

<br><br>

<table class="bordt">
<form name="fom" method="post">
<%
	List l=(List)request.getAttribute("disp");
if(l!=null)
{

	Iterator it=l.iterator();
	
	while(it.hasNext())
	{
		
		com.inet.Mybean b=(com.inet.Mybean)it.next();
		int id = b.getEmp_id();
		String name = b.getEmp_name();
		String attendance = b.getAttendance();
%>
        <tr> 
        <td class="bord"><input type="checkbox" value="<%= id %>" name="rdel"></td>
        <td class="bord"><%= id %></td>
        <td class="bord"><%= name %></td>
        <td class="bord"><%= attendance %></td>
        <td class="bord"><a href="javascript:editr('<%= id %>')">Edit</a></td>         
        </tr> 
        
<% 		
				
	}	
}

%>  
<input type="button" value="delete" onclick="deleteRecord();">
</table>

</form>

