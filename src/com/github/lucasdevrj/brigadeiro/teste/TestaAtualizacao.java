package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaAtualizacao {

	public static void main(String[] args) throws SQLException {
		//Cria��o de conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Cria��o dos comandos SQL
		Statement comandos = conexao.createStatement();
		comandos.execute("UPDATE DOCE SET GRAMAS = 30.00 WHERE DOCE_ID = 1");
		comandos.execute("UPDATE DOCE SET GRAMAS = 27.00 WHERE DOCE_ID = 2");
		comandos.execute("UPDATE DOCE SET GRAMAS = 280.00 WHERE DOCE_ID = 3");
		
		Integer linhasAtualizadas = comandos.getUpdateCount();
		System.out.println("N�mero de linhas atualizadas: " + linhasAtualizadas);
		
	}

}
