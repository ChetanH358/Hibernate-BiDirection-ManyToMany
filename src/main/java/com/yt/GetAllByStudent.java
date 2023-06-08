package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAllByStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("select s from Student s");
		List<Student> student_details = query.getResultList();

		for (Student student_ele : student_details) {
			System.out.println("*******************************************");
			System.out.println("*******************************************");
			System.out.println("Student ID : " + student_ele.getSid());
			System.out.println("Student Name : " + student_ele.getSname());
			System.out.println("Student Age : " + student_ele.getSage());
			System.out.println("Student Gender : " + student_ele.getSgender());
			List<Courses> course_details = student_ele.getCourses();
			System.out.println("*******************************************");
			for (Courses course_ele : course_details) {
				System.out.println("Course ID :" + course_ele.getCid());
				System.out.println("Course Name :" + course_ele.getCname());
				System.out.println("Course Fees :" + course_ele.getCfees());
				System.out.println("Course Trainer :" + course_ele.getCtrainer());
				System.out.println("Course Duration :" + course_ele.getCduration());
			}
			System.out.println("*******************************************");
			System.out.println("*******************************************");
		}

	}

}
