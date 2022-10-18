package com.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Mini {
	public void StudentLogin() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("**********************************************");
		System.out.println("Welcome to the Quiz Contest");
		System.out.println("**********************************************");
		while (true) {
			System.out.println("Please Enter 1 to Participate Into Quiz");
			System.out.println("Press 2 To View Marks Of All Students");
			System.out.println("Press 3 To Exit The Quiz");
			System.out.println("******************************************");
			try {
				int a = Integer.parseInt(bf.readLine());

				if (a == 1) {
					System.out.println("-----------------------------------------");
					System.out.println("Welcome to the Quiz");
					System.out.println("Please Enter Your Name");
					System.out.println("-----------------------------------------");
					String name = bf.readLine();
					StudentDetails sd = new StudentDetails(name);
					QuizMethod qm = new QuizMethod();
					qm.m1();
					new StuDatabase().dataGrade();
					StuDatabase.nameToDatabase(sd);

				} else if (a == 2) {
					Connection con = Connect.serverconnect();
					Statement stmt = con.createStatement();
					ResultSet ss = stmt.executeQuery("select * from Studetailsmark");
					System.out.println("ID " + "      " + "NAME" + "      " + "MARKS" + "       " + "GRADE");
					System.out.println("_________________________________________");
					while (ss.next()) {
						System.out.print(ss.getString(1));
						System.out.printf("%20s", ss.getString(2) + "        ");
						System.out.printf("%-10s", ss.getString(3));
						System.out.println(ss.getString(4));
						System.out.println("_________________________________________");
					}

						
				} else if (a == 3) {
					System.out.println("Thanks For Participating In The Quiz Contest");
					break;

				} else {
					System.out.println("Incorrect Choice");

				}
			} catch (Exception e) {
				e.printStackTrace();
				// System.out.println("Invalid Character");
			}
		}

	}
}
