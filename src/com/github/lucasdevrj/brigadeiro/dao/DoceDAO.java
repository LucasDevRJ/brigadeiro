package com.github.lucasdevrj.brigadeiro.dao;

//Classe DAO serve para manusear métodos do banco de dados. É uma classe especifica para isso

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.modelo.Categoria;
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
	
	public void salvarCategoria(Doce doce) throws SQLException {
		String sql = "INSERT INTO DOCE (NOME, DESCRICAO, PRECO, GRAMAS, UNIDADES, CATEGORIA_ID) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement comandosSql = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			comandosSql.setString(1, doce.getNome());
			comandosSql.setString(2, doce.getDescricao());
			comandosSql.setFloat(3, doce.getPreco());
			comandosSql.setDouble(4, doce.getGramas());
			comandosSql.setInt(5, doce.getUnidades());
			comandosSql.setInt(6, doce.getId());
			
			comandosSql.execute();
			
			try (ResultSet conteudo = comandosSql.getGeneratedKeys()) {
				while (conteudo.next()) {
					doce.setId(conteudo.getInt(1));
				}
			}
		}
	}
	
	public List<Doce> listar() throws SQLException {
		List<Doce> doces = new ArrayList<Doce>();
		
		String sql = "SELECT * FROM DOCE";
		
		try (PreparedStatement comandos = conexao.prepareStatement(sql)) {
			comandos.execute();
			
			try (ResultSet conteudo = comandos.getResultSet()) {
				while (conteudo.next()) {
					Doce doce = new Doce(conteudo.getInt(1), conteudo.getString(2), conteudo.getString(3), conteudo.getFloat(4), conteudo.getDouble(5), conteudo.getInt(6));
					
					doces.add(doce);
				}
			}
		}
		return doces;
	}

	public List<Doce> buscar(Categoria lc) throws SQLException {
		List<Doce> doces = new ArrayList<Doce>();
		
		String sql = "SELECT * FROM DOCE WHERE CATEGORIA_ID = ?";
		
		try (PreparedStatement comandos = conexao.prepareStatement(sql)) {
			comandos.setInt(1, lc.getId());
			comandos.execute();
			
			try (ResultSet conteudo = comandos.getResultSet()) {
				while (conteudo.next()) {
					Doce doce = new Doce(conteudo.getInt(1), conteudo.getString(2), conteudo.getString(3), conteudo.getFloat(4), conteudo.getDouble(5), conteudo.getInt(6));
					
					doces.add(doce);
				}
			}
		}
		return doces;
	}
}
