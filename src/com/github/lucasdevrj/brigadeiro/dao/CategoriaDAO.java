package com.github.lucasdevrj.brigadeiro.dao;

import java.sql.Connection;

public class CategoriaDAO {

	private Connection conexao;

	public CategoriaDAO(Connection conexao) {
		this.conexao = conexao;
	}
}
