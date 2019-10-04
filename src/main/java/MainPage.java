
//    a) Зайти на сайт (английская версия) https://www.booking.com
//b) Выбрать город "New York"
//c) дата: May 1, 2020 - May 30, 2020
//d) Поиск

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    private String cityName = "New York";

    private By cityNameLocator = By.id("ss");
    private By calendar = By.xpath("/html/body/div[3]/div/div/div[2]/form/div[1]/div[2]");
    private By nextMonth = By.xpath("/html/body/div[3]/div/div/div[2]/form/div[1]/div[2]/div[2]/div/div/div[2]");
    private By dateTo = By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[5]");
    private By dateFrom = By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[6]/td[6]");
    private By searchButton = By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button");


    public MainPage(WebDriver driver, String cityName) {
        this.driver = driver;
        cityName = this.cityName;

    }


    public MainPage checkLink() {
        driver.get("https://www.booking.com/index.en-gb.html");

        if (!"Booking.com: 29,006,117 hotel and property listings worldwide. 193+ million hotel reviews.".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the 'Booking.com' page");

        }
        return this;
    }

    public MainPage typeCityName() {
        driver.findElement(cityNameLocator).sendKeys(cityName);
        return this;
    }

    public MainPage checkDate() {

        //open calendar
        driver.findElement(calendar).click();

        //swich to nessesary month
        for (int i = 0; i < 7; i++) {
            driver.findElement(nextMonth).click();
        }
        //select the first data
        driver.findElement(dateTo).click();
        //select the second data
        driver.findElement(dateFrom).click();

        return this;
    }

    public void pressSearchButton() {
        driver.findElement(searchButton).click();
    }

    public SearchPage searchVariantsForBook() {

        checkLink();
        typeCityName();
        checkDate();
        pressSearchButton();

        return new SearchPage(driver);
    }

}