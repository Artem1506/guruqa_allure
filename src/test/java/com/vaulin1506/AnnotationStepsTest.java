package com.vaulin1506;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTest {
    String repository = "eroshenkoam/allure-example";

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.ckickOnRepositoryLink(repository);
        steps.openIssueTab();
        steps.shouldIssueNumber();


    }
}
