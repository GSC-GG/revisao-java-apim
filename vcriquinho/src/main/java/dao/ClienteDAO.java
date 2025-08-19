package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Function;

import javax.management.AttributeNotFoundException;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

public class ClienteDAO extends DAO {
	
	public ClienteDAO() throws SQLException {
		super();
	}
	
	public void incluir(Cliente cliente) throws SQLException {
	    conn.setAutoCommit(false);
		String sql = "INSERT INTO clientes (nome, email) "
				+ "VALUES (?, ?) ";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.execute();
        
        ResultSet rs = stmt.getGeneratedKeys();
        int id = 0;
        if (rs.next()) {
            id= rs.getInt(1);
        }
        
        String classe = cliente.getClass().getName().replace("model.", "");
        String atributo = classe.equals("PessoaFisica") ? "cpf" : "cnpj";
        
        sql = "INSERT INTO " + (classe.equals("PessoaFisica") ? "pessoas_fisicas" : "pessoas_juridicas")
        		+ " (id_cliente, " + atributo + ") "
				+ "VALUES (?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        
        if (classe.equals("PessoaFisica")) {
        	stmt.setString(2, ((PessoaFisica) cliente).getCpf());
        } else {
        	stmt.setString(2, ((PessoaJuridica) cliente).getCnpj());
        }
        stmt.execute();
        conn.commit();
        stmt.close();
	}
	
	public Cliente consultar(int id) throws SQLException {
		String sql = "SELECT clientes.*, pessoas_fisicas.*, pessoas_juridicas.*, contas.* FROM clientes "
				+ "INNER JOIN pessoas_fisicas ON pessoas_fisicas.id_cliente = ? "
				+ "LEFT JOIN pessoas_juridicas ON pessoas_juridicas.id_cliente = ? "
				+ "LEFT JOIN contas ON contas.id_cliente = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setInt(2, id);
        stmt.setInt(3, id);
        ResultSet rs = stmt.executeQuery();
        
        Cliente cliente = null;
        if (rs.next()) {
        	cliente = map(rs);
        }
        rs.close();
        stmt.close();
        return cliente;
	}
	
	private Cliente map(ResultSet rs) throws SQLException {
		if (rs.getString("cpf") != null) {
			return new PessoaFisica(
					rs.getInt("clientes.id"),
					rs.getString("nome"),
					rs.getString("email"),
					rs.getString("cpf")
					);
			
		} else if (rs.getString("cnpj") != null) {
			return new PessoaJuridica(
					rs.getInt("clientes.id"),
					rs.getString("nome"),
					rs.getString("email"),
					rs.getString("cnpj")
					);
		}
		return null;
	}

	public void atualizar(Cliente cliente) throws SQLException, AttributeNotFoundException {
		String sql = null;
		PreparedStatement stmt = null;
		boolean existente = false;
		
		if (cliente.getNome() != null) {
			sql = "UPDATE clientes SET nome = ? WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
	        stmt.setInt(2, cliente.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		
		if (cliente.getEmail() != null) {
			sql = "UPDATE clientes SET email = ? WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getEmail());
			stmt.setInt(2, cliente.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		
		if (cliente.getClass().getName().equals("model.PessoaFisica") && ((PessoaFisica) cliente).getCpf() != null) {
			sql = "UPDATE pessoas_fisicas SET cpf = ? WHERE id_cliente = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ((PessoaFisica) cliente).getCpf());
			stmt.setInt(2, cliente.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		
		if (cliente.getClass().getName().equals("model.PessoaJuridica") && ((PessoaJuridica) cliente).getCnpj() != null) {
			sql = "UPDATE pessoas_juridicas SET cnpj = ? WHERE id_cliente= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ((PessoaJuridica) cliente).getCnpj());
			stmt.setInt(2, cliente.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		if (!existente) {
			throw new AttributeNotFoundException();
		}
        stmt.close();
	}
	
	public void remover(int id) throws SQLException {
		String sql = "DELETE FROM clientes WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
	}
}
