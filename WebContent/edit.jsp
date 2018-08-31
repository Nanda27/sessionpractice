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
<%
try{
	String username=request.getParameter("user");
	Class.forName( "oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda123");
	PreparedStatement pstmt=conn.prepareStatement("select * from student1 where username=?");
pstmt.setString(1, username);
ResultSet rs=pstmt.executeQuery();
boolean req=rs.next();
%>
<form action="updateservlet" method="post">
Id:<input type="text" name="id" value=<%=rs.getInt("id") %>><br>

Username:<input type="text" name="username" value=<%=rs.getString("username") %> readonly="readonly"><br> 

Password:<input type="text" name="password" value=<%=rs.getString("password") %>><br>

<input type="submit" value="update">









</form>








<% 
}catch(Exception e){
	System.out.println(e);
}



%>
</body>
</html>