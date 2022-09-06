package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		//Recuperar conexão
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/doceria?useTimezone=true&serverTimezone=UTC", "root", "root");
	}

}
