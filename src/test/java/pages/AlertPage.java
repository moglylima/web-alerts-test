package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {
    private By simpleAlertButton = By.id("accept");
    private By confirmAlertButton = By.id("confirm");
    private By promptAlertButton = By.id("prompt");
    private By modernAlert = By.id("modern");
    private By textInputAlertPronpt = By.id("myName");
    private By modalModernAlert = By
            .xpath("/html/body/app-root/app-alert/section[1]/div/div/div[1]/div/div/div[5]/div[2]");

    private By closeModalBtn = By.className("modal-close");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public AlertPage open() {
        openUrl("https://letcode.in/alert");
        return this;
    }

    public void clickSimpleAlertButton() {
        driver.findElement(simpleAlertButton).click();
    }

    public void clickConfirmAlertButton() {
        driver.findElement(confirmAlertButton).click();
    }

    public void clickPromptAlertButton() {
        driver.findElement(promptAlertButton).click();
    }

    public void clickModernAlert() {
        driver.findElement(modernAlert).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public String getModernAlertText() {
        return driver.findElement(modalModernAlert).getText();
    }

    public String getTextInputFromAlertPrompt() {
        return driver.findElement(textInputAlertPronpt).getText();
    }

    public void modalClose() {
        driver.findElement(closeModalBtn).click();
    }

}
