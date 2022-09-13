package com.github.lucasdevrj.brigadeiro.controller;

import java.util.ArrayList;
import java.util.List;

import com.github.lucasdevrj.brigadeiro.modelo.Categoria;

public class CategoriaController {

	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria(1, ""));
		return categorias;
	}
}
