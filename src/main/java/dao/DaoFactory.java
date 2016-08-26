package dao;


import java.sql.Connection;


public interface DaoFactory {
    /** Возвращает подключение к базе данных */
    public Connection getConnection() throws DAOException;

    public StudentDao getStudentDao(Connection connection) throws DAOException;

    /** Возвращает объект для управления персистентным состоянием объекта Group */
    public GroupDao getGroupDao(Connection connection) throws DAOException;

    public MarkDao getMarkDao(Connection connection) throws DAOException;
    
    public UserDao getUserDao(Connection connection) throws DAOException;
}
