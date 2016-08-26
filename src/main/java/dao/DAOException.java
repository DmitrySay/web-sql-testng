package dao;

import java.io.IOException;
import java.sql.SQLException;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5209106656390671243L;

	public DAOException(String s, ClassNotFoundException e) {

	}

	public DAOException(String s, SQLException e) {
	}

	public DAOException(String s, Exception e) {
	}

	public DAOException(String s, IOException e) {
	}

}
