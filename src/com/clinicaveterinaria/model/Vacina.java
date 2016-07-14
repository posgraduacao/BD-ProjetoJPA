package com.clinicaveterinaria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vacina")
public class Vacina {
	
	@Id
	@Column(name="vacina_id")
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	@OneToMany(mappedBy="id.idVacina", fetch=FetchType.LAZY)
	private List<VacinaAnimal> vacinaAnimais;

	public List<VacinaAnimal> getVacinaAnimais() {
		return vacinaAnimais;
	}

	public void setVacinaAnimais(List<VacinaAnimal> vacinaAnimais) {
		this.vacinaAnimais = vacinaAnimais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}