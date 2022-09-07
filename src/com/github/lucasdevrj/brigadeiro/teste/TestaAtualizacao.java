package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaAtualizacao {

	public static void main(String[] args) throws SQLException {
		//Guardar valor inserido
		Integer idAtualizado = 4; 
		Integer id = 12;
		
		//Cria��o de conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Cria��o dos comandos SQL
		PreparedStatement comandos = conexao.prepareStatement("UPDATE DOCE SET DOCE_ID = ? WHERE DOCE_ID = ?");
		comandos.setInt(1, idAtualizado);
		comandos.setInt(2, id);
		
		comandos.execute();
		
		Integer linhasAtualizadas = comandos.getUpdateCount();
		System.out.println("N�mero de linhas atualizadas: " + linhasAtualizadas);
		
	}

}
