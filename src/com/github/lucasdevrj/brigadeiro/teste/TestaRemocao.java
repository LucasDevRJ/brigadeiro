package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		//Criando conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Adi��o de comandos do SQL
		PreparedStatement comandos = conexao.prepareStatement("DELETE FROM PRODUTO WHERE DOCE_ID > ?");
		
		//Settar atributo do banco
		comandos.setInt(1, 3);
		
		//Executar comandos SQL
		comandos.execute("DELETE FROM DOCE WHERE Doce_ID > 3"); //Execu��o do comando SQL
		
		//Retorna o n�mero de linhas ap�s o statement ser executado
		Integer linhasModificadas = comandos.getUpdateCount();
		
		System.out.println("N�mero de linhas exclu�das: " + linhasModificadas);
	}
}
