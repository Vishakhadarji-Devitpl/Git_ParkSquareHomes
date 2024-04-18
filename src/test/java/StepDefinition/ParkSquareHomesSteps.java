package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ParkSquareHomesSteps {

	public WebDriver driver;

	@Given("user navigate to the PRISM login page")
	public void user_navigate_to_the_prism_login_page() {
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://prismtest.devitsandbox.com/");
	}

	@Then("enter the username and password")
	public void enter_the_username_and_password() {
		driver.findElement(By.id("Username")).sendKeys("kdesai");
		driver.findElement(By.id("Password")).sendKeys("Pr!sm@123#");
		// driver.findElement(By.id("btnlogin")).click();

		WebElement loginbtn = driver.findElement(By.id("btnlogin"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginbtn);

		driver.findElement(By.xpath("//a[@title='Dashboard']")).click();
	}

	@Then("validate user is on home page")
	public void validate_user_is_on_home_page() throws Exception {

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Landing Page Dashboard | Park Square Homes", title);
		Thread.sleep(2000);
	}

	@Given("user click on main Warranty module")
	public void user_click_on_main_warranty_module() {
		driver.findElement(By.id("liWarranty")).click();
	}

	@Then("user click on Manage Service Request module")
	public void user_click_on_manage_service_request_module() {

		driver.findElement(By.id("liServiceRequest")).click();
	}

	@Then("validate user is on manage service request page")
	public void validate_user_is_on_manage_service_request_page() {

		String srtitle = driver.getTitle();
		System.out.println(srtitle);
		Assert.assertEquals("Manage Service Requests | Park Square Homes", srtitle);
	}

	@Given("user click on main Accounting module")
	public void user_click_on_main_accounting_module() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '80%'");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[@title='Accounting']")).click();
		WebElement accbtn = driver.findElement(By.xpath("//a[@title='Accounting']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", accbtn);
	}

	@Then("user click on BPRA Calculation module")
	public void user_click_on_bpra_calculation_module() throws Exception {

		// driver.findElement(By.id("liBPRA")).click();
		Thread.sleep(2000);
		WebElement bprabtn = driver.findElement(By.xpath("//a[@title='BPRA Calculation']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", bprabtn);
		Thread.sleep(2000);
		}

	@Then("validate user is on BPRA Calculation page")
	public void validate_user_is_on_bpra_calculation_page() {
		String bpratitle = driver.getTitle();
		System.out.println(bpratitle);
		Assert.assertEquals("BPRA Calculation | Park Square Homes", bpratitle);
	}

	@Then("user close the browser")
	public void user_close_the_browser() {
		driver.quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) 
		{
			//Screenshot
			  File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  byte[] filecontent = FileUtils.readFileToByteArray(sourcePath);
			  scenario.attach(filecontent, "image/png", "image"); 
		}
	}
}
