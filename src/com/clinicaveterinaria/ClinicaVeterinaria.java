package com.clinicaveterinaria;

import com.clinicaveterinaria.dao.GenericDAO;
import com.clinicaveterinaria.facade.PessoaFacade;
import com.clinicaveterinaria.model.Pessoa;

public class ClinicaVeterinaria {

	public static void main(String[] args) {
		try{
			PessoaFacade facade = new PessoaFacade();
			Pessoa pessoa = facade.buscar(2);
			System.out.println(pessoa.getNome());
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Saindo!!!");
	}
}