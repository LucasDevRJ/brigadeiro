package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		//Criando conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Para usar comandos SQL
		//prepareStatement para gerenciar os atributos do banco proibindo comandos SQL dentro deles, assim forncendo mais seguran�a
		PreparedStatement comandos = conexao.prepareStatement("INSERT INTO DOCE (NOME, DESCRICAO, PRECO, GRAMAS, UNIDADES) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); //retorna o ID gerado																							
		
		//Chamando m�todo e com par�metros criados
		adicionaVariavel("Danoninho", "Danoninho caseiro", 7.00f, 300.00, 43, comandos);
		adicionaVariavel("P� de moleque", "P� de moleque com leite condensado", 5.00f, 84.00, 67, comandos);
	}

	private static void adicionaVariavel(String nome, String descricao, Float preco, Double gramas, Integer unidades,
			PreparedStatement comandos) throws SQLException {
		//Settar atributos do banco
		comandos.setString(1, nome);
		comandos.setString(2, descricao);
		comandos.setFloat(3, preco);
		comandos.setDouble(4, gramas);
		comandos.setInt(5, unidades);
		
		comandos.execute(); //para executar os comandos SQL
				
		//Pegando o conte�do do banco pegando ID do banco
		ResultSet conteudo = comandos.getGeneratedKeys();
				
		//La�o que verifica se tem um pr�ximo item no banco e executa fun��es
		while (conteudo.next()) {
			Integer id = conteudo.getInt(1);
			System.out.println("O ID criado � " + id);
		}
	}
}
