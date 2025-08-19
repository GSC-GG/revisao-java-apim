package dao;

import java.sql.Connection;
import java.sql.SQLException;

import database.DBConnection;

public abstract class DAO {

	private DBConnection dbConnection;
	protected Connection conn;

	public DAO() throws SQLException {
		this.conn = new DBConnection().getConnection();
	}

	public Connection getConnection() throws SQLException {
		this.dbConnection = new DBConnection();
		return this.dbConnection.getConnection();
	}
	
	public abstract Object consultar(int id) throws SQLException;
	public abstract void remover(int id) throws SQLException;
}
