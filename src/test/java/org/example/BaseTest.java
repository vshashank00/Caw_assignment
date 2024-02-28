package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    Indexpage indexpage;
    String url="https://testpages.herokuapp.com/styled/tag/dynamic-table.html";
    WebDriver intiliaze_driver() throws IOException {
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(new File(System.getProperty("user.dir"))+"/src/main/java/Config/Browser.properties");
        properties.load(fileInputStream);
        String browsername= System.getProperty("browser")!=null?System.getProperty("browser"):properties.getProperty("browser");
        if (browsername.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }else if(browsername.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }else if (browsername.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();

        }else
            System.out.println("not a compatible driver");
        return driver;


    }
    @BeforeTest
    void indexpage() throws IOException {
        driver=intiliaze_driver();
        driver.manage().window().maximize();
        driver.get(url);
       indexpage=new Indexpage(driver);

    }
    @AfterTest
    void shut(){
        driver.quit();
    }

}
