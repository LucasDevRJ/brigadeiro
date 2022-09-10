package com.github.lucasdevrj.brigadeiro.modelo;

public class Doce {

	private Integer id;
	private String nome;
	private String descricao;
	private float preco;
	private double gramas;
	private int unidades;
	
	public Doce(String nome, String descricao, float preco, double gramas, int unidades) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.gramas = gramas;
		this.unidades = unidades;
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
}
