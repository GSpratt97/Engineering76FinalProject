package com.sparta.greg.pom.pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public abstract class Browser {

    public static boolean isSafari(WebDriver webDriver)
    {
        return webDriver.getClass() == SafariDriver.class;
    }

    public static void submit(WebDriver webDriver)
    {
        WebElement element = webDriver.findElement(By.cssSelector("button[type*='submit']"));
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", element);
        safariSleep();
    }

    public static String safariDateFormat(String[] dates)
    {
        StringBuilder build = new StringBuilder();
        build.append(dates[2]);
        build.append("-");
        build.append(dates[1]);
        build.append("-");
        build.append(dates[0]);
        safariSleep();
        return build.toString();
    }

    public static void safariSleep()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
