

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


@TestInstance(Lifecycle.PER_CLASS)
public class Test5 {
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
  public void test5() {
    driver.get("https://www.calculator.net/triangle-calculator.html");
    driver.manage().window().setSize(new Dimension(972, 978));
    driver.findElement(By.cssSelector(".clearbtn")).click();
    driver.findElement(By.name("vx")).click();
    driver.findElement(By.name("vx")).sendKeys("3");
    driver.findElement(By.name("vy")).click();
    driver.findElement(By.name("vy")).sendKeys("4");
    driver.findElement(By.name("vz")).click();
    driver.findElement(By.name("vz")).sendKeys("5");
    driver.findElement(By.xpath("//input[@value=\'Calculate\']")).click();
    assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Right Scalene Triangle");
    driver.close();
  }
}
