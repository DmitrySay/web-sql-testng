package sql;

import dao.DAOException;
import dao.DaoFactory;
import dao.StudentDao;
import domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlStudentDao implements StudentDao {

	private Connection connection = null;
	private PreparedStatement prepareStatementInsert;
	private PreparedStatement prepareStatementDelete;
	private PreparedStatement prepareStatementSelect;
	private PreparedStatement prepareStatementUpdate;
	private PreparedStatement prepareStatementSelectStudentGroup;
	private PreparedStatement prepareStatementSelectAllStudents;
	private PreparedStatement prepareStatementSelectAllStudentsGroupsMarks;

	private String insertStudent = "INSERT INTO `Student` (name, surname, group_id) VALUES (?, ?, ?)";
	private String deleteStudent = "DELETE FROM `Student` WHERE id = ?";
	private String selectStudent = "SELECT S.id, S.name, S.surname, S.enrolment_date, S.group_id, G.id, G.number, G.department  FROM `Student` S INNER JOIN `Group` G ON S.group_id = G.id WHERE S.id = ?;";
	private String updateStudent = "UPDATE `Student` \n" + "SET name = ?, surname  = ?, group_id = ? \n"
			+ "WHERE id = ?;";
	private String selectStudentandGroup = "SELECT S.id, S.name, S.surname, S.enrolment_date, G.id, G.number, G.department FROM `Student` S INNER JOIN `Group` G ON S.group_id = G.id";
	private String selectAllStudents = "SELECT id, name, surname, enrolment_date, group_id FROM `Student`;";
	private String selectAllStudentsGroupsMarks = "SELECT S.id, S.name, S.surname, S.enrolment_date, G.id, G.number, G.department, M.mark FROM `Student` S INNER JOIN `Group` G ON S.group_id = G.id INNER JOIN `Mark` M ON M.student_id=S.id";

	

	
	public SqlStudentDao() throws DAOException {
		try {

			DaoFactory daoFactory = new SqlDaoFactory();
			this.connection = daoFactory.getConnection();
			prepareStatementInsert = connection.prepareStatement(insertStudent);
			prepareStatementDelete = connection.prepareStatement(deleteStudent);
			prepareStatementSelect = connection.prepareStatement(selectStudent);
			prepareStatementUpdate = connection.prepareStatement(updateStudent);
			prepareStatementSelectStudentGroup = connection.prepareStatement(selectStudentandGroup);
			prepareStatementSelectAllStudents = connection.prepareStatement(selectAllStudents);
			prepareStatementSelectAllStudentsGroupsMarks = connection.prepareStatement(selectAllStudentsGroupsMarks);
		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения SqlStudentDao", e);
		}
	}

	@Override
	public void insertStudent(String name, String surname, int groupId) throws DAOException {

		try {

			
			prepareStatementInsert.setString(1, name);
			prepareStatementInsert.setString(2, surname);
			prepareStatementInsert.setInt(3, groupId);
			prepareStatementInsert.execute();

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода insertStudent", e);
		}

	}

	@Override
	public void deleteStudent(int id) throws DAOException {

		try {

			prepareStatementDelete.setInt(1, id);
			prepareStatementDelete.executeUpdate();

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода deleteStudent", e);
		}

	}

	@Override
	public Student selectStudent(int id) throws DAOException {

		Student s = new Student();
		try {

			prepareStatementSelect.setInt(1, id);
			ResultSet rs = prepareStatementSelect.executeQuery();
			rs.next();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setSurname(rs.getString("surname"));
			s.setEnrolmentDate(rs.getDate("enrolment_date"));
			s.setGroupId(rs.getInt("group_id"));
			s.setNumber(rs.getInt("number"));
			s.setDepartment(rs.getString("department"));

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода readStudent", e);
		}
		return s;
	}

	@Override
	public void updateStudent(int id, String name, String surname, int groupId) throws DAOException {

		try {

			prepareStatementUpdate.setString(1, name);
			prepareStatementUpdate.setString(2, surname);
			prepareStatementUpdate.setInt(3, groupId);
			prepareStatementUpdate.setInt(4, id);
			prepareStatementUpdate.execute();

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода updateStudent", e);
		}

	}

	@Override
	public List<Student> selectAllStudentAndGroup() throws DAOException {
		List<Student> list = new ArrayList<Student>();
		try {

			ResultSet rs = prepareStatementSelectStudentGroup.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setSurname(rs.getString("surname"));
				s.setEnrolmentDate(rs.getDate("enrolment_date"));
				s.setNumber(rs.getInt("number"));
				s.setDepartment(rs.getString("department"));
				
				list.add(s);
			}

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода selectAllStudentAndGroup", e);
		}
		return list;
	}
	

	@Override
	public List<Student> selectAllStudents() throws DAOException {

		List<Student> list = new ArrayList<Student>();
		try {

			ResultSet rs = prepareStatementSelectAllStudents.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setSurname(rs.getString("surname"));
				s.setEnrolmentDate(rs.getDate("enrolment_date"));
				s.setGroupId(rs.getInt("group_id"));
				list.add(s);
			}

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода selectAllStudents", e);
		}

		return list;
	}

	@Override
	public void selectAllStudentsGroupsMarks() throws DAOException {

		try {

			ResultSet rs = prepareStatementSelectAllStudentsGroupsMarks.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("id") + " ");
				System.out.print(rs.getString("name") + " ");
				System.out.print(rs.getString("surname") + " ");
				System.out.print(rs.getInt("number") + " ");
				System.out.print(rs.getString("department") + " ");
				System.out.print(rs.getInt("mark") + " ");

				System.out.println();
			}

		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения метода selectAllStudentsGroupsMarks", e);
		}
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
			if (prepareStatementSelectStudentGroup != null) {
				prepareStatementSelectStudentGroup.close();
			}
		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения закрытия prepareStatementSelectStudentGroup", e);
		}
		try {
			if (prepareStatementSelectAllStudents != null) {
				prepareStatementSelectAllStudents.close();
			}
		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения закрытия prepareStatementSelectAllStudents", e);
		}
		try {
			if (prepareStatementSelectAllStudentsGroupsMarks != null) {
				prepareStatementSelectAllStudentsGroupsMarks.close();
			}
		} catch (Exception e) {

			throw new DAOException("Ошибка выполнения закрытия prepareStatementSelectAllStudentsGroupsMarks", e);
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