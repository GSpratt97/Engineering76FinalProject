package com.sparta.greg.pom.pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Page Object Model (POM) of 'Report Details'/'Report History' pages
 * 
 * @author NJohnston94
 */
public abstract class Report extends Page {

    //Weekly Report CSS Selectors
    By                  areaExpanded         = new By.ByCssSelector("tr[class*='accordion-toggle']");
    By                  expand               = new By.ByCssSelector("td[class*='expand']");
    By                  weekReportNumber     = new By.ByCssSelector("th[scope*='row']");

    //Weekly Report Data CSS Selectors (Bill Bird Week 12)
    By                  letterGrade          = new By.ByCssSelector("td[class*='letterGrade']");
    By                  dataBlock            = new By.ByCssSelector("div[id='collapse12']");
    By                  dataRow              = new By.ByCssSelector("div[class='row']");
    By                  startStopContinue    = new By.ByCssSelector("div[class*='col']");
    By                  commentText          = new By.ByCssSelector("div[class='col-7']");
    By                  gradeType            = new By.ByCssSelector("div[class*='col']");
    By                  gradeValue           = new By.ByCssSelector("div[class='col-6']");

    List<WebElement>    weekReports;
    List<WebElement>    letterGrades;
    List<WebElement>    traineeSSC;
    List<WebElement>    traineeGrades;
    List<WebElement>    trainerSSC;
    List<WebElement>    trainerGrades;
    String              trainerComments;
    String              deadline;
    String              lastEdited;

