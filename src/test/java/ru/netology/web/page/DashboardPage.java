package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private static SelenideElement heading = $("[data-test-id=dashboard]");

    private SelenideElement card1Button = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']>[data-test-id='action-deposit']");
    private SelenideElement card2Button = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']>[data-test-id='action-deposit']");
    private SelenideElement balanceCard1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement balanceCard2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public void dashboardPageVisible() {
        heading.shouldBe(Condition.visible);
    }

    public MoneyTransfer topUpCard1() {
        card1Button.click();
        return new MoneyTransfer();
    }

    public MoneyTransfer topUpCard2() {
        card2Button.click();
        return new MoneyTransfer();
    }

    public Integer getBalanceCard1() {
        String text = balanceCard1.getText();
        String[] subtext = text.split(":");
        String balance = subtext[1].substring(0, subtext[1].indexOf("p.")).trim();
        return Integer.parseInt(balance);
    }

    public Integer getBalanceCard2() {
        String text = balanceCard2.getText();
        String[] subtext = text.split(":");
        String balance = subtext[1].substring(0, subtext[1].indexOf("p.")).trim();
        return Integer.parseInt(balance);
    }
}
