package com.cursomc.domain;

import java.util.Objects;

//5 - Implements Serializable
import java.io.Serializable;

public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//1 - Basic Attributes
	private Integer id;
	private String nome;
	
	//2 - Associations
	//Ignored: The Product Class not created yet;
	
	public Categoria() {}
	
	public Categoria (Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	// 3 - Getter and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// 4 - hashCode and equals
	//sources >> Generate hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
