package com.github.lucasdevrj.brigadeiro.modelo;

public class Doce {

	private Integer id;
	private String nome;
	private String descricao;
	private float preco;
	private double gramas;
	private int unidades;
	private Integer categoriaID;
	
	public Doce(String nome, String descricao, float preco, double gramas, int unidades) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.gramas = gramas;
		this.unidades = unidades;
	}
	
	public Doce(Integer id, String nome, String descricao, float preco, double gramas, int unidades) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.gramas = gramas;
		this.unidades = unidades;
	}

	public Doce(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getPreco() {
		return preco;
	}

	public double getGramas() {
		return gramas;
	}

	public int getUnidades() {
		return unidades;
	}
	
	public Integer getCategoriaID() {
		return categoriaID;
	}
	
	public void setCategoriaId(Integer id2) {
		this.categoriaID = id2;
	}
	
	@Override
	public String toString() {
		return "Doce_ID: " + this.getId() + "\nNome: " + this.getNome() + "\nDescri??o: " + this.getDescricao() + "\nPre?o: " + this.getPreco() + "\nGramas: " + this.getGramas() + "\nUnidades: " + this.getUnidades();
	}
}
