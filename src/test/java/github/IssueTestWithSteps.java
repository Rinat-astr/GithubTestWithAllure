package github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static github.IssueTests.issue_name;


@Owner("Rinat")
@Feature("Создание Issue with Steps")
public class IssueTestWithSteps {

    private static final String BASE_URL = "https://github.com";

    private final BasicSteps steps = new BasicSteps();

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @AfterEach
    public void signOut() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Создание Issue и его проверка через Steps")
    public void createIssueWithSteps (){
        steps.openMainPage();
        steps.signInGithub();
        steps.createIssue(issue_name);
        steps.checkIssueByName(issue_name);
    }
}