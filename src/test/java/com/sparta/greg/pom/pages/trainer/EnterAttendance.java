package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.templates.Page;
import com.sparta.greg.pom.pages.fragments.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class EnterAttendance extends Page {

    private String submitMessage, pageConfirm;
    private String[] dates;
    private final SideBarTrainer sideBarTrainer;

    public String getSubmitMessage() {
        return submitMessage;
    }

    public void setPageConfirm() {
        this.pageConfirm = webDriver
                .findElement(By.cssSelector("h1[class*='h3 mb-3 font-weight-normal']"))
                .getText();
    }

    public EnterAttendance(WebDriver webDriver)
    {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    public void setSubmitMessage(String isSuccess) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isSuccess.equals("success"))
        {
            this.submitMessage = webDriver.findElement(By.cssSelector("p[class*='letterGradeA mt-3']")).getText();
        }
        else{
            this.submitMessage = webDriver.findElement(By.cssSelector("p[class*='letterGradeF']")).getText();
        }
    }

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    public void selectTrainee(String name)
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch(name)
        {
            case "David":
                webDriver.findElement(By.cssSelector("option[value*=\"10\"]")).click();
                break;
            case "Reece":
                webDriver.findElement(By.cssSelector("option[value*=\"187\"]")).click();
                break;
            case "Ben":
                webDriver.findElement(By.cssSelector("option[value*=\"188\"]")).click();
                break;
            case "Toyin":
                webDriver.findElement(By.cssSelector("option[value*=\"189\"]")).click();
                break;
            case "Shahid":
                webDriver.findElement(By.cssSelector("option[value*=\"190\"]")).click();
                break;
            case "Janja":
                webDriver.findElement(By.cssSelector("option[value*=\"191\"]")).click();
                break;
            case "Emmanuel":
                webDriver.findElement(By.cssSelector("option[value*=\"192\"]")).click();
                break;
            case "Bill":
                webDriver.findElement(By.cssSelector("option[value*=\"41\"]")).click();
                break;
        }
    }

    public void selectDate(String string)
    {
        string = formatDateForDriverType(string, webDriver);
        webDriver.findElement(By.name("attendanceDate")).sendKeys(string);
    }

    public void submit()
    {
        if(webDriver.getClass() == SafariDriver.class)
        {
            //Safari browser not working with selenium click function, so it needs to executed with javascript
            WebElement element = webDriver.findElement(By.cssSelector("button[type*='submit']"));
            JavascriptExecutor executor = (JavascriptExecutor)webDriver;
            executor.executeScript("arguments[0].click();", element);
        }
        else
        {
            webDriver.findElement(By.cssSelector("button[type*='submit']")).click();
        }
    }

    public void selectAttendanceType(String type)
    {
        switch (type)
        {
            case "On Time":
                webDriver.findElement(By.id("attendanceId1")).click();
                break;
            case "Late":
                webDriver.findElement(By.id("attendanceId2")).click();
                break;
            case "Absent (Excused)":
                webDriver.findElement(By.id("attendanceId3")).click();
                break;
            case "Absent (Unexcused)":
                webDriver.findElement(By.id("attendanceId4")).click();
                break;
        }
    }

    public String formatDateForDriverType(String date, WebDriver webDriver)
    {
        StringBuilder build = new StringBuilder();
        if(date.contains("/"))
        {
            dates = date.split(("/"));
        }
        else
        {
            dates = date.split("-");
        }
        if(webDriver.getClass() == SafariDriver.class)
        {
            build.append(dates[2]);
            build.append("-");
            build.append(dates[1]);
            build.append("-");
            build.append(dates[0]);
            date = build.toString();
        }

        return date;
    }

    public Boolean areOnAttendanceEntryPage(String string) {
        return pageConfirm.contains(string);
    }

    public boolean isCorrectAttendanceType(String type)
    {

        switch (type)
        {
            case "On Time":
                type = "attendanceId1";
                break;
            case "Late":
                type = "attendanceId2";
                break;
            case "Absent (Excused)":
                type = "attendanceId3";
                break;
            case "Absent (Unexcused)":
                type = "attendanceId4";
                break;
        }

        return webDriver.findElement(By.id(type)).isSelected();
    }

    public boolean isCorrectDate(String date)
    {
        String[] foundDate = webDriver
                .findElement(By.id("attendanceDate")).getAttribute("value").split("-");
        StringBuilder build = new StringBuilder();
        if(foundDate[0].length() != 2)
        {
            build.append(foundDate[2]);
            build.append("-");
            build.append(foundDate[1]);
            build.append("-");
            build.append(foundDate[0]);
        }
        else
        {
            build.append(foundDate[0]);
            build.append("-");
            build.append(foundDate[1]);
            build.append("-");
            build.append(foundDate[2]);
        }
        return date.equals(build.toString());
    }
}
