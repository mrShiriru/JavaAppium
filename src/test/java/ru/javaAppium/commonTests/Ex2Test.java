package ru.javaAppium.commonTests;

import ru.javaAppium.lib.CoreTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ex2Test extends CoreTestCase {
    /**
     * Необходимо написать функцию, которая проверяет наличие ожидаемого текста у элемента. Предлагается назвать ее
     * assertElementHasText. На вход эта функция должна принимать локатор элемент, ожидаемый текст и текст ошибки,
     * который будет написан в случае, если элемент по этому локатору не содержит текст, который мы ожидаем.
     *
     * Также, необходимо написать тест, который проверяет, что поле ввода для поиска статьи содержит текст (в разных
     * версиях приложения это могут быть тексты "Search..." или "Search Wikipedia", правильным вариантом следует считать
     * тот, которые есть сейчас). Очевидно, что тест должен использовать написанный ранее метод.
     *
     * Результат выполнения задания нужно отдельным коммитом положить в git. В качестве ответа прислать ссылку на
     * коммит. Если вам потребовалось несколько коммитов для выполнения одного задания - присылайте ссылки на все эти
     * коммиты с комментариями.
     */
    @Test
    public void testEx2_CreateMethod (){

        String actualText = searchPage.getSearchInputText();
        Assertions.assertEquals("Search Wikipedia", actualText, "Expected text not found");
    }


}
