package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		//Guardar dados digitados pelo usu�rio do sistema
		String nome = "Danoninho'";
		String descricao = "Danoninho caseiro); DELETE FROM DOCE;";
		Float preco = 7.00f;
		Double gramas = 300.00;
		Integer unidades = 43;
		
		//Criando conex�o com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Para usar comandos SQL
		//prepareStatement para gerenciar os atributos do banco proibindo comandos SQL dentro deles, assim forncendo mais seguran�a
		PreparedStatement comandos = conexao.prepareStatement("INSERT INTO DOCE (NOME, DESCRICAO, PRECO, GRAMAS, UNIDADES) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); //retorna o ID gerado																							
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
