package com.github.lucasdevrj.brigadeiro.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CriaConexao {
	
	//Implementar a interface data source, para criarmos a conexão com o banco
	public CriaConexao() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost/brigadeiro?useTimezone=true&serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword("root");
	}

	//Criando conexão com o banco de dados
	public Connection conecta() throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/brigadeiro?useTimezone=true&serverTimezone=UTC", "root", "root");
		return conexao;
	}
}
