package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.templates.ChangePassword;
import com.sparta.greg.pom.pages.fragments.SideBarTrainee;
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

    public HomeTrainee changePassword(String oldPassword, String newPassword) {
        enterOldPassword(oldPassword);
        enterNewPassword(newPassword);
//        clickSubmitButton();
        return new HomeTrainee(webDriver);
    }
}
