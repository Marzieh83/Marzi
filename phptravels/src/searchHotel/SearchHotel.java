package searchHotel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchHotel {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Documents/Selenium/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//running URL		
		driver.get("http://www.phptravels.net");
		String webTitle = driver.getTitle();
		if (webTitle.equals("PHPTRAVELS | Travel Technology Partner")){
			System.out.println("PHPTRAVELS website is opened Successfully");
		}
		else {			
			System.out.println("PHPTRAVELS website is not opened");
			driver.quit();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	
//Login Page
		driver.findElement(By.xpath("//div[@class='row']//ul/li/a[contains(text(),' My Account ')]")).click();
		driver.findElement(By.xpath("//div[@class='row']//ul/li/a[contains(text(),' Login')]")).click();
		
		boolean verify1 = driver.findElement(By.xpath("//div[1]/div[1][contains(text(),'Login')]")).isDisplayed();			
		if (verify1){
			System.out.println("You are in Login Page");
		}
		else {
			System.out.println("You're not in Login Page");
			driver.quit();
		}

//Login Successfully		
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.xpath("//*[@id='loginfrm']/div[1]/div[5]/button")).click();
		
		Thread.sleep(1500);
		boolean Text = driver.findElement(By.xpath("//div/div[1]/div/div[1]/h3[contains(text(),'Hi, DVhbCERv IlqEZZxz')]")).isDisplayed();			
		if (Text){
			System.out.println("User logged in successfully");
		}
		else {
			System.out.println("Invalid Email or Password");
			driver.quit();
		}
		Thread.sleep(1500);

		
//Click HOME
		driver.findElement(By.xpath("//div[@class='col-md-4 col-sm-3 col-xs-7 go-right'] //a[@class='navbar-brand go-right loader']")).click();
		Thread.sleep(1500);

		if (webTitle.equals("PHPTRAVELS | Travel Technology Partner")){
			System.out.println("You are in homepage");
		}
		else {			
			System.out.println("You are not in homepage");
			driver.quit();
		}
		
//Simple Search
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='s2id_autogen10']/a")).click();
		WebElement send = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='Montreal'", send);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='dpd1']/input")).click();
		WebElement send1 = driver.findElement(By.xpath("//*[@id='dpd1']/input"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].value='11/22/2017'", send1);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id='dpd2']/input")).click();
		WebElement send2 = driver.findElement(By.xpath("//*[@id='dpd2']/input"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].value='11/24/2017'", send2);

//dropdown
		Select Dropdown1 = new Select(driver.findElement(By.name("adults")));
		Dropdown1.selectByVisibleText("2");
		Select Dropdown2 = new Select(driver.findElement(By.name("child")));
		Dropdown2.selectByVisibleText("0");
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1500);

//Simple Search2
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='s2id_autogen10']/a")).click();
		WebElement send3 = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].value='new york'", send3);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='dpd1']/input")).click();
		WebElement send4 = driver.findElement(By.xpath("//*[@id='dpd1']/input"));
		JavascriptExecutor executor4 = (JavascriptExecutor) driver;
		executor4.executeScript("arguments[0].value='11/11/2017'", send4);
		Thread.sleep(1000);
				
		driver.findElement(By.xpath("//*[@id='dpd2']/input")).click();
		WebElement send5 = driver.findElement(By.xpath("//*[@id='dpd2']/input"));
		JavascriptExecutor executor5 = (JavascriptExecutor) driver;
		executor5.executeScript("arguments[0].value='11/20/2017'", send5);

//dropdown
		Select Dropdown3 = new Select(driver.findElement(By.name("adults")));
		Dropdown3.selectByVisibleText("5");
		Select Dropdown4 = new Select(driver.findElement(By.name("child")));
		Dropdown4.selectByVisibleText("1");
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1500);
	}
}
