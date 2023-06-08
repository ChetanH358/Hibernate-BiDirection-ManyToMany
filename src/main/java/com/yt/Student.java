package com.yt;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Sid;
	@Column(nullable = false)
	private String Sname;
	private int Sage;
	private String Sgender;
	private int Smarks;
	
	@ManyToMany
	List<Courses> courses;

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public int getSage() {
		return Sage;
	}

	public void setSage(int sage) {
		Sage = sage;
	}

	public String getSgender() {
		return Sgender;
	}

	public void setSgender(String sgender) {
		Sgender = sgender;
	}

	public int getSmarks() {
		return Smarks;
	}

	public void setSmarks(int smarks) {
		Smarks = smarks;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

}
