
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.*;

@TestInstance(Lifecycle.PER_CLASS)
public class Test1 {
	
  private WebDriver driver;
  
  @BeforeAll
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
  }
  @AfterAll
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test1() {
    driver.get("https://www.calculator.net/triangle-calculator.html");
    driver.manage().window().setSize(new Dimension(972, 978));
    driver.findElement(By.cssSelector(".clearbtn")).click();
    driver.findElement(By.name("vx")).click();
    driver.findElement(By.name("vx")).sendKeys("3");
    driver.findElement(By.name("vy")).click();
    driver.findElement(By.name("vy")).sendKeys("3");
    driver.findElement(By.xpath("//input[@value=\'Calculate\']")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//font[.=\'Please provide 3 positive values, including at least one side.\']"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.name("vz")).click();
    driver.findElement(By.name("vz")).sendKeys("3");
    driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
    assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Equilateral Triangle");
  }
}
