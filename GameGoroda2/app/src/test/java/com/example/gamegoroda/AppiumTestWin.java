package com.example.gamegoroda;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

public class AppiumTestWin {
    AndroidDriver driver;
    //  WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
//Set the Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Nexus 6P (Google)");
        capabilities.setCapability("avd", "Nexus_6P_API_30");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7");
        capabilities.setCapability("appPackage", "com.example.gamegoroda");
        //capabilities.setCapability("appActivity", "com.example.gamegoroda.GameActivity");
        capabilities.setCapability("appActivity", "com.example.gamegoroda.MenuActivity");
        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void button_Towns() {
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
        //driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("2");
        driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@index='1']")).getText();
        //String result = driver.findElement(By.xpath("//android.widget.Button[@index='0']")).getText();
        Assert.assertEquals("Указанного города не существует",result);
    }
    @Test
    public void button_Country() {
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        //driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("2");
        driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@index='1']")).getText();
        //String result = driver.findElement(By.xpath("//android.widget.Button[@index='0']")).getText();
        Assert.assertEquals("Указанной страны не существует",result);
    }
    @Test
    public void button_Name() {
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        //driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("2");
        driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@index='1']")).getText();
        //String result = driver.findElement(By.xpath("//android.widget.Button[@index='0']")).getText();
        Assert.assertEquals("Указанного имени не существует",result);
    }

    @After
    public void End() {
        driver.quit();
    }
}
