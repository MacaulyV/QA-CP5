package com.brinquedos.gestaobrinquedos.uiTests;

import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyFormModal;
import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToyEditTest extends BaseTest {

    @Test
    void shouldEditFirstToy() {
        ToyPage page = new ToyPage(driver);
        ToyFormModal form = new ToyFormModal(driver);

        page.open();
        WebElement firstRow = page.getRows().get(0);

        page.clickEdit(firstRow);
        form.fillForm("Editado", "Música", 3, "Pequeno", 99.99);
        form.submit();

        // Opcional: validar que o nome na célula foi atualizado
        assertTrue(page.getRows().get(0).getText().contains("Editado"), "O brinquedo não foi editado");
    }
}