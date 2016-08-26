package dao;

import java.util.List;
import domain.Group;


/** Объект для управления персистентным состоянием объекта Group */
public interface GroupDao {

    /** Создает новую запись и соответствующий ей объект */

    public void insertGroup(int number, String department) throws DAOException ;


    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Group selectGroup(int id) throws DAOException;

    /** Сохраняет состояние объекта group в базе данных */
    public void updateGroup(int id, int number, String department) throws DAOException;

    /** Удаляет запись об объекте из базы данных */
    public void deleteGroup(int id) throws DAOException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Group> selectAllGroups() throws DAOException;

    public void close() throws DAOException;
}
