package sql;



import java.util.ArrayList;
import java.util.List;

import dao.DAOException;
import dao.DaoFactory;
import dao.UserDao;
import domain.User;
import java.sql.*;


public class SqlUserDao implements UserDao {

	private Connection connection= null;
	private PreparedStatement prepareStatementSelectAllUsers;
	private String selectAllUsers = "SELECT id, username, password FROM `User`;";

	public SqlUserDao() throws DAOException {

		try {

			DaoFactory daoFactory = new SqlDaoFactory();
			this.connection = daoFactory.getConnection();
			prepareStatementSelectAllUsers = connection.prepareStatement(selectAllUsers);
		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения SqlUserDao", e);
		}
	}
	
	@Override
	public List<User> selectAllUsers() throws DAOException {

		List<User> list = new ArrayList<User>();
		try {

			ResultSet rs = prepareStatementSelectAllUsers.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));

				list.add(u);
			}

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода selectAllUsers", e);
		}
		return list;

	}
	
	@Override
	public void close() throws DAOException {
		try {
			if (prepareStatementSelectAllUsers != null) {
				prepareStatementSelectAllUsers.close();
			}
		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения закрытия prepareStatementSelectAllUsers", e);
		}

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения закрытия connection", e);
		}

	}

	
}
