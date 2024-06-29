package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pages.AlertPage;
import support.WebSetup;

public class AlertsTest {

    WebSetup webSetup = new WebSetup();

    AlertPage alertPage = new AlertPage(webSetup.getDriver());

    @Before
    public void setup() {
        alertPage.open();
    }

    @Test
    public void testSimpleAlert() {
        alertPage.clickSimpleAlertButton();
        assertEquals(alertPage.getAlertText(), "Hey! Welcome to LetCode");
        alertPage.acceptAlert();
        alertPage.close();
    }

    @Test
    public void testConfirmAlert() {
        alertPage.clickConfirmAlertButton();
        assertEquals(alertPage.getAlertText(), "Are you happy with LetCode?");
        alertPage.dismissAlert();
        alertPage.close();
    }

    @Test
    public void testPromptAlert() {
        alertPage.clickPromptAlertButton();
        assertEquals(alertPage.getAlertText(), "Enter your name");
        alertPage.sendTextToAlert("LetCode");
        alertPage.acceptAlert();
        System.out.println(alertPage.getTextInputFromAlertPrompt());
        assertEquals(alertPage.getTextInputFromAlertPrompt(), "Your name is: LetCode");
        alertPage.close();
    }

    @Test
    public void testModernAlert() {
        alertPage.clickModernAlert();
        assertTrue(alertPage.getModernAlertText()
                .contains("Modern Alert - Some people address me as sweet alert as well"));
        alertPage.modalClose();
        alertPage.close();
    }
}