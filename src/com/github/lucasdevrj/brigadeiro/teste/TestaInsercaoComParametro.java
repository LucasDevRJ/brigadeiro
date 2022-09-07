package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		//Guardar dados digitados pelo usu�rio do sistema
		String nome = "Danoninho";
		String descricao = "Danoninho caseiro";
		Float preco = 7.00f;
		Double gramas = 300.00;
		Integer unidades = 43;
		
		//Criando conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
				
		//Para usar comandos SQL
		Statement comandos = conexao.createStatement(); 																								//retorna o ID gerado
		comandos.execute("INSERT INTO DOCE (NOME, DESCRICAO, PRECO, GRAMAS, UNIDADES) VALUES ('" + nome + "', '" + descricao + "', '" + preco + "', '" + gramas + "', '" + unidades + "')", Statement.RETURN_GENERATED_KEYS);
				
		//Pegando o conte�do do banco pegando ID do banco
		ResultSet conteudo = comandos.getGeneratedKeys();
				
		//La�o que verifica se tem um pr�ximo item no banco e executa fun��es
		while (conteudo.next()) {
			Integer id = conteudo.getInt(1);
			System.out.println("O ID criado � " + id);
		}
	}
}
