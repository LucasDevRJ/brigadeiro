package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		//Criando conexão com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Utilizar comandos do banco de dados (statements)
		Statement comandosSql = conexao.createStatement();
		//Execução dos comandos SQL
		comandosSql.execute("SELECT * FROM DOCE");
		
		//Pegar resultado da lista de doces
		ResultSet conteudo = comandosSql.getResultSet();
		
		//Laço que verifica se tem próximo doce na lista
		while (conteudo.next()) {
			//Pegar atributos da tabela
			Integer id = conteudo.getInt("Doce_ID");
			String nome = conteudo.getString("Nome");
			String descricao = conteudo.getString("Descricao");
			Float preco = conteudo.getFloat("Preco");
			Double gramas = conteudo.getDouble("Gramas");
			
			DecimalFormat formatacao = new DecimalFormat("0.00");
			
			System.out.println("ID: " + id);
			System.out.println("Nome: " + nome);
			System.out.println("Descrição: " + descricao);
			System.out.println(NumberFormat.getCurrencyInstance().format(preco));
			System.out.println("Gramas: " + formatacao.format(gramas));
		}
		
		conexao.close();
	}
}
