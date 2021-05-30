package ru.yandex;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.safari.SafariDriver;

import java.net.HttpURLConnection;

public class WebDriverSettings {
    public SafariDriver driver;
    String url = "";
    String homePage = "https://yandex.ru/news/story/Sony_vypustit_desktopnuyu_versiyu_Uncharted--a2e01fa9c501f95b205304772b205da5?persistent_id=144934752";
    HttpURLConnection huc = null;
    int respCode = 200;

    @Before
    public void setUp() {
        driver = new SafariDriver();
    }

//    @After
//    public void close(){
//        driver.quit();
//    }
}
