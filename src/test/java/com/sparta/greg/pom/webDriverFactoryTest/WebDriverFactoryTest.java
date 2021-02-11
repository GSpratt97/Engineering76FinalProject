package com.sparta.greg.pom.webDriverFactoryTest;

import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactoryTest {



    @Test
    @DisplayName("Testing that a Chrome driver is returned")
    void checkForChrome(){
        Assertions.assertEquals(ChromeDriver.class, WebDriverFactory.getWebDriver(WebDriverType.CHROME).getClass());
    }

    @Test
    @DisplayName("Testing that a Firefox driver is returned")
    void checkForFirefox(){
        Assertions.assertEquals(FirefoxDriver.class, WebDriverFactory.getWebDriver(WebDriverType.FIREFOX).getClass());
    }

    @Test
    @DisplayName("Testing that a Safari driver is returned")
    void checkForSafari(){
        Assertions.assertEquals(SafariDriver.class, WebDriverFactory.getWebDriver(WebDriverType.SAFARI).getClass());
    }

    @Test
    @DisplayName("Testing that a Internet Explorer driver is returned")
    void checkForIE(){
        Assertions.assertEquals(InternetExplorerDriver.class, WebDriverFactory.getWebDriver(WebDriverType.INTERNET_EXPLORER).getClass());
    }

    @Test
    @DisplayName("Testing that a Microsoft Edge driver is returned")
    void checkForEdge(){
        Assertions.assertEquals(EdgeDriver.class, WebDriverFactory.getWebDriver(WebDriverType.MICROSOFT_EDGE).getClass());
    }

    @Test
    @DisplayName("Testing that a Chrome driver is returned headlessly")
    void checkForChromeHeadless(){
        Assertions.assertEquals(ChromeDriver.class, WebDriverFactory.runHeadless(WebDriverType.CHROME).getClass());
    }

    @Test
    @DisplayName("Testing that a Firefox driver is returned headlessly")
    void checkForFirefoxHeadless(){
        Assertions.assertEquals(FirefoxDriver.class, WebDriverFactory.runHeadless(WebDriverType.FIREFOX).getClass());
    }









}
