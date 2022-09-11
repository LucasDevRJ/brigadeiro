package com.github.lucasdevrj.brigadeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.modelo.Categoria;

public class CategoriaDAO {

	private Connection conexao;

	public CategoriaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT * FROM CATEGORIA";
		
		try (PreparedStatement comandosSQL = conexao.prepareStatement(sql)) {
			comandosSQL.execute();
			
			try (ResultSet conteudo = comandosSQL.getResultSet()) {
				while (conteudo.next()) {
					Categoria categoria = new Categoria(conteudo.getInt(1), conteudo.getString(2));
				}
			}
		}
	}
}
