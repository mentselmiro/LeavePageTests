package pages;

import org.openqa.selenium.By;

import static config.ApplicationConfig.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteLeaveModal extends AbstractModal {

    String YES_BUTTON_XPATH = "//button[contains(text(),'Yes')]";
    String NO_BUTTON_XPATH = "//mat-dialog-container//button[contains(text(), 'No')]";
    String MODAL_XPATH = "//mat-dialog-container//h2[contains(text(), 'Delete')]";


    @Override
    public void verifyCorrectModal() {
        boolean isDisplayed = getDriver().findElement(By.xpath(MODAL_XPATH)).isDisplayed();
        assertTrue(isDisplayed);
    }

    public void clickYesButton() {
        getDriver().findElement(By.xpath(YES_BUTTON_XPATH)).click();

    }


}

