package ru.javaAppium.iosTests;

import ru.javaAppium.lib.CoreTestCase;
import org.junit.jupiter.api.Test;

public class IOSExamplesTest extends CoreTestCase {

    @Test
    public void testCheckSearchInput(){
        searchPage.clickSearchInput();
        searchPage.typeIntoSearchInput("Java");
        searchPage.waitForSearchResult("Object-oriented programming language");
    }
}
