package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterAttendance extends Page {

    private String submitMessage;
    private String pageConfirm;
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

    public String getPageConfirm() {
        return pageConfirm;
    }

    public void setSubmitMessage(String isSuccess) {
        if(isSuccess.equals("success"))
        {
            this.submitMessage = webDriver.findElement(By.cssSelector("p[class*='letterGradeA mt-3']")).getText();
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
        //String formatted = dateFormatter(webDriver.findElement(By.name("attendanceDate")).getAttribute("value"), string);
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

    public String dateFormatter(String date, String newDate)
    {
        String[] dates = null;
        String[] formattedDate = null;
        StringBuilder build = new StringBuilder();
        if(date.contains("/"))
        {
            dates = date.split(("/"));
            formattedDate = newDate.split(("/"));
        }
        else
        {
            dates = date.split("-");
            formattedDate = newDate.split("-");
        }
        if(dates[0].length() != 2){
            build.append(formattedDate[2]);
            build.append("-");
            build.append(formattedDate[1]);
            build.append("-");
            build.append(formattedDate[0]);
        }
        else
        {
            return newDate;
        }

        return build.toString();
    }
}
