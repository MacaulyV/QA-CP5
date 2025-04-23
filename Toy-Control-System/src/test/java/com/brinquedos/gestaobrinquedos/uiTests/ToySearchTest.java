package com.brinquedos.gestaobrinquedos.uiTests;

import com.brinquedos.gestaobrinquedos.uiTests.pages.ToyPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToySearchTest extends BaseTest {

    @Test
    void shouldFindToyByName() {
        ToyPage page = new ToyPage(driver);
        page.open();

        page.search("bola");
        assertTrue(page.countRows() > 0, "Nenhum brinquedo foi encontrado para 'bola'");
    }
}