package work;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TriangleSteps {
WebDriver driver;
	
	@Given("^I open Triangle Calculate$")
	public void i_open_triangle_calculate() {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
		 driver = new ChromeDriver();
		 driver.get("https://www.calculator.net/triangle-calculator.html");	
	}
	
	@When("^I clear all param$")
	public void i_clear_all_param() {
		driver.findElement(By.cssSelector(".clearbtn")).click();
	}
	@And("^I set value \"2\" for \"A\"$")
	public void i_set_value_2() {
		driver.findElement(By.name("vx")).click();
		driver.findElement(By.name("vx")).sendKeys("2");
		}
	@And("^I set value \"3\" for \"B\"$")
	public void i_set_value_3() {
		driver.findElement(By.name("vy")).click();
		driver.findElement(By.name("vy")).sendKeys("3");
		}
	@And("^I set value \"10\" for \"C\"$")
	public void i_set_value_10() {
		driver.findElement(By.name("vz")).click();
		driver.findElement(By.name("vz")).sendKeys("10");
		}
	@And("^I click button \"Calculate\"$")
	public void i_click_button_Calculate() {
		driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		}
	
	@Then("^The calculated result is \"The sum of two sides must be larger than the third.\"$")
	public void the_calculated_result() {
		assertEquals(driver.findElement(By.cssSelector("font")).getText(), "The sum of two sides must be larger than the third.");		//  driver.quit();
		 driver.close();	
	}
}





