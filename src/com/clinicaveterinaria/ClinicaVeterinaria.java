package com.clinicaveterinaria;

import com.clinicaveterinaria.dao.GenericDAO;
import com.clinicaveterinaria.dao.PessoaDAO;
import com.clinicaveterinaria.model.Pessoa;

public class ClinicaVeterinaria {

	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		try{
			Pessoa pessoa;
			pessoaDAO.beginTransaction();
			pessoa = pessoaDAO.findByCPF(111L);
			pessoaDAO.commitAndCloseTransaction();
			
			System.out.println(pessoa.getNome());
			
		}catch(Exception e){
			pessoaDAO.rollbackAndCloseTransaction();
			e.printStackTrace();
		}finally{
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Saindo!!!");
	}
}