package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.navigate().to("https://dvi-internal-qa.azurewebsites.net/ats");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("before method was executed");
	
		driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/div/div[2]/div/a")).click();
		 System.out.println("Login button clicked");
		 Thread.sleep(3000);
	
		driver.findElement(By.id("i0116")).sendKeys("username");
		driver.findElement(By.id("idSIButton9")).click();
		 System.out.println("User Name entered");
		 Thread.sleep(3000);
	

		driver.findElement(By.name("passwd")).sendKeys("password");
		 System.out.println("Password entered");
		 Thread.sleep(3000);
		 		
	
		driver.findElement(By.id("idSIButton9")).click();
		 System.out.println("Sign in button");
		 Thread.sleep(3000);
	

		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		 System.out.println("Yes on the dialog");
		 Thread.sleep(3000);
		 
		driver.findElement(By.id("offcanvasNavbarDropdown-expand-md")).click();
		 System.out.println("Recruitment menu is clicked");
		 Thread.sleep(3000);
		 
		 driver.findElement(By.linkText("Add Requirement")).click();
		 System.out.println("Add Requirement is selected");
		 Thread.sleep(3000);
		 
		 }
	
	 
	@After 
	public void tearDown() {
		
		driver.quit();
		
		
	}

}


