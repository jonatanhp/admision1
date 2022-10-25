package com.caj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "tabla de ubigeos")
@Entity
@Table(name = "ubigeo")
public class Ubigeo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUbigeo;
	
	public Integer getIdUbigeo() {
		return idUbigeo;
	}

	public void setIdUbigeo(Integer idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	public String getCodDep() {
		return codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getCodProv() {
		return codProv;
	}

	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}

	public String getCodDist() {
		return codDist;
	}

	public void setCodDist(String codDist) {
		this.codDist = codDist;
	}

	public String getDesDep() {
		return desDep;
	}

	public void setDesDep(String desDep) {
		this.desDep = desDep;
	}

	public String getDesProv() {
		return desProv;
	}

	public void setDesProv(String desProv) {
		this.desProv = desProv;
	}

	public String getDesDist() {
		return desDist;
	}

	public void setDesDist(String desDist) {
		this.desDist = desDist;
	}

	@Column(name = "cod_dep", nullable = true, length = 20)
	private String codDep;
	
	@Column(name = "cod_prov", nullable = true, length = 20)
	private String codProv;
	
	@Column(name = "cod_dist", nullable = true, length = 20)
	private String codDist;
	
	@Column(name = "des_dep", nullable = true, length = 100)
	private String desDep;
	
	@Column(name = "des_prov", nullable = true, length = 100)
	private String desProv;
	
	@Column(name = "des_dist", nullable = true, length = 100)
	private String desDist;

}
