package com.clinicaveterinaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.clinicaveterinaria.model.Animal;
import com.clinicaveterinaria.model.Pessoa;
import com.clinicaveterinaria.model.VacinaAnimal;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager em = null;
		try {
			factory = Persistence.createEntityManagerFactory("clinica_pu");
			em = factory.createEntityManager();
			
//			Pessoa pessoa = new Pessoa();
//			
//			em.getTransaction().begin();
//			pessoa = em.find(Pessoa.class, 0);
//			//pessoa.setNome("João2");
//			em.getTransaction().commit();
			
//			Animal a;
//			
//			em.getTransaction().begin();
//			a = em.find(Animal.class, 0);
//			em.getTransaction().commit();
//			
//			System.out.println(a.getNome());
//			System.out.println(a.getTipo().getNomeRaca());
//			System.out.println(a.getDono().getNome());
//			
//			for(Alergia al : a.getAlergias()) {
//				System.out.println(al.getNome());
//			}
			
			Pessoa p;
			
			em.getTransaction().begin();
			p = em.find(Pessoa.class, 0);
			em.getTransaction().commit();
			
			System.out.println(p.getNome());
			
			for (Animal a : p.getAnimais()) {
				System.out.println(a.getNome());
				for (VacinaAnimal va : a.getVacinasAnimal()) {
					System.out.println(va.getId().getDataVacinacao() + "" + va.getId().getIdVacina());
				}
			}
			
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
