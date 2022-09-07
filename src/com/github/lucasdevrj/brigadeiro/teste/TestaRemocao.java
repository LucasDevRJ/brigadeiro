package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		//Criando conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Adi��o de comandos do SQL
		Statement comandos = conexao.createStatement();
		comandos.execute("DELETE FROM DOCE WHERE Doce_ID > 3"); //Execu��o do comando SQL
		
		//Retorna o n�mero de linhas ap�s o statement ser executado
		Integer linhasModificadas = comandos.getUpdateCount();
		
		System.out.println("N�mero de linhas exclu�das: " + linhasModificadas);
	}
}
