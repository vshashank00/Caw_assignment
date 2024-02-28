package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class Indexpage {
    WebDriver driver;
    @FindBy(xpath = "//details/child::summary")
    WebElement table_data_button;
    @FindBy(xpath = "//textarea[@id='jsondata']")
    WebElement textbox;
    @FindBy(xpath = "//button[@id='refreshtable']")
    WebElement refresh_button;
    public Indexpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    void feedData(String jsonData) {
        table_data_button.click();
        textbox.clear();
        textbox.sendKeys(jsonData);
        refresh_button.click();
    }

    void verify_feed_data(List<HashMap<String, String>> hashMapList) {
        int n = 2;
        for (int i = 0; i < hashMapList.size(); i++) {
            String[] arr = driver.findElement(By.xpath("//table[@id='dynamictable']/child::tr" + "[" + n + "]")).getText().split(" ");
            Assert.assertTrue(arr[0].equalsIgnoreCase(hashMapList.get(i).get("name")) && arr[1].equalsIgnoreCase(hashMapList.get(i).get("age")) && arr[2].equalsIgnoreCase(hashMapList.get(i).get("gender")));
            System.out.println("verifiocation done for row:" + i + " " + hashMapList.get(i));
            n++;
        }

    }

}