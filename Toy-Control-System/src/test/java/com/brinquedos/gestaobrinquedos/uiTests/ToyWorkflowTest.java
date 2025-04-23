package com.brinquedos.gestaobrinquedos.uiTests;

import com.brinquedos.gestaobrinquedos.uiTests.pages.DeleteConfirmDialog;
import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyFormModal;
import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class ToyWorkflowTest extends BaseTest {
    @Test
    void fullCRUDFlow() {
        ToyPage page = new ToyPage(driver);
        ToyFormModal form = new ToyFormModal(driver);
        DeleteConfirmDialog confirm = new DeleteConfirmDialog(driver);

        page.open();
        int initial = page.countRows();

        // Create
        page.clickAdd();
        form.fillForm("Fluxo", "Jogos", 2, "Grande", 55.55);
        form.submit();
        // Fecha o modal de criação
        page.clickBack();
        assertEquals(initial + 1, page.countRows(), "Falha ao criar");
        assertEquals(initial + 1, page.countRows(), "Falha ao criar");

        // Read/Search
        page.search("Fluxo");
        assertTrue(page.countRows() > 0, "Falha ao buscar");

        // Update
        WebElement row = page.getRows().get(0);
        page.clickEdit(row);
        form.fillForm("FluxoEdit", "Educação", 4, "Pequeno", 66.66);
        form.submit();
        // Fecha o modal de edição
        page.clickBack();
        assertTrue(page.getRows().get(0).getText().contains("FluxoEdit"), "Falha ao editar");
        assertTrue(page.getRows().get(0).getText().contains("FluxoEdit"), "Falha ao editar");

        // Delete
        page.clickDelete(page.getRows().get(0));
        confirm.accept();
        assertEquals(initial, page.countRows(), "Falha ao deletar");
    }
}