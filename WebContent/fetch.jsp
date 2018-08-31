<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<th>id</th>
<th>username</th>
<th>password</th>

</tr>

<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda123");
	PreparedStatement pstmt=conn.prepareStatement("select * from student1");
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
	%>
	<tr><td><%=rs.getInt("id") %></td>	
	<td><%=rs.getString("username") %></td>
	<td><%=rs.getString("password") %></td>
	<td><a href="edit.jsp?user=<%=rs.getString("username")%>">EDIT</a>/<a href="delete.jsp?user=<%=rs.getString("username")%>">Delete</a>
	</tr>
	
	
	
	
	<% 
	
	
	}
	
	
	
	
	
	
	
}catch(Exception e){
	System.out.println(e);
}






%>

</table>
<a href="index.jsp">Home</a>
</body>
</html>