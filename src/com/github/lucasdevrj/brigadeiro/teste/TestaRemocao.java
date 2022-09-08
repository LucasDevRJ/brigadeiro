package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		//Criando conexão com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		conexao.setAutoCommit(false); //controlar as transações do JDBC
		
		try {
			//Adição de comandos do SQL
			PreparedStatement comandos = conexao.prepareStatement("DELETE FROM PRODUTO WHERE DOCE_ID > ?");
			
			excluiDados(comandos);
			
			//irá dar um commit caso não haja erro nenhum
			conexao.commit();
			
			comandos.close();
			conexao.close();
		} catch (Exception erro) {
			erro.printStackTrace();
			System.out.println("Roolback ativado!!");
			conexao.rollback();
		}
	}

	private static void excluiDados(PreparedStatement comandos) throws SQLException {
		//Settar atributo do banco
		comandos.setInt(1, 20);
		
		//Retorna o número de linhas após o statement ser executado
		Integer linhasExcluidas = comandos.getUpdateCount();
		
		System.out.println("Número de linhas excluídas: " + linhasExcluidas);
	}
}
