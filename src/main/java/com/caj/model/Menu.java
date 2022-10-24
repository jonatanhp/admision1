package com.caj.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Entidad menú, esta es la manera en la que se va a controlar los accesos a los menus por rol de cada usuario")
@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMenu;

	@ApiModelProperty(notes = "icono del menu")
	@Column(name = "icono", length = 20)
	private String icono;

	@ApiModelProperty(notes = "nombre del menu")
	@Column(name = "nombre", length = 20)
	private String nombre;

	@ApiModelProperty(notes = "url del menu, importante implementar en el frontend el routing y de esa manera mostrar las diferentes vistas por rol de usuario")
	@Column(name = "url", length = 50)
	private String url;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;
	
	
	
	@OneToMany(mappedBy = "menu", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<MenuChildren> children;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icon) {
		this.icono = icon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<MenuChildren> getChildren() {
		return children;
	}

	public void setChildren(List<MenuChildren> children) {
		this.children = children;
	}
	
	

}
