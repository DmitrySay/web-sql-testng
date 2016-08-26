package lesson11;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dao.MarkDao;
import domain.Mark;
import sql.SqlMarkDao;

public class SqlMarkDaoTest {

	private List<Mark> list;
	private List<Mark> listNew;
	private MarkDao markDao;

	@BeforeMethod
	public void setUp() throws Exception {
		this.markDao = new SqlMarkDao();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		this.markDao.close();

	}

	@Test
	public void selectAllMarksTest() throws Exception {

		list = markDao.selectAllMarks();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);

	}

	@Test
	public void selectMarkTest() throws Exception {

		list = markDao.selectAllMarks();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Mark m = list.get(0);
		Mark mark = markDao.selectMark(m.getId());
		Assert.assertNotNull(mark);
		Assert.assertTrue(mark.getId() > 0);

	}

	@Test
	public void updateMarkTest() throws Exception {

		list = markDao.selectAllMarks();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Mark m = list.get(0);
		int id = m.getId();
		int studentId = m.getStudentId();
		int mark = m.getMark();
		Assert.assertNotNull(m);
		Assert.assertTrue(m.getId() > 0);

		markDao.updateMark(id, studentId, mark + 1);

		listNew = markDao.selectAllMarks();
		Assert.assertNotNull(listNew);
		Assert.assertTrue(listNew.size() > 0);
		Mark mNew = listNew.get(0);
		int idNew = mNew.getId();
		int studentIdNew = mNew.getStudentId();
		int markNew = mNew.getMark();

		Assert.assertEquals(id, idNew);
		Assert.assertEquals(studentId, studentIdNew);
		Assert.assertEquals(mark + 1, markNew);

	}

	@Test
	public void insertMarkTest() throws Exception {

		list = markDao.selectAllMarks();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();

		markDao.insertMark(1, 5);

		list = markDao.selectAllMarks();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize + 1);
		Mark m = list.get(list.size() - 1);
		int id = m.getId();
		int studentId = m.getStudentId();
		int mark = m.getMark();

		Assert.assertTrue(id > 0);
		Assert.assertEquals(1, studentId);
		Assert.assertEquals(5, mark);
	}

	@Test
	public void deleteMarkTest() throws Exception {

		markDao.insertMark(2, 5);
		list = markDao.selectAllMarks();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();
		Mark m = list.get(list.size() - 1);

		markDao.deleteMark(m.getId());

		list = markDao.selectAllMarks();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize - 1);
	}

}