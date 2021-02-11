package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClassManagement extends Page {

	By selectTrainee = By.id("traineeId");
	By selectClass = By.id("groupId");
	By assignTraineeButton = By.cssSelector("form.form-signin:nth-child(1) button");

	By className = By.id("groupName");
	By selectCourse = By.id("courseId");
	By startDate = By.id("startDate");
	By endDate = By.id("endDate");
	By createClassButton = By.cssSelector("form.form-signin:nth-child(2) button");

	By successMessage = By.cssSelector("p.letterGradeA");
	By errorMessage = By.cssSelector("p.letterGradeF");

	private final SideBarTrainer sideBarTrainer;

	public ClassManagement(WebDriver webDriver){
		super(webDriver);
		sideBarTrainer = new SideBarTrainer(webDriver);
	}

	public SideBarTrainer getSideBarTrainer(){
		return sideBarTrainer;
	}

	public Select getSelectTrainee(){
		return new Select(webDriver.findElement(selectTrainee));
	}

	public void selectTrainee(String trainee){
		getSelectTrainee().selectByVisibleText(trainee);
	}

	public Select getSelectClass(){
		return new Select(webDriver.findElement(selectClass));
	}

	public void selectClass(String className){
		getSelectClass().selectByVisibleText(className);
	}

	public WebElement getAssignTraineeButton(){
		return webDriver.findElement(assignTraineeButton);
	}

	public void clickAssignTrainee(){
		getAssignTraineeButton().click();
	}

	public WebElement getClassName(){
		return webDriver.findElement(className);
	}

	public void enterClassName(String className){
		getClassName().sendKeys(className);
	}

	public Select getSelectCourse(){
		return new Select(webDriver.findElement(selectCourse));
	}

	public void selectCourse(String courseName){
		getSelectCourse().selectByVisibleText(courseName);
	}

	public WebElement getStartDate(){
		return webDriver.findElement(startDate);
	}

	public void enterStartDate(String day, String month, String year, String hour, String minute){
		getStartDate().sendKeys(day, month, year, Keys.ARROW_RIGHT, hour, minute);
	}

	public WebElement getEndDate(){
		return webDriver.findElement(endDate);
	}

	public void enterEndDate(String day, String month, String year, String hour, String minute){
		getEndDate().sendKeys(day, month, year, Keys.ARROW_RIGHT, hour, minute);
	}

	public WebElement getCreateClass(){
		return webDriver.findElement(createClassButton);
	}

	public void clickCreateClass(){
		getCreateClass().click();
	}

	public WebElement getSuccessMessage(){
		return webDriver.findElement(successMessage);
	}

	public WebElement getErrorMessage(){
		return webDriver.findElement(errorMessage);
	}
}
