package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QuizMethod extends Mini {
	static int count;

	public void m1() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root123");
			Statement stmt = conn.createStatement();

			ResultSet xx = stmt.executeQuery("select * from quest order by rand()");

			while (xx.next()) {
				System.out.println("*******************************************************************************");
//			System.out.print(xx.getString(1)+" ");
				System.out.print(xx.getString(2) + " ");
				System.out.println(xx.getString(3) + " ");
				System.out.println("A) " + xx.getString(4) + " ");
				System.out.println("B) " + xx.getString(5) + " ");
				System.out.println("C) " + xx.getString(6) + " ");
				System.out.println("D) " + xx.getString(7) + " ");
				System.out.println();
				System.out.println("Enter Choice ");
				Scanner scnr = new Scanner(System.in);

				String s = scnr.next();

				// char s = charScanner.next().charAt(0);
				if (s.equals("A") || s.equals("a") || s.equals("B") || s.equals("b") || s.equals("C") || s.equals("c")
						|| s.equals("D") || s.equals("d")) {
					String str = xx.getString("Ans");
					if (s.equalsIgnoreCase(str)) {
//				System.out.println("true");
						count++;
					}
				} else {
					System.out.println("****************************************");
					System.out.println("Invalid Input");
					System.out.println("****************************************");

				}
			}

			this.count = count;
			System.out.println("Total marks are " + count);
			Connection con = Connect.serverconnect();
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
