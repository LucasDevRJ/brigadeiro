package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.SQLException;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		CriaConexao criaConexao = new CriaConexao();
		
		for (int i = 0; i < 10; i++) {
			criaConexao.conecta();
			System.out.println("Conexão de número: " + i);
		}
	}

}
