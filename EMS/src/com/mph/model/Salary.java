package com.mph.model;

import java.io.Serializable;

public class Salary implements Serializable {
	private double basic;
	private double da;
	private double hra;
	private double pf;
	private double gross;
	private double net;

	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salary(double basic, double da, double hra, double gross, double net) {
		super();
		this.basic = basic;
		this.da = da;
		this.hra = hra;
		this.pf = pf;
		this.gross = gross;
		this.net = net;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getGross() {
		return gross;
	}

	public void setGross(double basic, double da, double hra) {
		this.gross = basic + da + hra;
	}

	public double getNet() {
		return net;
	}

	public void setNet(double gross, double pf) {
		this.net = gross - pf;
	}

	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", da=" + da + ", hra=" + hra + ", pf=" + pf + ", gross=" + gross + ", net="
				+ net + "]";
	}

}