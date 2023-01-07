package com.vut.fit.gja.vut_news_selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VUTNews {

    /**
     * A Showcase of Selenium used to read news from VUT index page. A webdriver
     * is required, in this case a chromedriver is provided. After the news
     * listing, the application takes a screenshot of the page
     *
     * @param args
     */
    public static void main(String[] args) {

        // provided driver "chromedriver.exe" in this example is for chrome v 108 on windows
        // for other OS or chrome version, please see https://chromedriver.chromium.org/downloads
        // you can see your chrome version in browser on this address chrome://settings/help
        // set the driver in system property hashMap so chromeDriver class can locate it
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // make it run in background
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // start the driver
        WebDriver driver = new ChromeDriver(options);

        // get on desired page and find news
        driver.get("https://www.vut.cz");
        List<WebElement> news = driver.findElements(By.className("b-news"));

        news.stream().map(aNew -> {
            WebElement title = aNew.findElement(By.className("b-news__title"));
            WebElement date = aNew.findElement(By.className("b-news__date"));
            WebElement link = aNew.findElement(By.className("b-news__link"));
            System.out.println(title.getText());
            System.out.println(date.getAttribute("datetime"));
            System.out.println(link.getAttribute("href"));
            return aNew;
        }).forEachOrdered((WebElement _item) -> {
            // divider
            System.out.println("---------------------------------------");
        });

        // Selenium can take screenshots even while working in background
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
        } catch (IOException ex) {
            System.out.println("exception while saving screenshot");
        }

        driver.quit();
    }
}
