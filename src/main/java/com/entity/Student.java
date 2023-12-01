package com.entity;

public class Student {

	private int id;
	private String fname, add, qual, email, dob;

	public Student(String fname, String dob, String add, String qual, String email) {
		super();
		this.fname = fname;
		this.dob = dob;
		this.add = add;
		this.qual = qual;
		this.email = email;

	}

	public Student(int id, String fname, String dob ,String add, String qual, String email ) {
		super();
		this.id = id;
		this.fname = fname;
		this.add = add;
		this.qual = qual;
		this.email = email;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", dob=" + dob + ", add=" + add + ", qual=" + qual
				+ ", email=" + email + "]";
	}
}
