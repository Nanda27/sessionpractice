package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.updatedao;
import userbean.userbean;
@SuppressWarnings("serial")
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
userbean user=new userbean();
user.setId(Integer.parseInt(request.getParameter("id")));
user.setUsername(request.getParameter("username"));

user.setPassword(request.getParameter("password"));	
	
	updatedao.update(user);
	response.sendRedirect("fetch.jsp");
}
}
