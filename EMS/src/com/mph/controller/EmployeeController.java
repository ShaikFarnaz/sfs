package com.mph.controller;

import com.mph.dao.EmployeeDao;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.Collections;
import java.util.Comparator;

import com.mph.model.Employee;
import com.mph.model.Salary;

import com.mph.model.Manager;
import com.mph.Exception.*;

public class EmployeeController implements EmployeeInterface {
	Employee emp;
	Salary sal;
	Manager m;
	List emplist = new ArrayList();
	com.mph.dao.EmployeeDao empdao = new EmployeeDao();

	public List addEmployee() {
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		emp.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		emp.setEname(enam);

		sal = new Salary();

		System.out.println("Enter basic Salary");
		int basic = sc.nextInt();
		sal.setBasic(basic);
		System.out.println("Enter DA");
		int da = sc.nextInt();
		sal.setDa(basic);
		System.out.println("Enter HRA");
		int hra = sc.nextInt();
		sal.setHra(basic);
		System.out.println("Enter PF");
		int pf = sc.nextInt();
		sal.setPf(pf);

		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(), pf);
		emp.setSalary(sal);
		// emplist.add(emp);
		empdao.insertEmp(emp);

		// System.out.println(emp.getEid() + " " + emp.getEname());
		System.out.println("Employee " + eno + "Succesfully added");
		return emplist;
	}

	public void viewEmployee(List elist) {
		/*
		 * Iterator i=elist.iterator(); while(i.hasNext()) {
		 * System.out.println(i.next()); }
		 */
		// elist.forEach(list -> System.out.println(elist));
		empdao.viewEmp();
	}

	public void addManager() {
		m = new Manager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dept");
		String dept = sc.next();
		m.setDept(dept);
	}

	public void viewManager() {
		System.out.println(m);
	}

	public void sortByName(List elist) {
		Collections.sort(elist, Employee.nameComparator);
		/*
		 * Iterator i = elist.iterator(); while(i.hasNext()) {
		 * System.out.println(i.next()); }
		 */
		elist.forEach(list -> System.out.println(elist));
	}

	public void sortNames(List elist) {
		Predicate<Employee> p2 = emp2 -> (emp2.getEname().startsWith("A") || emp2.getEname().startsWith("a"));
		elist.stream().filter(p2).sorted(Comparator.comparing(Employee::getEname)).forEach(System.out::println);
	}

	public void viewNames(List elist) {
		System.out.println(elist);
	}

	public void serial() {
		Employee ep = new Employee();
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("myfil.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ep);

			System.out.println("Data successfully Serialized...");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	public void deSerial() {
		Employee st = null;
		try (FileInputStream fis = new FileInputStream("myfil.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			st = (Employee) ois.readObject();
			fis.close();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(emp.getEid());
		// System.out.println(emp.getEname());
		// System.out.println(emp.getSalary());
		System.out.println(emp);
	}

	public void insertUsingProc() {
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		e.setEname(enam);

		empdao.insertUsingProcedure(e);
	}

	public void rsmd() {
		empdao.rsmd();
	}

	@Override
	public void type_forward_only_rs() {
		empdao.type_forward_only_rs();

	}

	@Override
	public void type_scroll_insensitive_rs() {
		empdao.type_scroll_insensitive_rs();

	}

	@Override
	public void type_scroll_sensitive_rs_insert() {
		empdao.type_scroll_sensitive_rs_insert();

	}

	@Override
	public void type_scroll_sensitive_rs_update() {
		empdao.type_scroll_sensitive_rs_update();

	}

	@Override
	public void batchUpdate() {
		empdao.batchUpdate();

	}

}