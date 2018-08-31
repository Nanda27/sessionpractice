package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import userbean.userbean;

public class logindao {

	public static void login(userbean user) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda123");
			PreparedStatement pstmt=conn.prepareStatement("select * from student1 where username=? and password=?");
		pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        boolean req=rs.next();
        if(req) {
        	user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setValid(true);
        }else {
        	user.setValid(false);
        }
		}catch(Exception e) {
			System.out.println(e);
		}
		}

}
