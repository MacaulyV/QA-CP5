package com.brinquedos.gestaobrinquedos.uiTests.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class DeleteConfirmDialog {
    private WebDriver driver;

    public DeleteConfirmDialog(WebDriver driver) {
        this.driver = driver;
    }

    // Aceita um alert padrão de confirmação
    public void accept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}