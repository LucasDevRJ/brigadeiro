package com.github.lucasdevrj.brigadeiro.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.conexao.CriaConexao;
import com.github.lucasdevrj.brigadeiro.dao.DoceDAO;
import com.github.lucasdevrj.brigadeiro.modelo.Doce;

public class DoceController {
	
	private DoceDAO doceDAO;
	
	public DoceController() {
		Connection conexao = new CriaConexao().conecta();
		this.doceDAO = new DoceDAO(conexao);
	}

	public void deletar(Integer id) {
		this.doceDAO.deletar(id);
		System.out.println("Deletando doce: " + id);
	}

	public void salvar(Doce doce) {
		try {
			this.doceDAO.salvar(doce);
			System.out.println("Salvando doce: " + doce.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Doce> listar() {
		try {
			System.out.println("Adicionando produto na lista");
			return this.doceDAO.listar();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(String nome, String descricao, Float preco, Double gramas, int unidades, Integer id) {
		this.doceDAO.alterar(nome, descricao, preco, gramas, unidades, id);
		System.out.println("Alterando doce: " + id);
	}
}