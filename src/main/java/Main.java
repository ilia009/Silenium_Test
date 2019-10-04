import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ChromeDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","../Desktop/chromedriver1.exe");
        driver = new ChromeDriver();

        MainPage mainPage = new MainPage(driver, "New York");
        mainPage.searchVariantsForBook();


        driver.quit();

    }

}
