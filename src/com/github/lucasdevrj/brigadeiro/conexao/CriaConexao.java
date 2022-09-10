package com.github.lucasdevrj.brigadeiro.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CriaConexao {
	
	public DataSource dataSource;
	
	//Implementar a interface data source, para criarmos a conexão com o banco
	public CriaConexao() {
		ComboPooledDataSource dataSourceComboPooled = new ComboPooledDataSource();
		dataSourceComboPooled.setJdbcUrl("jdbc:mysql://localhost/brigadeiro?useTimezone=true&serverTimezone=UTC");
		dataSourceComboPooled.setUser("root");
		dataSourceComboPooled.setPassword("root");
		
		this.dataSource = dataSourceComboPooled;
	}

	//Criando conexão com o banco de dados
	public Connection conecta() throws SQLException {
		return this.dataSource.getConnection();
	}
}
