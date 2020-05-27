package pages;

import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static config.ApplicationConfig.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditLeaveModal extends AbstractModal {

    String SAVE_BUTTON_XPATH = "//mat-dialog-container//button[contains(text(), 'Save')]";
    String CANCEL_BUTTON_XPATH = "//mat-dialog-container//button[contains(text(), 'Cancel')]";
    String MODAL_XPATH = "//mat-dialog-container//h2/span[contains(text(), 'Edit')]";
    String FROM_FIELD_ID = "fromDate";
    String TO_FIELD_ID = "toDate";
    String DAYS_XPATH = "//div[contains(text(),'Days:')]";
    String DAYS_OFF_XPATH = "//div[contains(text(),'Days off:')]";
    String FROM_CALENDAR = "//div[@class='col'][1]//button[@class='mat-icon-button']";
    String TO_CALENDAR = "//div[@class='col'][2]//button[@class='mat-icon-button']";


    @Override
    public void verifyCorrectModal() {
        boolean isDisplayed = getDriver().findElement(By.xpath(MODAL_XPATH)).isDisplayed();
        assertTrue(isDisplayed);
    }

    public void clickSaveButton() {
        getDriver().findElement(By.xpath(SAVE_BUTTON_XPATH)).click();

    }

    public boolean isFromFieldVisible() {
        return getDriver().findElement(By.id(FROM_FIELD_ID)).isDisplayed();
    }

    public boolean isToFieldVisible() {
        return getDriver().findElement(By.id(TO_FIELD_ID)).isDisplayed();
    }

    public boolean isFromCalendarVisible() {
        return getDriver().findElement(By.xpath(FROM_CALENDAR)).isDisplayed();
    }

    public boolean isToCalendarVisible() {
        return getDriver().findElement(By.xpath(TO_CALENDAR)).isDisplayed();
    }

    public boolean areDaysVisible() {
        return getDriver().findElement(By.xpath(DAYS_XPATH)).isDisplayed();
    }

    public boolean isSaveButtonVisible(){return getDriver().findElement(By.xpath(SAVE_BUTTON_XPATH)).isDisplayed();}

    public String isDaysOne() {
        return getDriver().findElement(By.xpath(DAYS_XPATH)).getText();
    }

    public String isDaysOffOne() {
        return getDriver().findElement(By.xpath(DAYS_OFF_XPATH)).getText();
    }

    public boolean areDateOffVisible() {
        return getDriver().findElement(By.xpath(DAYS_OFF_XPATH)).isDisplayed();
    }


    public boolean isCancelButtonVisible() {
        return getDriver().findElement(By.xpath(CANCEL_BUTTON_XPATH)).isDisplayed();
    }


    public void clickCancelButton() {
        getDriver().findElement(By.xpath(CANCEL_BUTTON_XPATH)).click();
    }

    public String currentDate() {
        String pattern = "M/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;

    }

    public String fromDate() {
        String fromDate = getDriver().findElement(By.id(FROM_FIELD_ID)).getAttribute("value");
        return fromDate;
    }

    public String toDate() {
        String toDates = getDriver().findElement(By.id(TO_FIELD_ID)).getAttribute("value");
        return toDates;
    }

}

