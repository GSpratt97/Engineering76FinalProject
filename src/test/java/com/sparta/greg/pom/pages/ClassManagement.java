package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClassManagement {
	WebDriver webDriver;
	By selectTrainee = By.id("traineeId");
	By selectClass = By.id("groupId");
	By assignTraineeButton = By.cssSelector("form.form-signin:nth-child(1) button");

	public ClassManagement(WebDriver webDriver){
		this.webDriver = webDriver;
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



}
