package com.github.lucasdevrj.brigadeiro.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;
import com.github.lucasdevrj.brigadeiro.dao.CategoriaDAO;
import com.github.lucasdevrj.brigadeiro.modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() throws SQLException {
		Connection conexao = new CriaConexao().conecta();
		this.categoriaDAO = new CategoriaDAO(conexao);
	}

	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria(1, ""));
		return categorias;
	}
}
