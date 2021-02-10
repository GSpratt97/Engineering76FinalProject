package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.WebDriver;

public class TrainerChangePassword extends ChangePassword {

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    private final SideBarTrainer sideBarTrainer;

    public TrainerChangePassword(WebDriver webDriver) {
        super(webDriver);
        this.sideBarTrainer = new SideBarTrainer(webDriver);
    }

    public HomeTrainer trainerChangePassword(String oldPassword, String newPassword) {
        enterOldPassword(oldPassword);
        enterNewPassword(newPassword);
//        clickSubmitButton();
        return new HomeTrainer(webDriver);
    }

}
