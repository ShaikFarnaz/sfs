package com.mph.view;

import java.util.*;
import java.util.function.BiPredicate;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.Exception.UserNotFoundException;
import com.mph.model.Employee;

public class MainClass {

	public static void main(String[] args) {

		EmployeeInterface ec = new EmployeeController();
		List elist = null;
		Scanner sc = new Scanner(System.in);

		String input = null;

		System.out.println("Enter your username");
		String un = sc.next();
		System.out.println("Enter your password");
		String ps = sc.next();
		System.out.println("Loading...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		try {
			BiPredicate<String, String> pred = (us, pw) -> us.equals("farnaz") && pw.equals("password");
			if (pred.test(un, ps))
				System.out.println("welcome");
			else
				throw new UserNotFoundException();
			do {
				System.out.println("Enter your Choice");
				System.out.println("1. Add Employee");
				System.out.println("2. View Employee");
				System.out.println("3.  Add Manager");
				System.out.println("4.  View Manager");
				System.out.println("5.  View sort");
				System.out.println("6.  Name start with a");
				System.out.println("7.  view Name start with a");
				System.out.println("8.  serialization");
				System.out.println("9.  Deserialization");
				System.out.println("10. Procedure Insert");
				System.out.println("11. Get ResultSet MetaData Info");
				System.out.println("12. RS Forward Only");
				System.out.println("13. RS scroll insensitive");
				System.out.println("14. RS scroll sensitive - insert");
				System.out.println("15. RS scroll sensitive - update");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					elist = ec.addEmployee();
					break;
				}

				case 2: {
					ec.viewEmployee(elist);
					break;
				}
				case 3: {
					ec.addManager();
					break;
				}
				case 4: {
					ec.viewManager();
					break;
				}
				case 5: {
					ec.sortByName(elist);
					break;
				}
				case 6: {
					ec.sortNames(elist);
					break;
				}
				case 7: {
					ec.viewNames(elist);
					break;
				}
				case 8: {
					ec.serial();
					break;
				}
				case 9: {
					ec.deSerial();
					break;
				}
				case 10: {
					ec.insertUsingProc();
					break;
				}
				case 11: {
					ec.rsmd();
					break;
				}
				case 12: {
					ec.type_forward_only_rs();
					break;
				}
				case 13: {
					ec.type_scroll_insensitive_rs();
					break;
				}
				case 14: {
					ec.type_scroll_sensitive_rs_insert();
				}
				case 15: {
					ec.type_scroll_sensitive_rs_update();
				}
				case 16: {
					ec.batchUpdate();
				}
				default: {
					System.out.println("No case exist");
				}

				}
				System.out.println("Do you want to continue ? Y or y for yes");
				input = sc.next();
			} while (input.equals("Y") || input.equals("y"));
			/*
			 * System.out.println("System Exited..Thanks for using our system !!!");
			 * System.exit(0);
			 */
		} catch (UserNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("Exception Raised");
			e.printStackTrace();
		} finally {
			System.out.println("Finally Executed");
		}
		System.out.println("System Exited..Thanks for using our system !!!");
		System.exit(0);
	}

}