package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarksName extends QuizMethod{
	public static  void nameM(StudentDetails st){
		Connection con = Connect.serverconnect();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into Studetailsmark(StudentName,Marksoutof10)values(?,?)");
			stmt.setString(1, st.getName());
			stmt.setInt(1, count);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("akshay");
	}

}
