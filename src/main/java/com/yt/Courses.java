package com.yt;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cid;
	@Column(nullable = false)
	private String Cname;
	private String Cduration;
	private String Ctrainer;
	private int Cfees;
	
	@ManyToMany
	List<Student> students;

	public int getCid() {
		return Cid;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCduration() {
		return Cduration;
	}

	public void setCduration(String cduration) {
		Cduration = cduration;
	}

	public String getCtrainer() {
		return Ctrainer;
	}

	public void setCtrainer(String ctrainer) {
		Ctrainer = ctrainer;
	}

	public int getCfees() {
		return Cfees;
	}

	public void setCfees(int cfees) {
		Cfees = cfees;
	}

}