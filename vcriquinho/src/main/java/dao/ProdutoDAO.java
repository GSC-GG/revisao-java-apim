package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.AttributeNotFoundException;

import model.ContaInvAut;
import model.Produto;
import model.RendaFixa;
import model.RendaVariavel;

public class ProdutoDAO extends DAO {

	public ProdutoDAO() throws SQLException {
		super();
	}
	
	public void incluir(ContaInvAut conta) throws SQLException {
		Produto produto = conta.getProduto();
	    conn.setAutoCommit(false);
		String sql = "INSERT INTO produtos (id_conta, nome, descricao, rendimento) "
				+ "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, conta.getId());
        stmt.setString(2, produto.getNome());
        stmt.setString(3, produto.getDescricao());
        stmt.setInt(4, produto.getRendimento());
        stmt.execute();
        
        ResultSet rs = stmt.getGeneratedKeys();
        int id = 0;
        if (rs.next()) {
            id= rs.getInt(1);
        }

        String classe = produto.getClass().getName().replace("model.", "");
        
        if (classe.equals("RendaFixa")) {
        	sql = "INSERT INTO produtos_renda_fixa (id_produto, em_carencia, dias_carencia) "
        			+ "VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setBoolean(2, produto.isEmCarencia());
            stmt.setInt(3, ((RendaFixa) produto).getDiasCarencia());
            stmt.execute();
        	
        } else {
	        sql = "INSERT INTO produtos_renda_variavel (id_produto) "
					+ "VALUES (?)";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        stmt.execute();
        }
        conn.commit();
        stmt.close();
	}
	
	public Produto consultar(int id) throws SQLException {
		String sql = "SELECT produtos.*, produtos_renda_fixa.*, produtos_renda_variavel.* "
				+ "LEFT JOIN produtos_renda_fixa ON produtos_renda_fixa.id_produto = ? "
				+ "LEFT JOIN produtos_renda_variavel ON produtos_renda_variavel.id_produto = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setInt(2, id);
        stmt.setInt(3, id);
        ResultSet rs = stmt.executeQuery();
        
        Produto produto = null;        
        if (rs.next()) {
        	produto = map(rs);
        }
        rs.close();
        stmt.close();
        return produto;
	}
	
	private Produto map(ResultSet rs) throws SQLException {
		if (rs.getInt("dias_carencia") != 0) {
			return new RendaFixa(
					rs.getInt("produtos.id"), 
					rs.getString("produtos.nome"), 
					rs.getString("produtos.descricao"), 
					rs.getInt("produtos.rendimento"), 
					rs.getInt("dias_carencia"), 
					rs.getBoolean("em_carencia")
					);	
		} else {
			return new RendaVariavel(
					rs.getInt("produtos.id"), 
					rs.getString("produtos.nome"), 
					rs.getString("produtos.descricao"), 
					rs.getInt("produtos.rendimento") 
					);	
		}
	}
	
	public void atualizar(Produto produto) throws SQLException, AttributeNotFoundException {
		String sql = null;
		PreparedStatement stmt = null;
		boolean existente = false;
		
		if (produto.getNome() != null) {
			sql = "UPDATE produtos SET nome = ? WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		
		if (produto.getDescricao() != null) {
			sql = "UPDATE produtos SET descricao = ? WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, produto.getDescricao());
			stmt.setInt(2, produto.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		
		if (produto.getRendimento() != 0) {
			sql = "UPDATE produtos SET rendimento = ? WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, produto.getRendimento());
			stmt.setInt(2, produto.getRendimento());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		
		if (produto.getClass().getName().equals("model.RendaFixa") && ((RendaFixa) produto).getDiasCarencia() != 0) {
			sql = "UPDATE produtos_renda_fixa SET dias_carencia = ? WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ((RendaFixa) produto).getDiasCarencia());
			stmt.setInt(2, produto.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		
		if (produto.getClass().getName().equals("model.RendaFixa")) {
			sql = "UPDATE produtos_renda_fixa SET dias_carencia = ? WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, ((RendaFixa) produto).isEmCarencia());
			stmt.setInt(2, produto.getId());
	        if (stmt.executeUpdate() == 1) existente = true;
		}
		if (!existente) {
			throw new AttributeNotFoundException();
		}
        stmt.close();
	}
	
	public void remover(int id) throws SQLException {
		String sql = "DELETE FROM produtos WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
	}
}
