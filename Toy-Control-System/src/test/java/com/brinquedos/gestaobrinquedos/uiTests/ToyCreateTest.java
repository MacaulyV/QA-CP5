package com.brinquedos.gestaobrinquedos.uiTests;

import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyFormModal;
import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToyCreateTest extends BaseTest {

    @Test
    void shouldCreateNewToy() {
        ToyPage page = new ToyPage(driver);
        ToyFormModal form = new ToyFormModal(driver);

        page.open();
        int before = page.countRows();

        page.clickAdd();
        form.fillForm("Teste", "Pelúcia", 5, "Médio", 123.45);
        form.submit();

        assertTrue(page.countRows() > before, "A nova linha não foi adicionada");
    }
}