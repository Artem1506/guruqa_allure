package com.vaulin1506;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelesTest {

    @Test
    @Owner("vaulin1506")
    @DisplayName("Его любимый тест")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи")
    @Story("Просмотр задач")
    @Link(value = "Тестинг", url = "https://github.com")
    public void testAnnotated() {
    }

    @Test
    public void testCode() {
        Allure.label("Owner", "vaulin1506"); //так же как в уроке, но в отчете не отображается
        Allure.label("Severity", SeverityLevel.CRITICAL.value()); //то же что и в строке 31
        Allure.feature("Задачи");
        Allure.story("Просмотр задач");
        Allure.link("testing", "https://github.com");
    }

}
