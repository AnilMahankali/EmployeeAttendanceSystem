<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*;" %>

<html>

<head>
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
</head>

<body>
<a href="<s:url action="view.action"/>">Display Records</a>
<br><br>

<%--   This is -- <s:property value="#application.a" /> --%>

<b><font color="#5d8122" face="verdana">Update Details</font></b>

	<s:form action="updates"> 	

			<s:textfield label="Emp ID" value="%{#application.a}" name="mb.emp_id" readonly="true" cssClass="bord"/>
			<s:fielderror><s:param value="%{'emp_name'}" /></s:fielderror>
			<s:textfield label="Emp Name" value="%{mb.emp_name}" name="mb.emp_name" cssClass="bord"/>
			<s:fielderror><s:param value="%{'attendance'}" /></s:fielderror>
			<s:textfield label="Attendance " value="%{mb.attendance}" name="mb.attendance" cssClass="bord"/>
  
    <s:submit value="Update" />
    
</s:form>



</body>
</html>

