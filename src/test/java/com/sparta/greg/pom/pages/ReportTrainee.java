package com.sparta.greg.pom.pages;

import org.openqa.selenium.WebDriver;

public class ReportTrainee {
    WebDriver webDriver;

    public ReportTrainee(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public boolean doesExpandButtonWork() {

        //find expand button
        //click expand button
        //return 'aria-expanded'

        return false;
    }

    public boolean isWeekNumberCorrect() {

        //in table, week numbers should descend

        //find the table
        //get its elements in a list
        //set bool true until a week number is not one less than the previous week

        return false;
    }


}
