package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StuDatabase extends QuizMethod {
	public static String Grade;

	public void dataGrade() {
		if (count > 8) {
			String Grade = "A";
			this.Grade = Grade;
			// System.out.println("Grade A");
		} else if (count >= 6) {
			String Grade = "B";
			this.Grade = Grade;
			// System.out.println("Grade B");
		} else if (count == 5) {
			String Grade = "C";
			this.Grade = Grade;
			// System.out.println("Grade C");
		} else {
			String Grade = "Fail";
			this.Grade = Grade;
			// System.out.println("Fail Try Again");
		}
	//	System.out.println(Grade);
	}

	public static boolean nameToDatabase(StudentDetails st) {
		boolean f = false;
		Connection con = Connect.serverconnect();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into Studetailsmark(StudentName,Marksoutof10,Grade)values(?,?,?)");
			stmt.setString(1, st.getName());
			stmt.setInt(2, count);
			stmt.setString(3, Grade);
			stmt.executeUpdate();
			count=0;
			f = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;

	}

	public void showStudentByID(int id) {
		Connection con = Connect.serverconnect();
		try {
			Statement stmt = con.createStatement();
			ResultSet xx = stmt.executeQuery("select * from Studetailsmark where ID=" + id);
			System.out.print(xx.getString(0)+" ");
//			System.out.print(xx.getString(1) + " ");
			System.out.println(xx.getString(2) + " ");
			
			System.out.println("----------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		
	}

}
}
