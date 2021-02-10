package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsultancySkills extends TrainerPage{

    public ConsultancySkills(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

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

    public ConsultancySkills goToConsultancySkillsPage() {
        webDriver.get("http://localhost:8080/consultancy");
        return new ConsultancySkills(webDriver);
    }

    public void clickWhatTheseSkillsMakeButton() {
        webDriver.findElement(By.cssSelector("button[class='btn btn-primary text-center']")).click();
    }

    public void clickBackToDashBoardButtonOnConsultancySkillsTrainerLogin() {
        webDriver.findElement(By.linkText("Back To Dashboard")).click();
    }
    public void clickBackToProfileButtonOnConsultancySkillsTraineeLogin() {
        webDriver.findElement(By.linkText("Back To Profile")).click();
    }

    // Card name would be the class name of that specific button for example for studios it is collapseCard1
    public void clickCollapsableButtonOnConsultancySkills(buttonsOnTheConsultancySkills buttonName) {
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonName.getButton() + "']")).click();
    }
    public void clickAllCollapsableButtonOnConsultancySkills(){
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.STUDIOUS.getButton() + "']")).click();
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.PROFESSIONAL.getButton() + "']")).click();
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.INDEPENDENT.getButton() + "']")).click();
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.IMAGINATIVE.getButton() + "']")).click();
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.DETERMINED.getButton() + "']")).click();
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.ANALYTIC.getButton() + "']")).click();
    }

}
