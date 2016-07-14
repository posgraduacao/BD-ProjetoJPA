package com.clinicaveterinaria.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PESSOA")
@NamedQueries({
	@NamedQuery (name="Pessoa.findBycpf",
			query = "SELECT p FROM Pessoa p where p.cpf = :cpf" ),
	@NamedQuery(name="Pessoa.listSemDataNascimento", 
		query="SELECT p FROM Pessoa p WHERE p.nascimento is null")
})
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pessoa_id", updatable=false)
	private Integer id;
	@Column(nullable=false, unique=true)
	private Long cpf;
	@Column(length=50, nullable=false)
	private String nome;
	private Date nascimento;
	@OneToOne(mappedBy="pessoa")
	private Endereco endereco;
	
	@Transient
	private Integer idade;
	
	@OneToMany(mappedBy="dono", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, orphanRemoval=true)
	private List<Animal> animais;
	
	public Integer getIdade() {
		return idade;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}
}