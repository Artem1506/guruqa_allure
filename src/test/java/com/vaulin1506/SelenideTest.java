package com.vaulin1506;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    String repository = "eroshenkoam/allure-example";

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".jump-to-field").setValue(repository);
        $(".jump-to-field").pressEnter();
        $(byLinkText(repository)).click();
        $(byPartialLinkText("Issue")).click();
        $(withText("#76")).click();
    }
}
