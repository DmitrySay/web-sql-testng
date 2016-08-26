package sql;

import dao.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlDaoFactory implements DaoFactory {

	public Connection getConnection() throws DAOException {
		Connection connection;

		try {

			Properties property = new Properties();
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("database.properties");
			try {

				property.load(inputStream);
			} catch (IOException e) {
				throw new DAOException("ОШИБКА: Файл свойств database.properties отсуствует!", e);
			}

			String url = property.getProperty("database.url");
			String user = property.getProperty("database.user");
			String password = property.getProperty("database.password");

			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {

			throw new DAOException("Не удалось создать соединение с БД", e);
		}
		return connection;
	}

	public SqlDaoFactory() throws DAOException {

		try {

			Properties property = new Properties();

			try {
				InputStream inputStream = getClass().getClassLoader().getResourceAsStream("database.properties");
				property.load(inputStream);
			} catch (IOException e) {

				throw new DAOException("ОШИБКА: Файл свойств database.properties отсуствует!", e);

			}

			String driver = property.getProperty("database.driver");
			Class.forName(driver);

		} catch (ClassNotFoundException e) {

			throw new DAOException("Не удалось зарегистрирать драйвер", e);
		}
	}

	@Override
	public StudentDao getStudentDao(Connection connection) throws DAOException {
		return new SqlStudentDao();
	}

	@Override
	public GroupDao getGroupDao(Connection connection) throws DAOException {
		return new SqlGroupDao();
	}

	@Override
	public MarkDao getMarkDao(Connection connection) throws DAOException {
		return new SqlMarkDao();
	}

	@Override
	public UserDao getUserDao(Connection connection) throws DAOException {
		return new SqlUserDao();
	}

}
