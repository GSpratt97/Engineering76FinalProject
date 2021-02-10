package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.WebDriver;

public class TraineeChangePassword extends ChangePassword {

    public SideBarTrainee getSideBarTrainee() {
        return sideBarTrainee;
    }

    private final SideBarTrainee sideBarTrainee;

    public TraineeChangePassword(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainee = new SideBarTrainee(webDriver);
    }

    public HomeTrainee traineeChangePassword(String oldPassword, String newPassword) {
        enterOldPassword(oldPassword);
        enterNewPassword(newPassword);
//        clickSubmitButton();
        return new HomeTrainee(webDriver);
    }
}
