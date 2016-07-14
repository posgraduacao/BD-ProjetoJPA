package com.clinicaveterinaria.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vacinaanimal")
public class VacinaAnimal {
	
	@EmbeddedId
	private VacinaAnimalPK id;
	
	@ManyToOne
	@JoinColumn(name = "vacina_id", insertable = false, updatable = false)
	private Vacina vacina;
	
	@ManyToOne
	@JoinColumn(name = "animal_id", insertable = false, updatable = false)
	private Animal animal;
	
	private String descricaoVeterinario;

	public VacinaAnimal() {
		id = new VacinaAnimalPK();
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
		if(vacina != null)
			this.getId().setIdVacina(vacina.getId());
		else
			this.getId().setIdVacina(null);
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
		if(animal != null)
			this.getId().setIdAnimal(animal.getId());
		else
			this.getId().setIdAnimal(null);
	}

	public VacinaAnimal(VacinaAnimalPK id) {
		super();
		this.id = id;
	}

	public VacinaAnimalPK getId() {
		return id;
	}

	public void setId(VacinaAnimalPK id) {
		this.id = id;
	}

	public String getDescricaoVeterinario() {
		return descricaoVeterinario;
	}

	public void setDescricaoVeterinario(String descricaoVeterinario) {
		this.descricaoVeterinario = descricaoVeterinario;
	}

	public Date getDataVacinacao() {
		return id.getDataVacinacao();
	}

	public void setDataVacinacao(Date dataVacinacao) {
		id.setDataVacinacao(dataVacinacao);
	}	
}