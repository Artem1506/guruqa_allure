package com.vaulin1506;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {
    String repository = "eroshenkoam/allure-example";

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("ищем репозиторий " + repository, () -> {
            $(".jump-to-field").setValue(repository);
            $(".jump-to-field").pressEnter();
        });
        step("переходим по ссылке " + repository, () -> {
            $(byLinkText(repository)).click();
        });
        step("кликаем таб issue", () -> {
            $(byPartialLinkText("Issue")).click();
        });
        step("ищем Issue #76", () -> {
            $(withText("#76")).click();
            Allure.getLifecycle().addAttachment(
                    "Исходники",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });


    }
}
