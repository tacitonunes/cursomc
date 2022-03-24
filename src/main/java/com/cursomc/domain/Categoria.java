package com.cursomc.domain;

//5 - Implements Serializable
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//1 - Basic Attributes
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	
	/*Evitar Serialização Cíclica!!
	 * O carinha abaixo fica no lado em quê você quer que sejam listados os outros objetos da outra classe
	 */
	@JsonManagedReference	
	@ManyToMany(mappedBy="categorias")
	
	//2 - Associations
	//inicialmente ignorado: A classe Produto ainda não havia sido implementada;
	// No vídeo 19 do curso, apenas, que começamos a implementação da entidade Produto e suas conseqüentes associações;
	private List<Produto> produtos = new ArrayList<>();
		
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
