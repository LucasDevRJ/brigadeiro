package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		//Criando conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Para usar comandos SQL
		Statement comandos = conexao.createStatement(); 																								//retorna o ID gerado
		comandos.execute("INSERT INTO DOCE (NOME, DESCRICAO, PRECO, GRAMAS, UNIDADES) VALUES ('Pudim', 'Pudim de leite condensado', 6.00, 0.280, 34)", Statement.RETURN_GENERATED_KEYS);
		
		//Pegando o conte�do do banco pegando ID do banco
		ResultSet conteudo = comandos.getGeneratedKeys();
		
		//La�o que verifica se tem um pr�ximo item no banco e executa fun��es
		while (conteudo.next()) {
			Integer id = conteudo.getInt(1);
			System.out.println("O ID criado � " + id);
		}
	}

}
