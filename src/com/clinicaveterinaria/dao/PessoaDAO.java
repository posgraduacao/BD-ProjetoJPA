package com.clinicaveterinaria.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.clinicaveterinaria.model.Pessoa;

public class PessoaDAO extends GenericDAO<Integer, Pessoa>{
	public PessoaDAO() {
		super(Pessoa.class);
	}
	
	public List<Pessoa> listar(){
		String sql = "select p from Pessoa p";
		Query query = super.getEntityManager().createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}
	
	public List<Pessoa> listarSemDataNascimento(){
		Query query = super.getEntityManager().
				createNamedQuery("Pessoa.listSemDataNascimento");
		
		@SuppressWarnings("unchecked")
		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}
	
	public Pessoa findByCPF(Long cpf){
		Query query = super.getEntityManager().
				createNamedQuery("Pessoa.findBycpf");
		query.setParameter("cpf", cpf);
		try{
			Pessoa retorno = (Pessoa)query.getSingleResult();
			return retorno;
		}catch(NoResultException nr){
			return null;
		}
	}
	
	public Pessoa findEager(Integer id){
		String sql = "select p from Pessoa p "
		+ " inner join fetch p.animais"
		+ " where p.id = :idPessoa";
			TypedQuery<Pessoa> query = super.getEntityManager().
					createQuery(sql,Pessoa.class);
			query.setParameter("idPessoa", id);
		try {
			Pessoa retorno = query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public List<Pessoa> listarPessoasComTipoAnimal(Integer idTipoAnimal){
		String sql = "select distinct p from Pessoa p "
				+ "inner join fetch p.animais a "
				+ "where a.tipoAnimal.id = :idTipoAnimal "
				+ "order by p.nome asc";
		Query query = super.getEntityManager().createQuery(sql); 
		query.setParameter("idTipoAnimal", idTipoAnimal);
		
		@SuppressWarnings("unchecked")
		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}
}