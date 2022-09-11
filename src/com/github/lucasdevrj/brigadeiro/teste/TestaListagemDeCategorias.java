package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;
import com.github.lucasdevrj.brigadeiro.dao.CategoriaDAO;

public class TestaListagemDeCategorias {

	public static void main(String[] args) {
		try (Connection conexao = new CriaConexao().conecta()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaCategorias = categoriaDAO.listar();
		}
	} 
}
