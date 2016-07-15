package com.clinicaveterinaria.facade;

import com.clinicaveterinaria.dao.PessoaDAO;
import com.clinicaveterinaria.model.Pessoa;

public class PessoaFacade {
	private PessoaDAO dao = new PessoaDAO();
	
	public void save(Pessoa pessoa) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(pessoa);
			dao.commitAndCloseTransaction();
		} catch(Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public void update(Pessoa pessoa) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(pessoa);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}
	
	public Pessoa buscar(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Pessoa pessoa = dao.find(id);
			dao.commitAndCloseTransaction();
			return pessoa;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Pessoa pessoa = dao.find(id);
			dao.delete(pessoa);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
