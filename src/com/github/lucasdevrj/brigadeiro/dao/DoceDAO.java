package com.github.lucasdevrj.brigadeiro.dao;

//Classe DAO serve para manusear métodos do banco de dados. É uma classe especifica para isso

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.modelo.Doce;

public class DoceDAO {
	
	private Connection conexao;

	public DoceDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void salvar(Doce doce) throws SQLException {
		String sql = "INSERT INTO DOCE (NOME, DESCRICAO, PRECO, GRAMAS, UNIDADES) VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement comandosSql = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			comandosSql.setString(1, doce.getNome());
			comandosSql.setString(2, doce.getDescricao());
			comandosSql.setFloat(3, doce.getPreco());
			comandosSql.setDouble(4, doce.getGramas());
			comandosSql.setInt(5, doce.getUnidades());
			
			comandosSql.execute();
			
			try (ResultSet conteudo = comandosSql.getGeneratedKeys()) {
				while (conteudo.next()) {
					doce.setId(conteudo.getInt(1));
				}
			}
		}
	}
}
