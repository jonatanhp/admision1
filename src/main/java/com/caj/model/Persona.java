package com.caj.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entidad persona, hereda de usuario y contiene los datos personales")
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@Column(name = "id_user")
	private Integer id;
	
	@ApiModelProperty(notes = "campo nombre/nombres, campo obligatorio , para la busqueda convertir a UPPER")
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@ApiModelProperty(notes = "campo apellido paterno, campo obligatorio")
	@Column(name = "apel_pat", nullable = false, length = 100)
	private String apelPat;
	
	@ApiModelProperty(notes = "campo apellido materno, campo obligatorio")
	@Column(name = "apel_mat", nullable = false, length = 100)
	private String apelMat;
	
	@ApiModelProperty(notes = "campo dni, campo obligatorio, validacion en el frontend para 8 caracteres de tipo numérico")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@ApiModelProperty(notes = "campo sexo, campo obligatorio")
	@Column(name = "sexo", nullable = false, length = 2)
	private String sexo;
	
	@ApiModelProperty(notes = "campo direccion, campo obligatorio")
	@Column(name = "direccion", nullable = false, length = 200)
	private String direccion;
	
	@ApiModelProperty(notes = "campo correo, campo obligatorio, validación type email en el frontend")
	@Column(name = "correo", nullable = false , length = 100)
	private String correo;
	
	@ApiModelProperty(notes = "campo telefono, validación en el frontend para 9 caracteres y solo valores numéricos)")
	@Column(name ="telefono", nullable = true, length = 9)
	private String telefono;
	
	
	@ManyToOne
	@JoinColumn(name = "id_ubigeo", nullable = false)
	private Ubigeo ubigeo;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_registro;
	
	
	@ApiModelProperty(notes = "el usuario del que hereda esta entidad persona")
	@OneToOne
	@MapsId
	@JsonIgnore
	@JoinColumn(name = "id_user")
	private Usuario usuario;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApelPat() {
		return apelPat;
	}

	public void setApelPat(String apelPat) {
		this.apelPat = apelPat;
	}

	public String getApelMat() {
		return apelMat;
	}

	public void setApelMat(String apelMat) {
		this.apelMat = apelMat;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@JsonManagedReference
	public Paciente getEstudiante() {
		return paciente;
	}

	public void setEstudiante(Paciente paciente) {
		this.paciente = paciente;
	}

    public Medico getDocente() {
		return medico;
	}

	public void setDocente(Medico medico) {
		this.medico = medico;
	}

	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Paciente paciente;
	
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Medico medico;
	
	

}
