package dao;

import domain.Mark;
import java.util.List;


public interface MarkDao {

    /**
     * Создает новую запись и соответствующий ей объект
     */
    public void insertMark(int studentId, int mark) throws DAOException;

    /**
     * Возвращает список объектов соответствующих всем записям в базе данных
     */
    public List<Mark> selectAllMarks() throws DAOException;

    public void updateMark(int id, int studentId, int mark) throws DAOException;


    public void deleteMark(int id) throws DAOException;

    public Mark selectMark(int id) throws DAOException;

    public void close() throws DAOException;
}
