package com.github.lucasdevrj.brigadeiro.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

	//Criando conexão com o banco de dados
	public Connection conecta() throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/brigadeiro?useTimezone=true&serverTimezone=UTC", "root", "root");
		return conexao;
	}
}
