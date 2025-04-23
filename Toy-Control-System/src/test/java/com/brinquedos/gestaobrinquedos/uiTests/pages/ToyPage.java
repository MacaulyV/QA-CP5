package com.brinquedos.gestaobrinquedos.uiTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ToyPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ToyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Abre a aplicação
    public void open() {
        driver.get("http://localhost:8080");
    }

    // Botões e campos
    @FindBy(id = "createBtn")
    private WebElement btnAdd;

    @FindBy(id = "searchInput")
    private WebElement inputSearch;

    @FindBy(id = "viewBtn")
    private WebElement btnView;

    @FindBy(id = "backBtn")
    private WebElement btnBack;

    @FindBy(css = "#brinquedosTable tbody tr")
    private List<WebElement> rows;

    // Ações
    public void clickAdd() {
        btnAdd.click();
    }

    public void search(String name) {
        inputSearch.clear();
        inputSearch.sendKeys(name);
        btnView.click();
        wait.withTimeout(Duration.ofSeconds(5));
    }

    public void clickBack() {
        btnBack.click();
    }

    public int countRows() {
        return rows.size();
    }

    public List<WebElement> getRows() {
        return rows;
    }

    public WebElement getEditButton(WebElement row) {
        return row.findElement(By.cssSelector("button.edit-btn"));
    }

    public WebElement getDeleteButton(WebElement row) {
        return row.findElement(By.cssSelector("button.delete-btn"));
    }

    public void clickEdit(WebElement row) {
        getEditButton(row).click();
    }

    public void clickDelete(WebElement row) {
        getDeleteButton(row).click();
    }
}