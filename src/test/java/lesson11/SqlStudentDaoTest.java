package lesson11;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dao.StudentDao;
import domain.Student;
import sql.SqlStudentDao;

public class SqlStudentDaoTest {

	private List<Student> list;
	private List<Student> listNew;
	private StudentDao studentDao;

	@BeforeMethod
	public void setUp() throws Exception {
		this.studentDao = new SqlStudentDao();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		this.studentDao.close();
	}

	@Test
	public void selectAllStudentTest() throws Exception {

		list = studentDao.selectAllStudents();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);

	}

	@Test
	public void selectStudentTest() throws Exception {

		list = studentDao.selectAllStudents();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Student s = list.get(0);
		Student student = studentDao.selectStudent(s.getId());
		Assert.assertNotNull(student);
		Assert.assertTrue(student.getId() > 0);

	}

	@Test
	public void updateStudentTest() throws Exception {

		studentDao.insertStudent("Петя", "Иванов", 1);
		list = studentDao.selectAllStudents();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Student s = list.get(list.size() - 1);
		int id = s.getId();

		studentDao.updateStudent(id, "Катя", "Иванова", 2);

		listNew = studentDao.selectAllStudents();
		Assert.assertNotNull(listNew);
		Assert.assertTrue(listNew.size() > 0);
		Student student = listNew.get(list.size() - 1);
		String nameNew = student.getName();
		String surnameNew = student.getSurname();
		int groupIdNew = student.getGroupId();
		int idNew = student.getId();

		Assert.assertEquals(id, idNew);
		Assert.assertEquals("Катя", nameNew);
		Assert.assertEquals("Иванова", surnameNew);
		Assert.assertEquals(2, groupIdNew);

	}

	@Test
	public void insertStudentTest() throws Exception {

		list = studentDao.selectAllStudents();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();

		studentDao.insertStudent("Петя", "Иванов", 1);
		list = studentDao.selectAllStudents();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize + 1);

		Student s = list.get(list.size() - 1);
		String name = s.getName();
		String surname = s.getSurname();
		int groupId = s.getGroupId();
		int id = s.getId();

		Assert.assertTrue(id > 0);
		Assert.assertEquals("Петя", name);
		Assert.assertEquals("Иванов", surname);
		Assert.assertEquals(1, groupId);

	}

	@Test
	public void deleteStudentTest() throws Exception {

		studentDao.insertStudent("Петя", "Иванов", 1);
		list = studentDao.selectAllStudents();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();
		Student s = list.get(list.size() - 1);
		studentDao.deleteStudent(s.getId());
		list = studentDao.selectAllStudents();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize - 1);

	}

	public void selectAllStudentAndGroupTest() throws Exception {

		list = studentDao.selectAllStudentAndGroup();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);

	}

}