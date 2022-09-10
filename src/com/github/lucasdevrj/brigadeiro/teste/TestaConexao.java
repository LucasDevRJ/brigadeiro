package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		//Recuperar conexão
		try (Connection conexao = new CriaConexao().conecta()) {
		
			System.out.println("Conexão criada!!!");
		}
	}

}
