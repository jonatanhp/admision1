package com.caj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "menu_children")
public class MenuChildren {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMenuChilren;
	
	@Column(name = "icon", nullable = true, length = 100 ) 
	private String icon;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name; 
	
	@Column(name = "url", nullable = false, length = 100)
	private String url;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_menu", nullable = false)
	private Menu menu;

	public Integer getIdMenuChilren() {
		return idMenuChilren;
	}

	public void setIdMenuChilren(Integer idMenuChilren) {
		this.idMenuChilren = idMenuChilren;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

}
