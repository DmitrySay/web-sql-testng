package dao;



import domain.Student;
import java.util.List;

/** Объект для управления персистентным состоянием объекта Student */
public interface StudentDao {

    /** Создает новую запись и соответствующий ей объект */
    public void insertStudent(String name, String surname, int groupId) throws DAOException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Student selectStudent( int id) throws DAOException;

    /** Сохраняет состояние объекта group в базе данных */
    public void updateStudent(int id, String name, String surname, int groupId) throws DAOException;

    /** Удаляет запись об объекте из базы данных */
    public void deleteStudent(int id) throws DAOException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Student> selectAllStudents() throws DAOException;

    public List<Student> selectAllStudentAndGroup() throws DAOException;

    public void selectAllStudentsGroupsMarks() throws DAOException;

    public void close() throws DAOException;

	




}
