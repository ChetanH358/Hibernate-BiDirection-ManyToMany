package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
	
//		update trainer name to UdayPawar whose Course-fees is more than 2500
//		getting exception for this code 
		Query query = entityManager.createQuery("select c from Courses c where c.Cfees > ?1");
		query.setParameter(1, 2500);
		List<Courses> details = query.getResultList();
		
		for(Courses ele : details) {
			ele.setCtrainer("UdayPawar");
			entityTransaction.begin();
			entityManager.merge(ele);
			entityTransaction.commit();
		}
		
/*	
 *      ************************ Before updation ***********************************
 *      
     	1	3months	5000	Java	             UdayPawar
		2	2months	3000	SQL	                 Manoj
		3	2months	2500	Logical Programming  Darshan
		4	3months	3500	Springs	             Akshatha
		5	2months	1500	Aptitude	         Tejas
		
		******************* After updation ***********************************
		
		1	3months	5000	Java	             UdayPawar
		2	2months	3000	SQL	                 UdayPawar
		3	2months	2500	Logical Programming	 UdayPawar
		4	3months	3500	Springs	             UdayPawar
		5	2months	1500	Aptitude	         Tejas
 
	*/	
	}

}
