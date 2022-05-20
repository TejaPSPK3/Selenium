package seleniumAssignment;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AssignmentTest {

	public static WebDriver driverAs;
	public static Actions action;
	public static WebDriverWait wait;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public static void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driverAs = new ChromeDriver();
		driverAs.manage().window().maximize();
		driverAs.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driverAs.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driverAs, Duration.ofSeconds(25));
		driverAs.get("http://automationpractice.com/index.php");
		action = new Actions(driverAs);
	}
	@Test(priority = 1,description = "Login--->Test")
	public static void signin()  
	{
		try
		{
			driverAs.findElement(By.className("login")).click();
			driverAs.findElement(By.id("email")).sendKeys("tejachannel6@gmail.com");
			driverAs.findElement(By.id("passwd")).sendKeys("Kteja@123",Keys.ENTER);
			Thread.sleep(2000);
			String currentTitle = driverAs.getTitle().toString();
			String actualTitle = "My account - My Store";
			Assert.assertEquals(currentTitle, actualTitle);
		}catch(Exception exception){
			Assert.fail("Login failed - Your Credentials are incorrect try again"+exception);
		}
	}
	@Test(priority = 2,description = "Selecting T-shirts in women--->Test")
	public static void selectTshirtInWomen() 
	{
		try
		{
			action.moveToElement(driverAs.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")))
			.moveToElement(driverAs.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")))
			.click()
			.perform();
			String currentTitle = driverAs.getTitle();
			String actualTitle = "T-shirts - My Store";
			Assert.assertEquals(currentTitle, actualTitle);
		}catch(Exception exception){
			Assert.fail("Selecting T-shirts in women was FAIL retry the test software" +exception);
		}
	}
	@Test(priority = 3,description = "Clicking on more button--->Test")
	public static void clickMore() 
	{
		try
		{
			action.moveToElement(driverAs.findElement(By.className("right-block")))
			.moveToElement(driverAs.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]")))
			.click()
			.perform();
			String currentTitle = driverAs.getTitle();
			String actualTitle = "Faded Short Sleeve T-shirts - My Store";
			Assert.assertEquals(currentTitle, actualTitle);
		}catch(Exception exception){
			Assert.fail("Clicking more was FAIL retry the test software" +exception);
		}
	}
	@Test(priority = 4,description = "Selecting Quantity, Size and Color--->Test")
	public static void QuantSizeColor()
	{
		WebElement quantity  = driverAs.findElement(By.id("quantity_wanted"));
		quantity.clear();
		quantity.sendKeys("2");
		WebElement size = driverAs.findElement(By.id("group_1"));
		Select sizeSelect = new Select(size);
		sizeSelect.selectByValue("3");
		driverAs.findElement(By.name("Blue")).click();
	}
	@Test(priority = 5,description = "Adding in cart and Proceed to checkout--->Test")
	public static void addCartAndProceed() 
	{
		try
		{
			driverAs.findElement(By.name("Submit")).click();					
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"))).click();
			String currentTitle = driverAs.getTitle();
			String actualTitle = "Order - My Store";
			Assert.assertEquals(currentTitle, actualTitle);
		}catch(Exception exception){
			Assert.fail("Adding cart and proceed was FAIL retry the test software" +exception);
		}
	}
	@AfterTest
	public static void finish() 
	{
		driverAs.quit();
	}
}