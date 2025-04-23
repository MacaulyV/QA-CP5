package com.brinquedos.gestaobrinquedos.uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToyFormModal {
    public ToyFormModal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nome")
    private WebElement nomeField;

    @FindBy(id = "tipo")
    private WebElement tipoSelect;

    @FindBy(id = "classificacao")
    private WebElement classificacaoField;

    @FindBy(id = "tamanho")
    private WebElement tamanhoSelect;

    @FindBy(id = "preco")
    private WebElement precoField;

    @FindBy(css = "button.submit-btn")
    private WebElement btnSave;

    public void fillForm(String nome, String tipo, int classificacao, String tamanho, double preco) {
        nomeField.clear();
        nomeField.sendKeys(nome);
        tipoSelect.sendKeys(tipo);
        classificacaoField.clear();
        classificacaoField.sendKeys(String.valueOf(classificacao));
        tamanhoSelect.sendKeys(tamanho);
        precoField.clear();
        precoField.sendKeys(String.valueOf(preco));
    }

    public void submit() {
        btnSave.click();
    }
}