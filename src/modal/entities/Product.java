package modal.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modal.conexao.Conexao;
import modal.interfaces.Conected;

public class Product implements Conected {
	private String nome;
	private Integer qtdProd;
	private Double valorProduto;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String nome, Integer qtdProd, Double valorProduto) {
		super();
		this.nome = nome;
		this.qtdProd = qtdProd;
		this.valorProduto = valorProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdProd() {
		return qtdProd;
	}

	public void setQtdProd(Integer qtdProd) {
		this.qtdProd = qtdProd;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	@Override
	public void inserir() {
		Connection conexao = new Conexao().conectaDB();
		String sql = "INSERT INTO produtos(nome, qtdProd, valorProduto) VALUES (?,?,?)";
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, this.getNome());
			stmt.setInt(2, this.getQtdProd());
			stmt.setDouble(3, this.getValorProduto());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
