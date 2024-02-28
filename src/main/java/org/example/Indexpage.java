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
    String table_xpath="//table[@id='dynamictable']/child::tr";
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
       List <WebElement> list= driver.findElements(By.xpath(table_xpath));
       list.remove(0);
       for (int i=0;i<list.size();i++){
           String arr[]=list.get(i).getText().split(" ");
           Assert.assertTrue(arr[0].equalsIgnoreCase(hashMapList.get(i).get("name")) && arr[1].equalsIgnoreCase(hashMapList.get(i).get("age")) && arr[2].equalsIgnoreCase(hashMapList.get(i).get("gender")));
           System.out.println("verifiocation done for row:" + (i+1) + " " + hashMapList.get(i));

       }
    }

}
