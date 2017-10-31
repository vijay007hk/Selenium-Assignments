package WalletHub.WalletHub;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FaceBookLogin {

	public static void main(String[] args) throws InterruptedException {
		
		String user_name="vijayoothk@gmail.com";
		String password="ethalaygujuree1";
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver ff = new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		//Login to Facebook
		ff.get("http://www.facebook.com");
		ff.findElement(By.id("email")).clear();
		ff.findElement(By.id("pass")).clear();
		ff.findElement(By.id("email")).sendKeys(user_name);
		ff.findElement(By.id("pass")).sendKeys(password);
		ff.findElement(By.xpath("//input[@value='Log In']")).click();
		//click on "Home" link
		ff.findElement(By.partialLinkText("Home")).click();
		//type status as "Hello World" and hit Post
		ff.findElement(By.xpath("//textarea[@name='xhpc_message']")).sendKeys( "\"Hello World\"");
		ff.findElement(By.xpath("//button[@class='_1mf7 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
		Thread.sleep(11000);
		ff.close();

	}

}
