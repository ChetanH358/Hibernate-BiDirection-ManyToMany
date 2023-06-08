package com.yt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setSname("chinmay");
		student1.setSage(20);
		student1.setSgender("male");
		student1.setSmarks(95);

		Student student2 = new Student();
		student2.setSname("Manjunath");
		student2.setSage(22);
		student2.setSgender("male");
		student2.setSmarks(90);

		Student student3 = new Student();
		student3.setSname("priyanka");
		student3.setSage(18);
		student3.setSgender("female");
		student3.setSmarks(92);

		Student student4 = new Student();
		student4.setSname("Soumya");
		student4.setSage(19);
		student4.setSgender("female");
		student4.setSmarks(88);

		Courses courses1 = new Courses();
		courses1.setCname("Java");
		courses1.setCduration("3months");
		courses1.setCtrainer("UdayPawar");
		courses1.setCfees(5000);

		Courses courses2 = new Courses();
		courses2.setCname("SQL");
		courses2.setCduration("2months");
		courses2.setCtrainer("Manoj");
		courses2.setCfees(3000);

		Courses courses3 = new Courses();
		courses3.setCname("Logical Programming");
		courses3.setCduration("2months");
		courses3.setCtrainer("Darshan");
		courses3.setCfees(2500);

		Courses courses4 = new Courses();
		courses4.setCname("Springs");
		courses4.setCduration("3months");
		courses4.setCtrainer("Akshatha");
		courses4.setCfees(3500);

		Courses courses5 = new Courses();
		courses5.setCname("Aptitude");
		courses5.setCduration("2months");
		courses5.setCtrainer("Tejas");
		courses5.setCfees(1500);

		List<Courses> course_List_1 = new ArrayList<Courses>();
		course_List_1.add(courses1);
		course_List_1.add(courses2);
		course_List_1.add(courses3);
		
		List<Courses> course_List_2 = new ArrayList<Courses>();
		course_List_2.add(courses2);
		course_List_2.add(courses4);
		course_List_2.add(courses5);
		
		List<Courses> course_List_3 = new ArrayList<Courses>();
		course_List_3.add(courses1);
		course_List_3.add(courses3);
		course_List_3.add(courses5);
		
		student1.setCourses(course_List_1);
		student2.setCourses(course_List_2);
		student3.setCourses(course_List_1);
		student4.setCourses(course_List_3);
		
		List<Student> student_list_1 = new ArrayList<Student>();
		student_list_1.add(student1);
		student_list_1.add(student3);
		student_list_1.add(student4);
		
		List<Student> student_list_2 = new ArrayList<Student>();
		student_list_2.add(student1);
		student_list_2.add(student2);
		student_list_2.add(student3);
		
		List<Student> student_list_3 = new ArrayList<Student>();
		student_list_3.add(student1);
		student_list_3.add(student3);
		student_list_3.add(student4);

		List<Student> student_list_4 = new ArrayList<Student>();
		student_list_4.add(student2);

		List<Student> student_list_5 = new ArrayList<Student>();
		student_list_5.add(student2);
		student_list_5.add(student4);

		courses1.setStudents(student_list_1);
		courses2.setStudents(student_list_2);
		courses3.setStudents(student_list_3);
		courses4.setStudents(student_list_4);
		courses5.setStudents(student_list_5);
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(student4);
		entityManager.persist(courses1);
		entityManager.persist(courses2);
		entityManager.persist(courses3);
		entityManager.persist(courses4);
		entityManager.persist(courses5);
		entityTransaction.commit();
		

//		delete the data of students whose fees is less than 3500
//		update trainer name to uday whose fees is more than 2500
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
