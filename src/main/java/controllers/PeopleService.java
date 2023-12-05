package controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.People;

public class PeopleService {
	EntityManagerFactory emf;
	
	public PeopleService() {
		try{
			this.emf = Persistence.createEntityManagerFactory("test-jpa");
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public boolean closeEntityManagerFactory() {
		try {
			emf.close();
			return true;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public EntityManager getEntityManager() {
		try {
			return emf.createEntityManager();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public People findPeople(Integer id) {
		try {
			EntityManager em = getEntityManager();
			People p = em.find(People.class, id);
			em.close();
			return p;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public boolean deletePeople(Integer id) {
		try {
			EntityManager em = getEntityManager();
			em.getTransaction().begin();
			
			People p = em.find(People.class, id);
			if(p != null) {
				em.remove(p);
				em.getTransaction().commit();
				em.close();
				return true;
			} else {
				em.getTransaction().rollback();
				em.close();
				return false;
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean savePeople(People people) {
		try {
			EntityManager em = getEntityManager();
			em.getTransaction().begin();
			em.persist(people);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}
