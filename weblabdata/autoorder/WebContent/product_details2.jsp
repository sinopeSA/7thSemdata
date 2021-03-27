<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
</head>
<body bgcolor=#fefbd8>

<br/>
<br/>
<table border ="1" width="500" align="center"> 
<center>
<font color="red" size="6" face="monotype corsiva"> Order Details</font><br>
<font color="blue" size="5" > Search Results </font><br>
<tr><th>Next order Date</th></tr>
<%
ArrayList<String> al=(ArrayList)request.getAttribute("PROD_DETAILS");
Iterator it = al.iterator(); 
        while (it.hasNext()) 
{ %>
    <tr>
    	<td> <%= it.next() %> </td>
    	<br/>
    </tr> 
    		
 <%}
%>
</table>
</center>

</body>
</html>

