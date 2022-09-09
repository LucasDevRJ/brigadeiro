package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaAtualizacao {

	public static void main(String[] args) throws SQLException {
		//Criação de conexão com o banco
		CriaConexao criaConexao = new CriaConexao();
		try (Connection conexao = criaConexao.conecta()) {
			conexao.setAutoCommit(false); //assumir o controle das transações
			
			try {
				//Criação dos comandos SQL
				PreparedStatement comandos = conexao.prepareStatement("UPDATE DOCE SET DOCE_ID = ? WHERE DOCE_ID = ?");
				
				atualizaVariavel(6, 7, comandos);
				
				conexao.commit();
				
				comandos.close();
				conexao.close();
			} catch (Exception erro) {
				erro.printStackTrace();
				System.out.println("Roolback executado!!");
				conexao.rollback();
			}
		}
	}

	private static void atualizaVariavel(Integer idAtualizado, Integer id, PreparedStatement comandos) throws SQLException {
		comandos.setInt(1, idAtualizado);
		comandos.setInt(2, id);
		
		if (id < 0 || id.equals(idAtualizado)) {
			throw new RuntimeException("ID inválida!!!");
		}
		
		comandos.execute();
		
		Integer linhasAtualizadas = comandos.getUpdateCount();
		System.out.println("Número de linhas atualizadas: " + linhasAtualizadas);
		
	}
}
