package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsultancySkills {
    WebDriver webDriver;

    public enum buttonsOnTheConsultancySkills {
        STUDIOUS("collapseCard1"),
        PROFESSIONAL("collapseCard2"),
        INDEPENDENT("collapseCard3"),
        IMAGINATIVE("collapseCard4"),
        DETERMINED("collapseCard5"),
        ANALYTIC("collapseCard6");


        public String button;
        buttonsOnTheConsultancySkills(String s) {
            this.button = s;
        }
        public String getButton(){
            return button;
        }
    }

    public ConsultancySkills(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ConsultancySkills goToConsultancySkillsPage() {
        webDriver.get("http://localhost:8080/consultancy");
        return new ConsultancySkills(webDriver);
    }

    public void clickWhatTheseSkillsMakeButton() {
        webDriver.findElement(By.className("btn btn-primary text-center")).click();
    }

    public void clickBackToProfileOrDashBoardButtonOnConsultancySkills() {
        webDriver.findElement(By.className("btn btn-primary mb-3")).click();
    }

    // Card name would be the class name of that specific button for example for studios it is collapseCard1
    public void clickCollapsableButtonOnConsultancySkills(buttonsOnTheConsultancySkills buttonName) {
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonName.getButton() + "']")).click();
    }
}
