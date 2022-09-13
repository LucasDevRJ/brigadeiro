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
		try {
			List<Doce> doces = new ArrayList<Doce>();
			String sql = "SELECT * FROM DOCE";

			try (PreparedStatement comandos = conexao.prepareStatement(sql)) {
				comandos.execute();

				trasformarResultSetProduto(doces, comandos);
			}
			return doces;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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
	
	public void deletar(Integer id) {
		try {
			try (PreparedStatement comandos = conexao.prepareStatement("DELETE FROM DOCE WHERE ID = ?")) {
				comandos.setInt(1, id);
				comandos.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(String nome, String descricao, Float preco, Double gramas, int unidades, Integer id) {
		try {
			try (PreparedStatement comandos = conexao.prepareStatement("UPDATE DOCE D SET D.NOME = ?, D.DESCRICAO = ?, D.PRECO = ?, D.GRAMAS = ?, D.UNIDADES = ? WHERE ID = ?")) {
				comandos.setString(1, nome);
				comandos.setString(2, descricao);
				comandos.setFloat(3, preco);
				comandos.setDouble(4, gramas);
				comandos.setInt(5, unidades);
				comandos.setInt(6, id);
				
				comandos.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void trasformarResultSetProduto(List<Doce> doces, PreparedStatement comandos) throws SQLException {
		try (ResultSet conteudo = comandos.getResultSet()) {
			while (conteudo.next()) {
				Doce doce = new Doce(conteudo.getInt(1), conteudo.getString(2), conteudo.getString(3), conteudo.getFloat(4), conteudo.getDouble(5), conteudo.getInt(6));

				doces.add(doce);
			}
		}
	}
}
