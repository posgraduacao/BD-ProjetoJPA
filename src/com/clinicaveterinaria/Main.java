package com.clinicaveterinaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.clinicaveterinaria.model.Pessoa;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager em = null;
		try {
			factory = Persistence.createEntityManagerFactory("clinica_pu");
			em = factory.createEntityManager();
			
			Pessoa pessoa = new Pessoa();
			
			em.getTransaction().begin();
			pessoa = em.find(Pessoa.class, 0);
			//pessoa.setNome("João2");
			em.getTransaction().commit();
			
			System.out.println(pessoa.getNome());
			
		} catch (Exception e) {
			if (em!=null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (em!=null) {
				em.close();
			}
			if (factory!=null) {
				factory.close();
			}
		}

	}

}
