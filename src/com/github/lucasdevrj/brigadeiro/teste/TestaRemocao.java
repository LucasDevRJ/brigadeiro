package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		//Criando conexão com o banco
		CriaConexao criaConexao = new CriaConexao();
		try (Connection conexao = criaConexao.conecta()) {
			conexao.setAutoCommit(false); //controlar as transações do JDBC
			
			try {
				//Adição de comandos do SQL
				PreparedStatement comandos = conexao.prepareStatement("DELETE FROM DOCE WHERE Doce_ID > ?");
				
				excluiDados(6, comandos);
				
				//irá dar um commit caso não haja erro nenhum
				conexao.commit();
			} catch (Exception erro) {
				erro.printStackTrace();
				System.out.println("Roolback ativado!!");
				conexao.rollback();
			}
		}
	}

	public static void excluiDados(Integer id, PreparedStatement comandos) throws SQLException {
		//Settar atributo do banco
		comandos.setInt(1, id);
		
		comandos.execute();
		
		//Retorna o número de linhas após o statement ser executado
		Integer linhasExcluidas = comandos.getUpdateCount();
		
		System.out.println("Número de linhas excluídas: " + linhasExcluidas);
	}
}
