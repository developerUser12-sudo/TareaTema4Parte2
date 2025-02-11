package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diario")
public class Nota {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(name = "titulo")
	private String titulo;
    @Column(name = "contenido")
	private String contenido;
    @Column(name = "fecha")
	private String fecha;
	
	public Nota(int id, String titulo, String contenido, String fecha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	public Nota() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Nota(String titulo, String contenido, String fecha) {
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
