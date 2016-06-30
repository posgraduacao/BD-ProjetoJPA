package com.clinicaveterinaria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VacinaAnimalID implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="vacina_id")
	private Integer idVacina;
	
	@Column(name="animal_id")
	private Integer idAnimal;
	
	private Date dataVacinacao;

	public Integer getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Integer idVacina) {
		this.idVacina = idVacina;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public Date getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVacinacao == null) ? 0 : dataVacinacao.hashCode());
		result = prime * result + ((idAnimal == null) ? 0 : idAnimal.hashCode());
		result = prime * result + ((idVacina == null) ? 0 : idVacina.hashCode());
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
		VacinaAnimalID other = (VacinaAnimalID) obj;
		if (dataVacinacao == null) {
			if (other.dataVacinacao != null)
				return false;
		} else if (!dataVacinacao.equals(other.dataVacinacao))
			return false;
		if (idAnimal == null) {
			if (other.idAnimal != null)
				return false;
		} else if (!idAnimal.equals(other.idAnimal))
			return false;
		if (idVacina == null) {
			if (other.idVacina != null)
				return false;
		} else if (!idVacina.equals(other.idVacina))
			return false;
		return true;
	}	
	
	
}
