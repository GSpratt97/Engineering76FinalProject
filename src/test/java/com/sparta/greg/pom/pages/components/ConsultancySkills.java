package com.sparta.greg.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class ConsultancySkills extends Page {

    public ConsultancySkills(WebDriver webDriver) {
        super(webDriver);
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

    public void clickWhatTheseSkillsMakeButton() {
        webDriver.findElement(By.cssSelector("button[class='btn btn-primary text-center']")).click();
    }

    // Card name would be the class name of that specific button for example for studios it is collapseCard1
    public void clickCollapsableButtonOnConsultancySkills(buttonsOnTheConsultancySkills buttonName) {
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonName.getButton() + "']")).click();
    }
    public void clickAllCollapsableButtonOnConsultancySkills() throws InterruptedException {
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.STUDIOUS.getButton() + "']")).click();
        Thread.sleep(65);
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.PROFESSIONAL.getButton() + "']")).click();
        Thread.sleep(65);
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.INDEPENDENT.getButton() + "']")).click();
        Thread.sleep(65);
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.IMAGINATIVE.getButton() + "']")).click();
        Thread.sleep(65);
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.DETERMINED.getButton() + "']")).click();
        Thread.sleep(65);
        webDriver.findElement(By.cssSelector("a[aria-controls=" + "'" + buttonsOnTheConsultancySkills.ANALYTIC.getButton() + "']")).click();
        Thread.sleep(65);
    }

}
