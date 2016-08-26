package dao;


import domain.User;
import java.util.List;


public interface UserDao {
	
	   public List<User> selectAllUsers() throws DAOException;
	   public void close() throws DAOException;

}
