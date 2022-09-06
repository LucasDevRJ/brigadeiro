package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		//Recuperar conex�o
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		System.out.println("Recuperando conex�o!");
		conexao.close();
		System.out.println("Conex�o fechada!");
	}

}
