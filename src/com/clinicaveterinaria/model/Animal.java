package com.clinicaveterinaria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ANIMAL")
public class Animal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="animal_id", updatable=false)
	private Integer id;
	@ManyToOne
    @JoinColumn(name = "tipoanimal_id")
	private TipoAnimal tipoAnimal;
	@ManyToOne
    @JoinColumn(name = "pessoa_id")
	private Pessoa dono;
	private String nome;
	
	@OneToMany
	(mappedBy="id.idAnimal", fetch=FetchType.LAZY)
	private List<VacinaAnimal> vacinaAnimal;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
	  name="alergiaanimal",
	  joinColumns={@JoinColumn(name="animal_id", referencedColumnName="animal_id")},
	  inverseJoinColumns={@JoinColumn(name="alergia_id", referencedColumnName="alergia_id")})
	private List<Alergia> alergias;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Pessoa getDono() {
		return dono;
	}
	
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public List<VacinaAnimal> getVacinaAnimal() {
		return vacinaAnimal;
	}

	public void setVacinaAnimal(List<VacinaAnimal> vacinaAnimal) {
		this.vacinaAnimal = vacinaAnimal;
	}

	public List<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}

	public void setId(Integer id) {
		this.id = id;
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