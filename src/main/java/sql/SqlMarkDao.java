package sql;


import dao.DAOException;
import dao.DaoFactory;
import dao.MarkDao;
import domain.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SqlMarkDao implements MarkDao {

    private Connection connection;
    private PreparedStatement prepareStatementInsert;
    private PreparedStatement prepareStatementDelete;
    private PreparedStatement prepareStatementSelect;
    private PreparedStatement prepareStatementUpdate;
    private PreparedStatement prepareStatementSelectAllMarks;


    private String selectMark = "SELECT id, student_id, mark FROM `Mark` WHERE id = ?;";
    private String updateMark = "UPDATE `Mark` SET student_id = ?, mark  = ? WHERE id = ?";
    private String deleteMark = "DELETE FROM `Mark` WHERE id = ?";
    private String insertMark = "INSERT INTO `Mark`(student_id, mark) VALUES (?, ?)";
    private String selectAllMarks = "SELECT M.id, M.student_id, M.mark, S.id, S.name, S.surname FROM `Student` S INNER JOIN `Mark` M ON M.student_id = S.id;";


    public SqlMarkDao() throws DAOException {

        try {

            DaoFactory daoFactory = new SqlDaoFactory();
            this.connection = daoFactory.getConnection();
            prepareStatementInsert = connection.prepareStatement(insertMark);
            prepareStatementDelete = connection.prepareStatement(deleteMark);
            prepareStatementSelect = connection.prepareStatement(selectMark);
            prepareStatementUpdate = connection.prepareStatement(updateMark);
            prepareStatementSelectAllMarks = connection.prepareStatement(selectAllMarks);


        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения SqlMarkDao", e);
        }
    }


    @Override
    public void insertMark(int studentId, int mark) throws DAOException {

        try {

          
            prepareStatementInsert.setInt(1, studentId);
            prepareStatementInsert.setInt(2, mark);
            prepareStatementInsert.execute();

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода insertMark", e);
        }
    }

    @Override
    public void deleteMark(int id) throws DAOException {

        try {

            prepareStatementDelete.setInt(1, id);
            prepareStatementDelete.executeUpdate();

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода deleteMark", e);
        }

    }


    @Override
    public Mark selectMark(int id) throws DAOException {

        Mark m = new Mark();
        try {

            prepareStatementSelect.setInt(1, id);
            ResultSet rs = prepareStatementSelect.executeQuery();
            rs.next();
            m.setId(rs.getInt("id"));
            m.setStudentId(rs.getInt("student_id"));
            m.setMark(rs.getInt("mark"));


        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода selectMark", e);
        }
        return m;
    }

    @Override
    public void updateMark(int id, int studentId, int mark) throws DAOException {

        try {


            prepareStatementUpdate.setInt(1, studentId);
            prepareStatementUpdate.setInt(2, mark);
            prepareStatementUpdate.setInt(3, id);
            prepareStatementUpdate.execute();

        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода updateMark", e);
        }


    }

    @Override
    public List<Mark> selectAllMarks() throws DAOException {

        List<Mark> list = new ArrayList<Mark>();
        try {

            ResultSet rs = prepareStatementSelectAllMarks.executeQuery();
            while (rs.next()) {
                Mark m = new Mark();
                m.setId(rs.getInt("id"));
                m.setStudentId(rs.getInt("student_id"));
                m.setName(rs.getString("name"));
				m.setSurname(rs.getString("surname"));
                m.setMark(rs.getInt("mark"));
                list.add(m);
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения метода selectAllMarks", e);
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
            if (prepareStatementSelectAllMarks != null) {
                prepareStatementSelectAllMarks.close();
            }
        } catch (Exception e) {

            throw new DAOException("Ошибка выполнения закрытия prepareStatementSelectAllMarks", e);
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
