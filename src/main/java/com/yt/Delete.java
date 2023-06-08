package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

//		Need to write code for deleting the detail's
//		delete students whose marks are less than 90
		

//		**** IMP the below **** code is not working and i think it's not possible because it goes into recursion if we try to access course and 
//		studnet details simultaniously 
		
		Query query = entityManager.createQuery("select s from Student s where s.Smarks < ?1");
		query.setParameter(1, 90);
		List<Student> student_details = query.getResultList();

//		traverse the list i.e students
		for (Student ele : student_details) {

//			get deatils of all the courses and store it in list		
			Query course_details = entityManager.createQuery("select c from Courses c");
			List<Courses> course_list = course_details.getResultList();

//			traverse the list and get all student details for each course		
			for (Courses course_ele : course_list) { //course list array

//				storing each course of students in list
				List<Student> student_det = course_ele.getStudents();

//				traversing students to write logic
				for (Student student_ele : student_det) {
					if (student_ele.getSid() == ele.getSid()) {
						entityTransaction.begin();
						entityManager.remove(student_ele);
						entityTransaction.commit();
					}

				}
			}
			entityTransaction.begin();
			entityManager.remove(ele);
			entityTransaction.commit();
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		---> getting exception parent table foregin-key fails <---
		/*
		 * Student S_details_1 = entityManager.find(Student.class, 3); Student
		 * S_details_2 = entityManager.find(Student.class, 4); Courses C_details_3 =
		 * entityManager.find(Courses.class, 1); Courses C_details_4 =
		 * entityManager.find(Courses.class, 2); Courses C_details_5 =
		 * entityManager.find(Courses.class, 3); Courses C_details_6 =
		 * entityManager.find(Courses.class, 5);
		 * 
		 * // if we attempting to delete (id) which is not present in data-base it will
		 * give "Data Not Found" if (S_details_1 != null) { entityTransaction.begin();
		 * entityManager.remove(S_details_1); entityManager.remove(S_details_2);
		 * entityManager.remove(C_details_3); entityManager.remove(C_details_4);
		 * entityManager.remove(C_details_5); entityManager.remove(C_details_6);
		 * System.out.println("data deleted"); entityTransaction.commit();
		 * 
		 * } else { System.out.println("Data Not Found !"); }
		 * 
		 * /* ************ before deletion ************ 1 20 male 95 chinmay 2 22 male
		 * 90 Manjunath 3 18 female 92 priyanka 4 19 female 88 Soumya
		 */

		/*
		 * *********** after deletion *************** 1 20 male 95 chinmay 2 22 male 90
		 * Manjunath 3 18 female 92 priyanka 4 19 female 88 Soumya
		 */

		/*
		 * ---> getting exception parent table foregin-key fails <--- Query query =
		 * entityManager.createQuery("select s from Student s where ");
		 * query.setParameter(0, query); List<Student> details = query.getResultList();
		 * 
		 * for(Student ele:details) { entityTransaction.begin();
		 * entityManager.remove(ele); entityTransaction.commit(); }
		 */

	}
}
