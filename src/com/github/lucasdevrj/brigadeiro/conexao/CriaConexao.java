package com.github.lucasdevrj.brigadeiro.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CriaConexao {
	
	public DataSource dataSource;
	
	//Implementar a interface data source, para criarmos a conex?o com o banco
	public CriaConexao() {
		ComboPooledDataSource dataSourceComboPooled = new ComboPooledDataSource();
		dataSourceComboPooled.setJdbcUrl("jdbc:mysql://localhost/brigadeiro?useTimezone=true&serverTimezone=UTC");
		dataSourceComboPooled.setUser("root");
		dataSourceComboPooled.setPassword("root");
		
		//Administrar conex?es
		dataSourceComboPooled.setMaxPoolSize(15);
		
		this.dataSource = dataSourceComboPooled;
	}

	//Criando conex?o com o banco de dados
	public Connection conecta(){
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
