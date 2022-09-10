package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;
import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;
import com.github.lucasdevrj.brigadeiro.dao.DoceDAO;
import com.github.lucasdevrj.brigadeiro.modelo.Doce;

public class TestaInsercaoComDoce {

	public static void main(String[] args) throws SQLException {
		Doce doce = new Doce("Mousse", "Mousse de chocolate", 8.00f, 320.00, 27);
		
		try (Connection conexao = new CriaConexao().conecta()) {
			DoceDAO doceDao = new DoceDAO(conexao);
			doceDao.salvar(doce);
			System.out.println(doce);
		}
	}
}
