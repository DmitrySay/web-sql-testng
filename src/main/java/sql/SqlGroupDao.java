package sql;


import dao.DAOException;
import dao.DaoFactory;
import dao.GroupDao;
import domain.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SqlGroupDao implements GroupDao {

    private Connection connection;
    private PreparedStatement prepareStatementInsert;
    private PreparedStatement prepareStatementDelete;
    private PreparedStatement prepareStatementSelect;
    private PreparedStatement prepareStatementUpdate;
    private PreparedStatement prepareStatementSelectAllGroups;

    private String insertGroup = "INSERT INTO `group` (number, department) VALUES (?, ?)";
    private String selectGroup = "SELECT id, number, department FROM `group` WHERE id = ?;";
    private String updateGroup = "UPDATE `group` SET number = ?, department  = ? WHERE id = ?";
    private String deleteGroup = "DELETE FROM `group` WHERE id = ?";
    private String selectAllGroups = "SELECT id, number, department FROM `group`";

    public SqlGroupDao() throws DAOException {
        try {
            DaoFactory daoFactory = new SqlDaoFactory();
            this.connection = daoFactory.getConnection();
            prepareStatementInsert = connection.prepareStatement(insertGroup);
            prepareStatementDelete = connection.prepareStatement(deleteGroup);
            prepareStatementSelect = connection.prepareStatement(selectGroup);
            prepareStatementUpdate = connection.prepareStatement(updateGroup);
            prepareStatementSelectAllGroups = connection.prepareStatement(selectAllGroups);

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения SqlGroupDao", e);
        }
    }


    @Override
    public void insertGroup(int number, String department) throws DAOException {

        try {

           
            prepareStatementInsert.setInt(1, number);
            prepareStatementInsert.setString(2, department);
            prepareStatementInsert.execute();

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода insertGroup", e);
        }
    }


    @Override
    public Group selectGroup(int id) throws DAOException {
        Group g = new Group();
        try {

            prepareStatementSelect.setInt(1, id);
            ResultSet rs = prepareStatementSelect.executeQuery();
            rs.next();
            g.setId(rs.getInt("id"));
            g.setNumber(rs.getInt("number"));
            g.setDepartment(rs.getString("department"));

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода selectGroup", e);
        }
        return g;
    }


    @Override
    public void updateGroup(int id, int number, String department) throws DAOException {

        try {

            prepareStatementUpdate.setInt(1, number);
            prepareStatementUpdate.setString(2, department);
            prepareStatementUpdate.setInt(3, id);
            prepareStatementUpdate.execute();

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода updateGroup", e);
        }
    }


    @Override
    public void deleteGroup(int id) throws DAOException {
        try {

            prepareStatementDelete.setInt(1, id);
            prepareStatementDelete.executeUpdate();

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода deleteGroup", e);
        }
    }


    @Override
    public List<Group> selectAllGroups() throws DAOException {
        List<Group> list = new ArrayList<Group>();
        try {
            ResultSet rs = prepareStatementSelectAllGroups.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setId(rs.getInt("id"));
                g.setNumber(rs.getInt("number"));
                g.setDepartment(rs.getString("department"));
                list.add(g);
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода selectAllGroups", e);
        }
        return list;
    }


    @Override
    public void close() throws DAOException {
        try {
            if (prepareStatementInsert != null) {
                prepareStatementInsert.close();
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения закрытия prepareStatementInsert", e);
        }
        try {
            if (prepareStatementDelete != null) {
                prepareStatementDelete.close();
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения закрытия prepareStatementDelete", e);
        }
        try {
            if (prepareStatementSelect != null) {
                prepareStatementSelect.close();
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения закрытия prepareStatementSelect", e);
        }
        try {
            if (prepareStatementUpdate != null) {
                prepareStatementUpdate.close();
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения закрытия prepareStatementUpdate", e);
        }
        try {
            if (prepareStatementSelectAllGroups != null) {
                prepareStatementSelectAllGroups.close();
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения закрытия prepareStatementSelectAllGroups", e);
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