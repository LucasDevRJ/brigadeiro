package com.github.lucasdevrj.brigadeiro.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;
import com.github.lucasdevrj.brigadeiro.dao.CategoriaDAO;
import com.github.lucasdevrj.brigadeiro.dao.DoceDAO;
import com.github.lucasdevrj.brigadeiro.modelo.Categoria;
import com.github.lucasdevrj.brigadeiro.modelo.Doce;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection conexao = new CriaConexao().conecta()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(conexao);
			List<Categoria> listaCategorias = categoriaDAO.listarDoces();
			listaCategorias.stream().forEach(lc -> {
				System.out.println(lc.getNome());
//				try {
//					for (Doce doce : new DoceDAO(conexao).buscar(lc)) {
//						System.out.println("Nome: " + doce.getNome());
//						System.out.println("Descrição: " + doce.getDescricao());
//						System.out.println("Categoria: " + lc.getNome());
//						System.out.println();
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			});
		}
	} 
}
