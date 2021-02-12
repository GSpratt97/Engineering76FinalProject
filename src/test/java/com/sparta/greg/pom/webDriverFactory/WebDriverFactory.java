package com.sparta.greg.pom.webDriverFactory;

import org.openqa.selenium.Dimension;
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
                System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
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


    public static WebDriver getWebDriverWithWindowSize(WebDriverType webDriverType, int width, int height ){
        switch (webDriverType){
            case CHROME:
                WebDriver chromeDriver = new ChromeDriver();
                chromeDriver.manage().window().setSize(new Dimension(width, height));
                return chromeDriver;
            case SAFARI:
                WebDriver safariDriver = new SafariDriver();
                safariDriver.manage().window().setSize(new Dimension(width, height));
                return safariDriver;
            case FIREFOX:
                WebDriver firefoxDriver = new FirefoxDriver();
                firefoxDriver.manage().window().setSize(new Dimension(width, height));
                return firefoxDriver;
            case INTERNET_EXPLORER:
                System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                WebDriver IEDriver = new InternetExplorerDriver();
                IEDriver.manage().window().setSize(new Dimension(width, height));
                return IEDriver;
            case MICROSOFT_EDGE:
                System.setProperty("webdriver.edge.driver","msedgedriver.exe");
                WebDriver edgeDriver = new EdgeDriver();
                edgeDriver.manage().window().setSize(new Dimension(width, height));
                return edgeDriver;
        }
        return null;
    }



}
