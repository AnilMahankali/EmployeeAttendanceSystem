<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
</head>

<body>
<a href="<s:url action="view.action"/>">Display Records</a>
<br><br>
<b><font color="#5d8122" face="verdana">Insert Details</font></b>
	<s:form action="insert">   
			<s:fielderror><s:param value="%{'emp_id'}" /></s:fielderror>
			<s:textfield label="Emp_ID" name="mb.emp_id" cssClass="bord"/>
			<s:fielderror><s:param value="%{'emp_name'}" /></s:fielderror>
			<s:textfield label="Emp_Name" name="mb.emp_name" cssClass="bord"/>
			<s:fielderror><s:param value="%{'attendance'}" /></s:fielderror>
			<s:textfield label="Attendance" name="mb.attendance" cssClass="bord"/>
  
    <s:submit value="Insert" />
    
</s:form>
</body>
</html>