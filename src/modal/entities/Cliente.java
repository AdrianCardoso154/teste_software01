package modal.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modal.conexao.Conexao;
import modal.interfaces.Conected;

public class Cliente implements Conected {
	private String nomeCliente;
	private String emailCliente;

	public Cliente(String nomeCliente, String emailCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Override
	public void inserir() {
		Connection conexao = new Conexao().conectaDB();
		String sql = "INSERT INTO cliente(nomeCliente, emailCliente) VALUES (?,?)";
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, this.getNomeCliente());
			stmt.setString(2, this.getEmailCliente());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
