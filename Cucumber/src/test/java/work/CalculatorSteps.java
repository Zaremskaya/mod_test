package work;


import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;



public class CalculatorSteps {
WebDriver driver;
	
	@Given("^I use the calculater$")
	public void i_lanch() {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
		 driver = new ChromeDriver();
		 driver.get("https://www.calculator.net/math-calculator.html");	
	}
	
	@When("^I enter \"1\" into the calculator$")
	public void i_set_1() {
		 driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(1)")).click();
	}
	@And("^I add \"200\"$")
	public void i_add_200() {
		  driver.findElement(By.cssSelector("div:nth-child(1) > .sciop:nth-child(4)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(2)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();
	}
	@And("^I subtract \"200\"$")
	public void i_subtract_200() {
		  driver.findElement(By.cssSelector("div:nth-child(2) > .sciop:nth-child(4)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(2)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();
	}
	@And("^I divide by \"555\"$")
	public void i_divide_555() {
		  driver.findElement(By.cssSelector("div:nth-child(4) > .sciop:nth-child(4)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
	}
	@And("^I multiply by \"555\"$")
	public void i_multiply_555() {
		  driver.findElement(By.cssSelector("div:nth-child(3) > .sciop:nth-child(4)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
		  driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
	}
	
	@Then("^The calculated result is \"1\"$")
	public void the_calculated_result_is_1() {
		assertEquals(driver.findElement(By.id("sciOutPut")).getText(), " 1");
		driver.quit();
		
	}
	
}
