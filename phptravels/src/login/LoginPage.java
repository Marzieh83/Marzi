package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
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

//correct password	
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
		
		
//logout	
		Thread.sleep(1500);		
		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-8 col-xs-5 go-left']/ul[1]/li[1]/a")).click();
		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-8 col-xs-5 go-left']//ul/li[2]/a[contains(text(),'Logout')]")).click();
		Thread.sleep(1500);		
		
		boolean verify2 = driver.findElement(By.xpath("//div[1]/div[1][contains(text(),'Login')]")).isDisplayed();			
		if (verify2){
			System.out.println("You logged out successfully");
		}
		else {
			System.out.println("Invalid Email or Password");
			driver.quit();
		}
		
		
//wrong password	
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser123");
		driver.findElement(By.xpath("//*[@id='loginfrm']/div[1]/div[5]/button")).click();
		
		Thread.sleep(1500);
		boolean Text1 = driver.findElement(By.xpath("//*[@id='loginfrm']/div[1]/div[2]/div[contains(text(),'Invalid Email or Password')]")).isDisplayed();			
		if (Text1){
			System.out.println("Invalid Email or Password");
		}
		else {
			System.out.println("There is an error, you logged in with wrong password");
			driver.quit();
		}
	}		
}

