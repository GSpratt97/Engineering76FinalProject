package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterAttendance {

    private String submitMessage;

    public void setPageConfirm() {
        this.pageConfirm = webDriver
                .findElement(By.cssSelector("h1[class*='h3 mb-3 font-weight-normal']"))
                .getText();
    }

    private String pageConfirm;
    private String dateSelected;

    WebDriver webDriver;

    public String getSubmitMessage() {
        return submitMessage;
    }

    public EnterAttendance(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public String getPageConfirm() {
        return pageConfirm;
    }

    public void setSubmitMessage(String isSuccess) {
        if(isSuccess.equals("success"))
        {
            this.submitMessage = webDriver.findElement(By.cssSelector("#content-wrapper > main > div > div > div > div > div > div > div > form > p")).getText();
        }
        else{
            this.submitMessage = webDriver.findElement(By.cssSelector("p[class*='letterGradeF']")).getText();
        }
    }

    public void selectTrainee(String name)
    {
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
        }
    }

    public void selectDate(String string)
    {
        webDriver.findElement(By.name("attendanceDate")).sendKeys(string);
    }

    public void submit()
    {
        webDriver.findElement(By.cssSelector("button[type*=submit]")).click();
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
}
