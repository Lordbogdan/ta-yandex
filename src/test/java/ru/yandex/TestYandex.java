package ru.yandex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class TestYandex extends WebDriverSettings {

    @Test
    public void testYandex() {
        driver.get("https://yandex.ru/news/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals
                ("Яндекс.Новости: Главные новости сегодня, самые свежие и последние новости России онлайн"));
        tabTechnology();
        searchPicture();
        identity();
        linkTrue();
        searchLink();
    }

    public void tabTechnology() {
        driver.get("https://yandex.ru/news/rubric/computers");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals
                ("Новости технологий сегодня в Яндекс.Новостях"));
    }

    public void searchPicture() {
        driver.get("https://yandex.ru/news/rubric/computers");
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println(" Number of images found on page = " + images.size());

        List<WebElement> headingText = driver.findElements(By.tagName("h2"));
        System.out.println("heading text = " + headingText.size());

        List<WebElement> hotNews = driver.findElements(By.className("mg-card__annotation"));
        System.out.println("Hot news = " + hotNews.size());
        WebElement textTest = driver.findElement(By.className("mg-card__annotation"));

        isClickable(textTest, driver);
    }

    public static boolean isClickable(WebElement el, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            System.out.println(true);
            return true;
        } catch (Exception e) {
            System.out.println(false);
            return false;
        }

    }
    public void identity() {
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("/html/head/link[8]")).click();

//        WebElement text1 = driver.findElement(By.tagName("h2"));
//        text1.click();
//        List<WebElement> text2 = driver.findElementsByTagName("h2");
//        Assert.assertEquals(text2, text1);
//        System.out.println(text2);
//        System.out.println(text1);
////
////        if (driver.findElements(By.tagName("h2")).size() != 0) {
////            System.out.println("Element is Present");
////        } else {
////            System.out.println("Element is Absent");
////        }
//        driver.get("https://yandex.ru/news/rubric/computers");
//        String title = driver.getTitle();
//        Assert.assertTrue(title.equals
//                ("Новости технологий сегодня в Яндекс.Новостях"));
//        WebElement element = driver.findElement(By.xpath("//*[@id=\"neo-page\"]/div/div[2]/div/div[1]/div[2]/div[1]/article/div[2]/a/h2"));
//        element.click();
//        if(driver.findElements(By.xpath("//*[@id=\"neo-page\"]/div/div[2]/div/div[1]/div[2]/div[1]/article/div[2]/a/h2")).size() !=0){
//            System.out.println("win");
//        }
//        else {
//            System.out.println("The end");
//        }
    }

    public void linkTrue() {
        driver.findElement(By.tagName("a"));
        if (driver.findElements(By.tagName("a")).size() != 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public void searchLink() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {

            url = it.next().getAttribute("href");


            if (url == null || url.isEmpty()) {
                continue;
            }

            if (!url.startsWith(homePage)) {
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    System.out.println(false);
                } else {
                    System.out.println(true);
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
