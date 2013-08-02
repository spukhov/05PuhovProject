package com.puhov.entity;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.persistence.*;
/*
import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
*/
public class TestClass {
	/*
	WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//ul//a[contains(.,'Dishes')]")
	private WebElement dishesLink;
	@FindBy(xpath="//a[contains(.,'Pizza')]")
	private WebElement pizzaLink;
	
	String HOME_URL = "http://localhost:8080/02PuhovProject/faces/home.xhtml";
	
	
	@Before
	public void navigateTeSite() throws InterruptedException{
		PageFactory.initElements(driver, pizzaLink);
		driver = new FirefoxDriver();
		driver.get(HOME_URL);
		Thread.sleep(5000);
	}
	@After
	public void closeDriver() throws InterruptedException{
		Thread.sleep(5000);
		driver.close();
	}
	
	@Test
	public void testDishesPageLink() throws MalformedURLException, InterruptedException{

		
		Thread.sleep(5000);
		WebElement element = pizzaLink;
		element.click();
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//a[contains(.,'Info')]"));
		Thread.sleep(5000);
		element1.click();
		Thread.sleep(5000);
		WebElement element2 = driver.findElement(By.xpath("//a[contains(.,'Login')]"));
		
		Thread.sleep(5000);
		element2.click();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
	}
	
	
	/*
	
	private static final String UNIT_NAME = "Restaurant";
	private static EntityManagerFactory factory;
	
	
	
	@Test
	public void testGetActualMenu(){
		//Get menu list
		List<MenuItem> testList1 = DBQueries.selectAllMenuItems();
		if (testList1==null){
			fail("No such records in DB");
		}
		
		int quantity = testList1.size();
		Assert.assertEquals(quantity, 26);
		
	}
	
	@Test
	public void testGetActualMenuByCategory(){
		//Get menu list by category
		List<MenuItem> testList = DBQueries.selectAllMenuItemsByCategoryName("Drinks");
		if (testList==null){
			fail("No such records in DB");
		}
		int quantity = testList.size();
		Assert.assertEquals(quantity, 7);
	}
	
	@Test
	public void testCreateOrder(){
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Orders order = new Orders("Test", "Test", new java.sql.Date(new Date(2012, 01, 01, 12, 14, 14).getTime()), 200.00);
		int quant1=DBQueries.getOrderList().size();
		DBQueries.createOrder(order);
		int quant2=DBQueries.getOrderList().size();
		Assert.assertEquals(1, quant2-quant1);
		//removing
		Orders order2 = em.find(Orders.class, 6);
		int quant3=DBQueries.getOrderList().size();
		em.remove(order2);
		int quant4=DBQueries.getOrderList().size();
		Assert.assertEquals(0, quant4-quant3);
	}
	
//	@Test
//	public void testCreateUserRole(){
//		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
//		EntityManager em = factory.createEntityManager();
//		Users user = em.find(Users.class, 5);
//		Role role = em.find(Role.class, 2);
//		
//		UserRoles ur = new UserRoles(user, role);
//		int quant1=DBQueries.getUserRolesList().size();
//		DBQueries.createUserRole(ur);
//		int quant2=DBQueries.getUserRolesList().size();
//		Assert.assertEquals(1, quant2-quant1);
//		//removing
//		UserRoles urr = em.find(UserRoles.class, 7);
//		int quant3=DBQueries.getUserRolesList().size();
//		em.remove(urr);
//		int quant4=DBQueries.getUserRolesList().size();
//		Assert.assertEquals(0, quant4-quant3);
//	}
//	
	@Test
	public void testGetFirstReport(){
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		GregorianCalendar d1=new GregorianCalendar(2012, 01, 03);
		GregorianCalendar d2=new GregorianCalendar(2013, 02, 04);
		List<Res> list = DBQueries.getFirstReport(d1.getTime(), d2.getTime());
			if (list==null){
				fail("ResaultList is null");
			}
			double sum = 0;
			int q = 0;
			for (Res r : list) {
				sum+=r.getOrderTotalSum();
				q+=r.getOrderCount();
			}
		Assert.assertEquals(803.0, sum);
		Assert.assertEquals(5, q);
	}
	
	*/
}
