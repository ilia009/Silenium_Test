package com.booking;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    public ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","../chromedriver1.exe");
        driver = new ChromeDriver();

        System.out.println("Test start");
    }

    @After
    public void close(){
        System.out.println("Test close");
        driver.quit();
    }
}
