package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		//Recuperar conexão com o banco
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/brigadeiro?useTimezone=true&serverTimezone=UTC", "root", "root");
		
		
		
		conexao.close();
	}
}
