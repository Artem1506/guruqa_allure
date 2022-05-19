package com.vaulin1506;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step ("открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step ("ищем репозиторий {repo}")
    public void searchForRepository(String repo){
        $(".jump-to-field").setValue(repo);
        $(".jump-to-field").pressEnter();
    }
    @Step ("переходим по ссылке {repo}")
    public void ckickOnRepositoryLink(String repo){
        $(byLinkText(repo)).click();
    }
    @Step ("кликаем таб issue")
    public void openIssueTab(){
        $(byPartialLinkText("Issue")).click();
    }
    @Step ("ищем Issue #77")
    public void shouldIssueNumber(){
        $(withText("#77")).click();
        attachScreenshot();
    }
    @Attachment(value = "shoot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);}
}
