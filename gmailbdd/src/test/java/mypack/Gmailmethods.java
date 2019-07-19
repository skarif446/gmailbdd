package mypack;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Gmailmethods
{
	public WebDriver driver;
	public Scenario s;
	public void screenshot()
	{
		byte[] ss=((TakesScreenshot) driver)
			    .getScreenshotAs(OutputType.BYTES);
		s.embed(ss,"image/png");
	}
	@Before
	public void method1(Scenario s)
	{
		this.s=s;
	}
	@Given("^launch gmail site$")
	public void method2() throws Exception
	{
		File f=new File("bdddata.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		System.setProperty("webdriver.chrome.driver",
			     p.getProperty("bdpath"));           
		driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
	}
	@Then("^title is \"(.*)\" for home page$")
	public void method3(String d)
	{
		String at=driver.getTitle();
		if(d.equals(at))
		{
			s.write("Title test was passed");
		}
		else
		{
			s.write("Title test was failed");
			this.screenshot();
			Assert.fail();
		}
	}
	@And("^(close site)|(close gmail site)$")
	public void method4(String x, String y)
	{
		driver.close();
	}
	@Then("^Userid field is displayed$")
	public void method5()
	{
		try
		{
			if(driver.findElement(By.name("identifier"))
					                     .isDisplayed())
			{
				s.write("Test was passed");
			}
		}
		catch(Exception ex)
		{
			s.write("Test was failed");
			this.screenshot();
			Assert.fail();
		}
	}
	@When("^enter userid as \"(.*)\" value$")
	public void method6(String uid)
	{
		driver.findElement(By.name("identifier"))
		                          .sendKeys(uid);
	}
	@And("^click next$")
	public void method7() throws Exception
	{
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
	}
	@Then("^validate output for \"(.*)\" criteria$")
	public void method8(String c) 
	{
		try
		{
			if(c.equalsIgnoreCase("valid") &&
				driver.findElement(By.name("password"))
				.isDisplayed())
			{
				s.write("Userid test passed");
			}
			else if(c.equalsIgnoreCase("invalid") &&
				driver.findElement(By.xpath(
				"(//*[contains(text(),'Enter an email') or contains(text(),'find your Google')])[2]"))
				.isDisplayed())
			{
				s.write("Userid test passed");
			}
			else
			{
				s.write("Userid test failed");
				this.screenshot();
				Assert.fail();
			}
		}
		catch(Exception ex)
		{
			s.write("Userid test was interrupted");
			this.screenshot();
			Assert.fail();
		}
	}
	@And("^enter password as \"(.*)\" value$")
	public void method9(String p)
	{
		driver.findElement(By.name("password")).sendKeys(p);
	}
	@And("^click pwd next$")
	public void method10() throws Exception
	{
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(5000);
	}
	@Then("^validate result for \"(.*)\" criteria$")
	public void method11(String pc)
	{
		try
		{
			if(pc.equalsIgnoreCase("valid") &&
				driver.findElement(By.xpath(
				"//*[text()='COMPOSE']")).isDisplayed())
			{
				s.write("Password test passed");
			}
			else if(pc.equalsIgnoreCase("invalid") &&
				driver.findElement(By.xpath(
				"//*[text()='Enter a password' or contains(text(),'Wrong password')]"))
				.isDisplayed())
			{
				s.write("Password test passed");
			}
			else
			{
				s.write("Password test failed");
				this.screenshot();
				Assert.fail();
			}
		}
		catch(Exception ex)
		{
			s.write("Password test was interrupted");
			this.screenshot();
			Assert.fail();
		}
	}
}



