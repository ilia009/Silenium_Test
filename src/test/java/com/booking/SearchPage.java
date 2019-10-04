package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
        checkEachHotel();

    }

    public void checkEachHotel() {

        List<WebElement> vse = driver.findElements(By.className("hotel_name_link"));
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < vse.size(); i++) {

            list.add(vse.get(i).getAttribute("href"));
        }

        for (String s : list) {
            checkCity(s);
            checkDate(s);
        }

    }

    public void checkCity(String link) {

        driver.get(link);
        String espectCity = "New York";

        WebElement realCity = driver.findElement((By.className("hp_address_subtitle")));

        if (realCity.getText().contains(espectCity)) {
            System.out.println("Right city");
        } else {
            System.out.println("Wrong city");
        }
    }


    public void checkDate(String link) {
        System.out.println("Starting chek");

        driver.get(link);
        String dateTo = "1 May 2020";
        String dateFrom = "30 May 2020";

        if (driver.findElements(By.className("av-summary-checkout")).size() != 0) {

            WebElement realDateTo = driver.findElement(By.className("hp-dates-summary__date"));
            WebElement realDateFrom = driver.findElement(By.className("av-summary-checkout"));


            if (realDateTo.getText().contains(dateTo) && realDateFrom.getText().contains(dateFrom)) {
                System.out.println("this hotel is good");
            } else {
                System.out.println("Wrong date");
            }


        } else {
            System.out.println("Date not available");
        }


    }


}



