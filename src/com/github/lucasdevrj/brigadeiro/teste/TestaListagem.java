package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.List;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		//Recuperar conex�o com o banco
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/brigadeiro?useTimezone=true&serverTimezone=UTC", "root", "root");
		
		//Utilizar comandos do banco de dados (statements)
		Statement comandosSql = conexao.createStatement();
		//Execu��o dos comandos SQL
		comandosSql.execute("SELECT * FROM DOCE");
		
		//Pegar resultado da lista de doces
		ResultSet conteudo = comandosSql.getResultSet();
		
		//La�o que verifica se tem pr�ximo doce na lista
		while (conteudo.next()) {
			//Pegar atributos da tabela
			Integer id = conteudo.getInt("Doce_ID");
			String nome = conteudo.getString("Nome");
			String descricao = conteudo.getString("Descricao");
			Float preco = conteudo.getFloat("Preco");
			
			System.out.println("ID: " + id);
			System.out.println("Nome: " + nome);
			System.out.println("Descri��o: " + descricao);
			System.out.println(NumberFormat.getCurrencyInstance().format(preco));
		}
		
		conexao.close();
	}
}
