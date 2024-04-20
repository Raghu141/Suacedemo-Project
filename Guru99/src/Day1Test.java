import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.io.Files;

public class Day1Test {
	
	 
	 static WebDriver driver;
	 static  Date currentdate = new Date();
	 static String screenshotname = currentdate.toString().replace(" ", "-").replace(":","-");
	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println(screenshotname);
		System.setProperty("webdriver.chrome.driver","C://chromedriver-win64//CD March 3rd//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mngr561740");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("uzEqUpu");
		Thread.sleep(2000);
		screenshot();
		System.out.println("Screenshot 1 taken");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		Thread.sleep(2000);
		WebElement note =  driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee"));
		System.out.println(note.getText());
		screenshot();
		System.out.println("Screenshot 2 taken");
		Assert.assertTrue(note.isDisplayed());
		screenshot();
		System.out.println("Screenshot 3 taken");
		driver.close();
		
	}
	public static void screenshot() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest  = new File("C://Users//shravanthi//OneDrive//Desktop//MyProject//"+ screenshotname +".png");
		Files.copy(src,dest);
		
	}

}
