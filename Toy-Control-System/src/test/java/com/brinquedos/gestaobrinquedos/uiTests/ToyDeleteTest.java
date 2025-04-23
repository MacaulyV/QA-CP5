package com.brinquedos.gestaobrinquedos.uiTests;

import com.brinquedos.gestaobrinquedos.uiTests.pages.DeleteConfirmDialog;
import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyDeleteTest extends BaseTest {

    @Test
    void shouldDeleteFirstToy() {
        ToyPage page = new ToyPage(driver);
        DeleteConfirmDialog confirm = new DeleteConfirmDialog(driver);

        page.open();
        int before = page.countRows();
        WebElement firstRow = page.getRows().get(0);

        page.clickDelete(firstRow);
        confirm.accept();

        assertEquals(before - 1, page.countRows(), "A linha não foi removida");
    }
}