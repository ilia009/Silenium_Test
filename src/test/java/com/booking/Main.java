package com.booking;

import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    private static ChromeDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Desktop/chromedriver1.exe");
        driver = new ChromeDriver();

        MainPage mainPage = new MainPage(driver, "New York");

        mainPage.searchVariantsForBook();


        driver.quit();

    }

}
