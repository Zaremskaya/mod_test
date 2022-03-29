
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@TestInstance(Lifecycle.PER_CLASS)
public class Test1Grid4JUnit {
private WebDriver driver;
String baseURL, nodeURL;
protected ThreadLocal<RemoteWebDriver> threadDriver = null;  
 
@BeforeAll
 public void setUp() throws MalformedURLException {
	 baseURL="https://www.calculator.net/triangle-calculator.html";
	 nodeURL="http://192.168.0.2:4444";
	 }

  @Test
  public void test1()  throws Throwable {
	  System.out.println("Executing on FireFox");
	  DesiredCapabilities capability=new DesiredCapabilities();
	  capability.setBrowserName("firefox");
	  capability.setPlatform(Platform.WIN10);
	  driver=new RemoteWebDriver(new URL(nodeURL),capability);
	  driver.get(baseURL);
	  driver.manage().window().setSize(new Dimension(972, 978));
	    driver.findElement(By.cssSelector(".clearbtn")).click();
	    driver.findElement(By.name("vx")).click();
	    driver.findElement(By.name("vx")).sendKeys("3");
	    driver.findElement(By.name("vy")).click();
	    driver.findElement(By.name("vy")).sendKeys("3");
	    driver.findElement(By.name("vz")).click();
	    driver.findElement(By.name("vz")).sendKeys("3");
	    driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
	    assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Equilateral Triangle");
	    driver.quit();
	    }
 @Test
 public void test2() throws Throwable {
 System.out.println("Executing on CHROME");
 DesiredCapabilities cap = new DesiredCapabilities();
 cap.setBrowserName("chrome");
 cap.setPlatform(Platform.WIN10);
 driver = new RemoteWebDriver(new URL(nodeURL), cap);
  driver.get(baseURL);
    driver.manage().window().setSize(new Dimension(972, 978));
    driver.findElement(By.cssSelector(".clearbtn")).click();
    driver.findElement(By.name("vx")).click();
    driver.findElement(By.name("vx")).sendKeys("3");
    driver.findElement(By.name("vy")).click();
    driver.findElement(By.name("vy")).sendKeys("3");
    driver.findElement(By.xpath("//input[@value=\'Calculate\']")).click();
    
      List<WebElement> elements = driver.findElements(By.xpath("//font[.=\'Please provide 3 positive values, including at least one side.\']"));
      assert(elements.size() > 0);
      driver.quit();
}
 @Test
 public void test3() throws Throwable {
 System.out.println("Executing on CHROME");
 DesiredCapabilities cap = new DesiredCapabilities();
 cap.setBrowserName("chrome");
 cap.setPlatform(Platform.WIN10);

 driver = new RemoteWebDriver(new URL(nodeURL), cap);
 driver.get(baseURL);
    driver.manage().window().setSize(new Dimension(972, 978));
    driver.findElement(By.name("angleunits")).click();
    {
      WebElement dropdown = driver.findElement(By.name("angleunits"));
      dropdown.findElement(By.xpath("//option[. = 'radian']")).click();
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id=\'dg3\'][.=\'r\']")));
    }
    driver.findElement(By.name("angleunits")).click();
    {
      WebElement dropdown = driver.findElement(By.name("angleunits"));
      dropdown.findElement(By.xpath("//option[. = 'degree °']")).click();
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id=\'dg3\'][.=\'°\']")));
    }
    driver.quit();
  }
 @Test
 public void test4() throws Throwable {
 System.out.println("Executing on CHROME");
 DesiredCapabilities cap = new DesiredCapabilities();
 cap.setBrowserName("chrome");
 cap.setPlatform(Platform.WIN10);

 driver = new RemoteWebDriver(new URL(nodeURL), cap);
 driver.get(baseURL);
    driver.manage().window().setSize(new Dimension(972, 978));
    driver.findElement(By.cssSelector(".clearbtn")).click();
    driver.findElement(By.name("vx")).click();
    driver.findElement(By.name("vx")).sendKeys("2");
    driver.findElement(By.name("vy")).click();
    driver.findElement(By.name("vy")).sendKeys("3");
    driver.findElement(By.name("vz")).click();
    driver.findElement(By.name("vz")).sendKeys("10");
    driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
    assertEquals(driver.findElement(By.cssSelector("font")).getText(), "The sum of two sides must be larger than the third.");
    driver.quit();
    }
 @Test
 public void test5() throws Throwable {
 System.out.println("Executing on FireFox");

 DesiredCapabilities capability=new DesiredCapabilities();

 capability.setBrowserName("firefox");
 capability.setPlatform(Platform.WIN10);

 driver=new RemoteWebDriver(new URL(nodeURL),capability);
 driver.get(baseURL);
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
    driver.quit();
  }
  
 @Test
 public void test6() throws Throwable {
 System.out.println("Executing on FireFox");

 DesiredCapabilities capability=new DesiredCapabilities();

 capability.setBrowserName("firefox");
 capability.setPlatform(Platform.WIN10);

 driver=new RemoteWebDriver(new URL(nodeURL),capability);
 driver.get(baseURL);
    driver.manage().window().setSize(new Dimension(972, 978));
    driver.findElement(By.cssSelector(".clearbtn")).click();
    driver.findElement(By.name("vx")).click();
    driver.findElement(By.name("vx")).sendKeys("a");
    driver.findElement(By.name("vy")).click();
    driver.findElement(By.name("vy")).sendKeys("b");
    driver.findElement(By.name("vz")).click();
    driver.findElement(By.name("vz")).sendKeys("c");
    driver.findElement(By.xpath("//input[@value=\'Calculate\']")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[.=\'Please provide 3 positive values, including at least one side.\']")));
    }
    driver.quit();
    }
}
