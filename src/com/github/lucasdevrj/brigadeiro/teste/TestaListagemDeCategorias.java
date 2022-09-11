package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;
import com.github.lucasdevrj.brigadeiro.dao.CategoriaDAO;
import com.github.lucasdevrj.brigadeiro.modelo.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection conexao = new CriaConexao().conecta()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(conexao);
			List<Categoria> listaCategorias = categoriaDAO.listar();
			listaCategorias.stream().forEach(lc -> System.out.println(lc));
		}
	} 
}
