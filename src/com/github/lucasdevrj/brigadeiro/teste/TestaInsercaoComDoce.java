package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;
import com.github.lucasdevrj.brigadeiro.modelo.Doce;

public class TestaInsercaoComDoce {

	public static void main(String[] args) throws SQLException {
		Doce doce = new Doce("Mousse", "Mousse de chocolate", 8.00f, 320.00, 27);
		
		try (Connection conexao = new CriaConexao().conecta()) {
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
			System.out.println(doce);
		}
	}
}
