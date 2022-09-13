package com.github.lucasdevrj.brigadeiro.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.github.lucasdevrj.brigadeiro.controller.CategoriaController;
import com.github.lucasdevrj.brigadeiro.controller.DoceController;
import com.github.lucasdevrj.brigadeiro.modelo.Categoria;
import com.github.lucasdevrj.brigadeiro.modelo.Doce;

public class BrigadeiroFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelNome, labelDescricao, labelCategoria;
	private JTextField textoNome, textoDescricao, preco, gramas, unidades, id;
	private JComboBox<Categoria> comboCategoria;
	private JButton botaoSalvar, botaoEditar, botaoLimpar, botarApagar;
	private JTable tabela;
	private DefaultTableModel modelo;
	private DoceController doceController;
	private CategoriaController categoriaController;

	public BrigadeiroFrame() {
		super("Doces");
		Container container = getContentPane();
		setLayout(null);

		this.categoriaController = new CategoriaController();
		this.doceController = new DoceController();

		labelNome = new JLabel("Nome do Doce");
		labelDescricao = new JLabel("Descrição do Doce");
		labelCategoria = new JLabel("Categoria do Doce");

		labelNome.setBounds(10, 10, 240, 15);
		labelDescricao.setBounds(10, 50, 240, 15);
		labelCategoria.setBounds(10, 90, 240, 15);

		labelNome.setForeground(Color.BLACK);
		labelDescricao.setForeground(Color.BLACK);
		labelCategoria.setForeground(Color.BLACK);

		container.add(labelNome);
		container.add(labelDescricao);
		container.add(labelCategoria);

		textoNome = new JTextField();
		textoDescricao = new JTextField();
		comboCategoria = new JComboBox<Categoria>();

		comboCategoria.addItem(new Categoria(0, "Selecione"));
		List<Categoria> categorias = this.listarCategoria();
		for (Categoria categoria : categorias) {
			comboCategoria.addItem(categoria);
		}

		textoNome.setBounds(10, 25, 265, 20);
		textoDescricao.setBounds(10, 65, 265, 20);
		comboCategoria.setBounds(10, 105, 265, 20);

		container.add(textoNome);
		container.add(textoDescricao);
		container.add(comboCategoria);

		botaoSalvar = new JButton("Salvar");
		botaoLimpar = new JButton("Limpar");

		botaoSalvar.setBounds(10, 145, 80, 20);
		botaoLimpar.setBounds(100, 145, 80, 20);

		container.add(botaoSalvar);
		container.add(botaoLimpar);

		tabela = new JTable();
		modelo = (DefaultTableModel) tabela.getModel();

		modelo.addColumn("Identificador do Doce");
		modelo.addColumn("Nome do Doce");
		modelo.addColumn("Descrição do Doce");

		preencherTabela();

		tabela.setBounds(10, 185, 760, 300);
		container.add(tabela);

		botarApagar = new JButton("Excluir");
		botaoEditar = new JButton("Alterar");

		botarApagar.setBounds(10, 500, 80, 20);
		botaoEditar.setBounds(100, 500, 80, 20);

		container.add(botarApagar);
		container.add(botaoEditar);

		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		botaoSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
				limparTabela();
				preencherTabela();
			}
		});

		botaoLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});

		botarApagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deletar();
				limparTabela();
				preencherTabela();
			}
		});

		botaoEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alterar();
				limparTabela();
				preencherTabela();
			}
		});
	}

	private void limparTabela() {
		modelo.getDataVector().clear();
	}

	private void alterar() {
		Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			String nome = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
			String descricao = (String) modelo.getValueAt(tabela.getSelectedRow(), 2);
			Float preco = (Float) modelo.getValueAt(tabela.getSelectedRow(), 3);
			Double gramas = (Double) modelo.getValueAt(tabela.getSelectedRow(), 4);
			int unidade = (int) modelo.getValueAt(tabela.getSelectedRow(), 5);
			
			this.doceController.alterar(nome, descricao, id);
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}

	private void deletar() {
		Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			this.doceController.deletar(id);
			modelo.removeRow(tabela.getSelectedRow());
			JOptionPane.showMessageDialog(this, "Doce excluído com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}

	private void preencherTabela() {
		List<Doce> doces = listarDoces();
		try {
			for (Doce doce : doces) {
				modelo.addRow(new Object[] { doce.getId(), doce.getNome(), doce.getDescricao(), doce.getPreco(), doce.getGramas(), doce.getUnidades()});
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private List<Categoria> listarCategoria() {
		return this.categoriaController.listar();
	}

	private void salvar() {
		if (!textoNome.getText().equals("") && !textoDescricao.getText().equals("")) {
			Doce doce = new Doce(textoNome.getText(), textoDescricao.getText(), Float.parseFloat(preco.getText()), Double.parseDouble(gramas.getText()), Integer.parseInt(unidades.getText()));
			Categoria categoria = (Categoria) comboCategoria.getSelectedItem();
			doce.setCategoriaId(categoria.getId());
			this.doceController.salvar(doce);
			JOptionPane.showMessageDialog(this, "Doce salvo com sucesso!");
			this.limpar();
		} else {
			JOptionPane.showMessageDialog(this, "Nome e Descri��o devem ser informados.");
		}
	}

	private List<Doce> listarDoces() {
		return this.doceController.listar();
	}

	private void limpar() {
		this.textoNome.setText("");
		this.textoDescricao.setText("");
		this.comboCategoria.setSelectedIndex(0);
	}
}