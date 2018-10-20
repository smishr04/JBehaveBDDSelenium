package Steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sampleSteps extends Steps {
	
	WebDriver driver;
	
	@Given("I launch chrome browser")
	public void lunchChromeBrowser(){
		
		File file = new File("./Driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disbale-extensions");	
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	
	}
	
	@When("I enter the url $url")
	public void enterURL(String url){
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	@Then("I verify the title is $title")
	public void verifyGooglePage(String title){
		
		Assert.assertEquals(title, driver.getTitle());
		
	}
	
	@Then("I close the browser")
	public void closeBrowser(){
		
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
