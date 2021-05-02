package dog_shopingmall_proj.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dog_shopingmall_proj.JdbcUtil;
import dog_shopingmall_proj.dao.impl.DogDAOImpl;
import dog_shopingmall_proj.dto.Dog;

public class DogDAOTest {
	private static Connection con = JdbcUtil.getConnection();
	private static DogDAOImpl dao = DogDAOImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void testSelectDogList() {
		System.out.println("testSelectDogList()");
		
		List<Dog> list = dao.selectDogList();
		Assert.assertNotEquals(null, list);
		
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectDog() {
		System.out.println("testSelectDog()");
		
		int id = 1;
		Dog dog = dao.selectDog(id);
		Assert.assertNotEquals(null, dog);
		
		System.out.println("dog > " + dog);
	}

	// @Test
	public void testInsertDog() {
		System.out.println("testInsertDog()");
		Dog newDog = new Dog(0, "포메라니안", 3000, "for.jpg", "영국", 1, 15, "2중모", 0);
		int res = dao.insertDog(newDog);
		Assert.assertEquals(1, res);
		
		System.out.println("res > " + res);
	}

	@Test
	public void testUpdateReadCount() {
		System.out.println("testUpdateReadCount()");
				
		int id = 1;
		int res = dao.updateReadCount(id);
		Assert.assertEquals(1, res);
		
		System.out.println("dog > " + dao.selectDog(id));
	}

}
