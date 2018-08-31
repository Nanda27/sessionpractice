package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import userbean.userbean;

public class updatedao {

	public static void update(userbean user) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda123");
			PreparedStatement pstmt=conn.prepareStatement("update student1 set password=?,id=? where username=?");
			 pstmt.setString(1, user.getPassword());
			 pstmt.setInt(2, user.getId());
			pstmt.setString(3, user.getUsername());
		   
		   
		    int i=pstmt.executeUpdate();
		    if(i==1) {
		    	System.out.println("update success");
		    }else {
		    	System.out.println("not success");
		    }
		    
		    
		}catch(Exception e) {
			System.out.println(e);
		}
		}

}
