package lesson11;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dao.GroupDao;
import domain.Group;
import sql.SqlGroupDao;

public class SqlGroupDaoTest {

	private List<Group> list;
	private GroupDao groupDao;

	@BeforeMethod
	public void setUp() throws Exception {
		this.groupDao = new SqlGroupDao();
	}

	@AfterMethod 
	public void tearDown() throws Exception {
		this.groupDao.close();
	}

	@Test
	public void selectAllGroupsTest() throws Exception {

		List<Group> list = groupDao.selectAllGroups();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);

	}

	@Test
	public void selectGroupTest() throws Exception {

		List<Group> list = groupDao.selectAllGroups();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Group g = list.get(0);
		Group group = groupDao.selectGroup(g.getId());
		Assert.assertNotNull(group);
		Assert.assertTrue(group.getId() > 0);

	}

	@Test
	public void updateGroupTest() throws Exception {

		groupDao.insertGroup(3000, "Создание");
		List<Group> list = groupDao.selectAllGroups();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Group g = list.get(list.size() - 1);
		int id = g.getId();
		int number = g.getNumber();
		String department = g.getDepartment();

		groupDao.updateGroup(id, number + 1, department + "new");

		List<Group> listNew = groupDao.selectAllGroups();
		Assert.assertNotNull(listNew);
		Assert.assertTrue(listNew.size() > 0);
		Group gNew = listNew.get(list.size() - 1);
		int idNew = gNew.getId();
		int numberNew = gNew.getNumber();
		String departmentNew = gNew.getDepartment();

		Assert.assertEquals(id, idNew);
		Assert.assertEquals(number + 1, numberNew);
		Assert.assertEquals(department + "new", departmentNew);

	}

	@Test
	public void insertGroupTest() throws Exception {

		list = groupDao.selectAllGroups();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();
		groupDao.insertGroup(3000, "Создание");
		list = groupDao.selectAllGroups();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize + 1);

		Group g = list.get(list.size() - 1);
		int id = g.getId();
		int number = g.getNumber();
		String department = g.getDepartment();
		Assert.assertTrue(id > 0);
		Assert.assertEquals(3000, number);
		Assert.assertEquals("Создание", department);

	}

	@Test
	public void deleteGroupTest() throws Exception {

		groupDao.insertGroup(2000, "Удаление");
		List<Group> list = groupDao.selectAllGroups();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		int oldSize = list.size();
		Group g = list.get(list.size() - 1);
		groupDao.deleteGroup(g.getId());
		list = groupDao.selectAllGroups();
		int newSize = list.size();
		Assert.assertNotNull(list);
		Assert.assertEquals(newSize, oldSize - 1);

	}

}