package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.logindao;
import userbean.userbean;
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	userbean user=new userbean();
	user.setUsername(request.getParameter("username"));
	user.setPassword(request.getParameter("password"));
	
	logindao.login(user);
	boolean loginstatus=user.isValid();
	if(loginstatus) {
		HttpSession session=request.getSession();
		session.setAttribute("usersession", "user");
		response.sendRedirect("userprofile.jsp");
		
		
		
	}
	
}
}
