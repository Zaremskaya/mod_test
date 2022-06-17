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

public class AppiumTestGameActivity {
    AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
//Set the Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Nexus 6P (Google)");
        capabilities.setCapability("avd", "Nexus_6P_API_30");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7");
        capabilities.setCapability("appPackage", "com.example.gamegoroda");
        capabilities.setCapability("appActivity", "com.example.gamegoroda.MenuActivity");
        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void text_View() {
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@text='Введите слово' and @index='0']")).getText();
        Assert.assertEquals("Введите слово",result);
    }
    @Test
    public void button_Send() {
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
        String result = driver.findElement(By.xpath("//android.widget.Button[@index='3']")).getText();
        Assert.assertEquals("ОТПРАВИТЬ",result);
    }
    @Test
    public void button_Defeated() {
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
        String result = driver.findElement(By.xpath("//android.widget.Button[@index='4']")).getText();
        Assert.assertEquals("СДАТЬСЯ",result);
    }

    @After
    public void End() {
        driver.quit();
    }
}
