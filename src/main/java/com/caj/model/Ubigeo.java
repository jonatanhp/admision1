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
