package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		//Criando conexão com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Adição de comandos do SQL
		Statement comandos = conexao.createStatement();
		comandos.execute("DELETE FROM DOCE WHERE Doce_ID > 3"); //Execução do comando SQL
		
		//Retorna o número de linhas após o statement ser executado
		Integer linhasModificadas = comandos.getUpdateCount();
		
		System.out.println("Número de linhas excluídas: " + linhasModificadas);
	}
}
