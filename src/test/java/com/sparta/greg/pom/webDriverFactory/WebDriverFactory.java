package com.sparta.greg.pom.webDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {


    public static WebDriver getWebDriver(WebDriverType webDriverType){
        switch (webDriverType){
            case CHROME:
                return new ChromeDriver();
            case SAFARI:
                return new SafariDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case INTERNET_EXPLORER:
                return new InternetExplorerDriver();
            case MICROSOFT_EDGE:
                System.setProperty("webdriver.edge.driver","msedgedriver.exe");
                return new EdgeDriver();
        }
        return null;
    }


    public static WebDriver runHeadless(WebDriverType webDriverType){
        switch (webDriverType){
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                return new ChromeDriver(chromeOptions);

            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);
        }

        return null;
    }



}
