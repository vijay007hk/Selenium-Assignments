package WalletHub.WalletHub;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;


public class TestInsuranceReview {

	public static void main(String[] args) throws InterruptedException {

		String user_name="vijay007hk@gmail.com";
		String password="Murrary@1";
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver ff = new FirefoxDriver();
		WebElement five_stars;
		WebElement policy_select;
		WebElement policy;
		WebElement previous_msg;
		String review_post;
		String review_msg = "This is one the best Title Insurance companies in the U.S.A.,"
				+"this offers many insurance types and the primary one is Title insurance."
				+"This has its own application to generate Owners\' and Lenders\' policies."
				+"The app can be used by third party insurance agents as well.";

		String base_url="https://www.wallethub.com";
		String test_insurance="https://wallethub.com/profile/test_insurance_company/";
		String review_page="https://wallethub.com/profile/vijay_kumarh/reviews/";

		ff.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		//Login to WalletHub.com
		ff.get(base_url);
		ff.findElement(By.xpath("//*[@id='viewport']/header/div/nav[3]/a[1]")).click();
		ff.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
		ff.findElement(By.xpath("//input[@type='password']")).clear();
		ff.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(user_name);
		ff.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		ff.findElement(By.xpath("//*[@id='join-login']/form/div[4]/button[2]")).click();
		Thread.sleep(3000);
		ff.navigate().to(test_insurance);
		Thread.sleep(4000);
		//hover over stars and click fourth star
		five_stars=ff.findElement(By.xpath("//span[@class='wh-rating rating_5']"));
		Actions builder = new Actions(ff);
		Action mouseOverLink = builder.moveToElement(five_stars).build();
		mouseOverLink.perform();
		ff.findElement(By.xpath("//*[@id='wh-body-inner']/div[2]/div[3]/div[1]/div/a[4]")).click();
		Thread.sleep(4000);
		policy_select=ff.findElement(By.xpath("//*[@id='reviewform']/div[1]/div/div/span[2]/i"));
		//click on policy dropdown
		policy_select.click();
		policy=ff.findElement(By.xpath("//*[@id='reviewform']/div[1]/div/ul/li[2]/a"));
		//select option as "Health"
		policy.click();
		//select overall rating as five star
		ff.findElement(By.xpath("//div[@class='rating']/div/span[@id='overallRating']/a[5]")).click();
		//enter review comments in text area
		ff.findElement(By.xpath("//textarea[@id='review-content']")).clear();
		ff.findElement(By.xpath("//textarea[@id='review-content']")).sendKeys(review_msg);
		try{
			//verify if there is any previous message
			previous_msg=ff.findElement(By.xpath("//div[@class='reviewmsg']"));
			if(previous_msg.isDisplayed()){
				ff.findElement(By.xpath("//div[@class='submit']/input[@value='Submit']")).click();
			}
      	}
		catch(Exception e){
			//hit submit button
			ff.findElement(By.xpath("//*[@id='reviewform']/div[3]/div[2]/input")).click();
			Thread.sleep(4000);
		}
		ff.navigate().to(review_page);
		Thread.sleep(4000);
		//verify the review section has previously entered text
		review_post=ff.findElement(By.xpath("//div[@class='reviews']/div/p")).getText();
		System.out.println(review_post);
		Assert.assertEquals(review_msg.trim(), review_post.trim());
		ff.close();

	}
}