    /**
     * Construct POM for {@link Report} as an extension of {@link Page}
     * 
     * @param webDriver {@link WebDriver} object
     */
    public Report(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * For a given weekly report, click its 'expand' button
     * @param weekReport {@link WebElement} from weekReports
     * @return true if the button expands the weekly report, otherwise false
     */
    public boolean doesExpandButtonExpand(WebElement weekReport) {
        clickExpandButton(weekReport);

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true");
    }

    public boolean doesExpandButtonCollapse(WebElement weekReport) {
        clickExpandButton(weekReport);
        waitForClick();

        if(weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true")) {
            clickExpandButton(weekReport);
        }

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("false");
    }

    public boolean doAllExpandButtonsWork() {
        for(WebElement weekReport:getWeekReports()) {
            if(!doesExpandButtonExpand(weekReport)) {
                return false;
            } else {
                waitForClick();
                if(!doesExpandButtonCollapse(weekReport)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWeekNumberCorrect() {
        int weekNumberCurrent = weekReports.size();
        int weekNumberPrevious = weekNumberCurrent;

        for(WebElement weekReport:getWeekReports()) {
            weekNumberCurrent = Integer.parseInt(weekReport.findElement(weekReportNumber).getText().substring(5));

            if(weekNumberCurrent != (weekNumberPrevious - 1) && weekNumberCurrent != weekReports.size()) {
                return false;
            } else {
                weekNumberPrevious = weekNumberCurrent;
            }
        }

        return true;
    }

    public void clickExpandButton(WebElement weekReport) {
        weekReport.findElement(expand).click();
    }

    public void waitForClick() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Each {@link Report} page has a list of weekly reports showing grades etc.
     * Add each of those reports to a {@link List} of {@link WebElement}
     */
    public void setWeekReports() {
        this.weekReports = webDriver.findElements(By.tagName("tbody"));
    }

    /**
     * Return list of weekly reports
     * @return {@link List<WebElement>} of weekly reports
     */
    public List<WebElement> getWeekReports() {
        return weekReports;
    }

    public void setReportDataForWeek(int weekNumber) {
        setLetterGrades(weekNumber);
        setTraineeSSC(weekNumber);
        setTraineeGrades(weekNumber);
        setTrainerSSC(weekNumber);
        setTrainerGrades(weekNumber);
        setTrainerComments(weekNumber);
        setDeadline(weekNumber);
        setLastEdited(weekNumber);
    }

    public void setLetterGrades(int weekNumber) {
        WebElement weekReport = getWeekReports().get(12-weekNumber);
        this.letterGrades = weekReport.findElements(letterGrade);
    }

    public List<WebElement> getLetterGrades() {
        return letterGrades;
    }

    public String getOverallGrade() {
        if(getLetterGrades().isEmpty()) {
            System.out.println("No 'Overall Grade' element found");
            return null;
        } else {
            return getLetterGrades().get(0).getText();
        }
    }

    public String getTechnicalGrade() {
        if(getLetterGrades().isEmpty()) {
            System.out.println("No 'Technical Grade' element found");
            return null;
        } else {
            return getLetterGrades().get(1).getText();
        }
    }

    public String getConsultantGrade() {
        if(getLetterGrades().isEmpty()) {
            System.out.println("No 'Consultant Grade' element found");
            return null;
        } else {
            return getLetterGrades().get(2).getText();
        }
    }

    public void setTraineeSSC(int weekNumber) {
        this.traineeSSC = getWeekReports()
                .get(12-weekNumber)
                .findElements(dataBlock)
                .get(0)
                .findElements(dataRow);
    }

    public List<WebElement> getTraineeSSC() {
        return traineeSSC;
    }

    public String getTraineeStart() {
        for(WebElement row:getTraineeSSC()) {
            if(row.findElement(startStopContinue).getText().equals("Start")) {
                return row.findElement(commentText).getText();
            }
        }

        System.out.println("No 'Trainee Start' element found");
        return null;
    }

    public String getTraineeStop() {
        for(WebElement row:getTraineeSSC()) {
            if(row.findElement(startStopContinue).getText().equals("Stop")) {
                return row.findElement(commentText).getText();
            }
        }

        System.out.println("No 'Trainee Stop' element found");
        return null;
    }

    public String getTraineeContinue() {
        for(WebElement row:getTraineeSSC()) {
            if(row.findElement(startStopContinue).getText().equals("Continue")) {
                return row.findElement(commentText).getText();
            }
        }

        System.out.println("No 'Trainee Continue' element found");
        return null;
    }

    public void setTraineeGrades(int weekNumber) {
        this.traineeGrades = getWeekReports()
                .get(12-weekNumber)
                .findElements(dataBlock)
                .get(1)
                .findElements(dataRow);
    }

    public List<WebElement> getTraineeGrades() {
        return traineeGrades;
    }

    public String getTraineeTechnicalGrade() {
        for(WebElement row:getTraineeGrades()) {
            if(row.findElement(gradeType).getText().equals("Technical Grade")) {
                return row.findElement(gradeValue).getText();
            }
        }

        System.out.println("No 'Trainee Technical Grade' element found");
        return null;
    }

    public String getTraineeConsultantGrade() {
        for(WebElement row:getTraineeGrades()) {
            if(row.findElement(gradeType).getText().equals("Consultant Grade")) {
                return row.findElement(gradeValue).getText();
            }
        }

        System.out.println("No 'Trainee Consultant Grade' element found");
        return null;
    }

    public void setTrainerSSC(int weekNumber) {
        this.trainerSSC = getWeekReports()
                .get(12-weekNumber)
                .findElements(dataBlock)
                .get(2)
                .findElements(dataRow);
    }

    public List<WebElement> getTrainerSSC() {
        return trainerSSC;
    }

    public String getTrainerStart() {
        for(WebElement row:getTrainerSSC()) {
            if(row.findElement(startStopContinue).getText().equals("Start")) {
                return row.findElement(commentText).getText();
            }
        }

        System.out.println("No 'Trainer Start' element found");
        return null;
    }

    public String getTrainerStop() {
        for(WebElement row:getTrainerSSC()) {
            if(row.findElement(startStopContinue).getText().equals("Stop")) {
                return row.findElement(commentText).getText();
            }
        }

        System.out.println("No 'Trainer Stop' element found");
        return null;
    }

    public String getTrainerContinue() {
        for(WebElement row:getTrainerSSC()) {
            if(row.findElement(startStopContinue).getText().equals("Continue")) {
                return row.findElement(commentText).getText();
            }
        }

        System.out.println("No 'Trainer Continue' element found");
        return null;
    }

    public void setTrainerGrades(int weekNumber) {
        this.trainerGrades = getWeekReports()
                .get(12-weekNumber)
                .findElements(dataBlock)
                .get(3)
                .findElements(dataRow);
    }

    public List<WebElement> getTrainerGrades() {
        return trainerGrades;
    }

    public String getTrainerOverallGrade() {
        for(WebElement row:getTrainerGrades()) {
            if(row.findElement(gradeType).getText().equals("Overall Grade")) {
                return row.findElement(gradeValue).getText();
            }
        }

        System.out.println("No 'Trainer Overall Grade' element found");
        return null;
    }

    public String getTrainerTechnicalGrade() {
        for(WebElement row:getTrainerGrades()) {
            if(row.findElement(gradeType).getText().equals("Technical Grade")) {
                return row.findElement(gradeValue).getText();
            }
        }

        System.out.println("No 'Trainer Technical Grade' element found");
        return null;
    }

    public String getTrainerConsultantGrade() {
        for(WebElement row:getTrainerGrades()) {
            if(row.findElement(gradeType).getText().equals("Consultant Grade")) {
                return row.findElement(gradeValue).getText();
            }
        }

        System.out.println("No 'Trainer Consultant Grade' element found");
        return null;
    }

    public void setTrainerComments(int weekNumber) {
        this.trainerComments = getWeekReports()
                .get(12-weekNumber)
                .findElements(dataBlock)
                .get(4)
                .findElement(commentText)
                .getText();
    }

    public String getTrainerComments() {
        return trainerComments;
    }

    public void setDeadline(int weekNumber) {
        this.deadline = getWeekReports()
                .get(12-weekNumber)
                .findElements(dataBlock)
                .get(5)
                .findElement(commentText)
                .getText();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setLastEdited(int weekNumber) {
        this.lastEdited = getWeekReports()
                .get(12-weekNumber)
                .findElements(dataBlock)
                .get(6)
                .findElement(commentText)
                .getText();
    }

    public String getLastEdited() {
        return lastEdited;
    }
}
