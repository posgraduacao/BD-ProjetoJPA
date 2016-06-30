package com.clinicaveterinaria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ANIMAL")
public class Animal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="animal_id", updatable=false)
	private Integer id;
	@Column(name="tipo_id", nullable=false)
	private Integer tipoAnimalId;
	@Column(name="pessoa_id", nullable=false)
	private Integer pessoaId;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=true)
	private Date nascimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTipoAnimalId() {
		return tipoAnimalId;
	}
	public void setTipoAnimalId(Integer tipoAnimalId) {
		this.tipoAnimalId = tipoAnimalId;
	}
	public Integer getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
