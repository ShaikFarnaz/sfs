package com.mph.controller;

import java.util.List;

public interface EmployeeInterface {
	public List addEmployee();

	public void viewEmployee(List elist);

	public void addManager();

	public void viewManager();

	public void sortByName(List elist);

	public void sortNames(List elist);

	public void viewNames(List elist);

	public void serial();

	public void deSerial();

	public void insertUsingProc();

	public void rsmd();

	public void type_forward_only_rs();

	public void type_scroll_insensitive_rs();

	public void type_scroll_sensitive_rs_insert();

	public void type_scroll_sensitive_rs_update();

	public void batchUpdate();

}