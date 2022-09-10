package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
	}

}
