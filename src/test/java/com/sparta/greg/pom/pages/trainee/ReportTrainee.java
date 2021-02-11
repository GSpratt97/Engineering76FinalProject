package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.Report;
import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.WebDriver;

public class ReportTrainee extends Report {

    private final SideBarTrainee sideBarTrainee;

    /**
     * http://localhost:8080/trainee/report
     * @param webDriver
     */
    public ReportTrainee(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainee = new SideBarTrainee(webDriver);
        webDriver.get("http://localhost:8080/trainee/report");
        setWeekReports();
    }

    public SideBarTrainee getSideBarTrainee() {
        return sideBarTrainee;
    }
}
