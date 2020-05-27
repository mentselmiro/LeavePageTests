package pages;

import elements.LeavesTable;
import elements.NotificationMessage;
import org.openqa.selenium.By;

import static config.ApplicationConfig.getDriver;

public class PersonalLeavesPage {

    String ADD_BUTTON_XPATH = "//button[@class='btn btn-primary']";
    String TITLE = "//h2[contains(text(),'Personal leaves')]";
    public static String  TITLE_TEXT = "Personal leaves";
    String REMAINING_DAYS_XPATH = "//div[contains(text(),'Remaining')]/strong";
    String EDIT_BUTTON_XPATH = "//tr[2]//td[6]//button[1]";
    String REQUEST_BUTTON_PATH ="//tr[2]//td[6]//button[2]";
    String DELETE_BUTTON_XPATH = "//tr[2]//td[6]//button[3]";
    String NO_PLANNED_LEAVES = "//tr[2]/td[1][text()='No planned leaves']";
    String NO_TEAM_LEAVES = "//h3[contains(text(),'Leaves of teammates')]";



    NotificationMessage notifyMessage = new NotificationMessage();


    LeavesTable leavesTable = new LeavesTable();

    public String getTitle() {
        return getDriver().findElement(By.xpath(TITLE)).getText();

    }
    public boolean isAddButtonDisplayed(){
        return getDriver().findElement(By.xpath(ADD_BUTTON_XPATH)).isDisplayed();
    }
    public void clickAddButton(){
        getDriver().findElement(By.xpath(ADD_BUTTON_XPATH)).click();

    }

    public LeavesTable getLeavesTable() {
        return leavesTable;
    }

    public int getRemainingDays() {
        String remainingDays = getDriver().findElement(By.xpath(REMAINING_DAYS_XPATH)).getText();
        return Integer.valueOf(remainingDays);
    }

    public NotificationMessage getNotifyMessage() {
        try {
            notifyMessage.getAlertText();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return notifyMessage;
    }
//    public boolean isDeleteButtonVisible() throws InterruptedException {
//       WebElement deleteButton = getDriver().findElement(By.xpath(DELETE_BUTTON_XPATH));
//       return deleteButton != null && getDriver().findElement(By.xpath(DELETE_BUTTON_XPATH)).isDisplayed();
//
//    }
    public void clickDeleteButton() throws InterruptedException {

        getDriver().findElement(By.xpath(DELETE_BUTTON_XPATH)).click();
        Thread.sleep(1000);
    }
    public boolean isTableEmpty(){
        return getDriver().findElements(By.xpath(NO_PLANNED_LEAVES)).size()==1;
    }

    public String getTeamLeavesText(){
        return getDriver().findElement(By.xpath(NO_TEAM_LEAVES)).getText();
    }

    public String getNoTeamLeaves() {
        return getTeamLeavesText();
    }

    public void clickEditButton(){
        getDriver().findElement(By.xpath(EDIT_BUTTON_XPATH)).click();
    }

}




