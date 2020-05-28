package tests;

import constants.NotificationTexts;
import constants.TeamLeavesText;
import elements.LeavesTable;
import enums.LeaveTableColumn;
import org.junit.jupiter.api.*;
import pages.AddLeaveModal;
import pages.EditLeaveModal;
import pages.PersonalLeavesPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSuite1 extends BaseTest {

    @Test
    @Order(1)
    public void checkElementsOnScreen(){
    PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        LeavesTable spreadsheet = new LeavesTable();
        List<String> tableHeaders = spreadsheet.getTableHeaders();
        for (LeaveTableColumn column : LeaveTableColumn.values()) {
            assertTrue(tableHeaders.contains(column.getName()));
        }

        LeavesTable teamText = new LeavesTable();
        assertEquals(true,personalLeavesPage.getTeamLeavesText().contains(TeamLeavesText.TEAM_LEAVES_TEXT));
        assertTrue(personalLeavesPage.isAddButtonDisplayed());
    }

    @Test
    @Order(2)
    public void checkElementsOnAddDateModal() throws InterruptedException {
        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        personalLeavesPage.clickAddButton();
        Thread.sleep(500);
        AddLeaveModal addLeaveModal = new AddLeaveModal();
        addLeaveModal.verifyCorrectModal();
        assertTrue(addLeaveModal.isAddButtonVisible());
        assertTrue(addLeaveModal.isCancelButtonVisible());
        assertTrue(addLeaveModal.isToFieldVisible());
        assertTrue(addLeaveModal.isFromFieldVisible());
        assertTrue(addLeaveModal.isToCalendarVisible());
        assertTrue(addLeaveModal.isFromCalendarVisible());
        assertTrue(addLeaveModal.areDaysVisible());
        assertTrue(addLeaveModal.areDateOffVisible());
        assertEquals(addLeaveModal.currentDate(), addLeaveModal.toDate());
        assertEquals(addLeaveModal.currentDate(),addLeaveModal.fromDate());
        assertEquals(addLeaveModal.isDaysOne(),"Days: 1");
        assertEquals(addLeaveModal.isDaysOffOne(),"Days off: 1");
        addLeaveModal.clickCancelButton();
    }

    @Test
    @Order(3)
    public void addNewDraftLeave() throws InterruptedException {

        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        int initialRemainingDays = personalLeavesPage.getRemainingDays();//This takes the remaining days value

        personalLeavesPage.clickAddButton();
        AddLeaveModal addLeaveModal = new AddLeaveModal();
        addLeaveModal.verifyCorrectModal(); //validates the Add modal
        addLeaveModal.clickAddButton();
        Thread.sleep(500);
        assertEquals( true,personalLeavesPage
                .getNotifyMessage().getAlertText().contains(NotificationTexts.SUCCESS_ALERT));

        assertEquals(1, personalLeavesPage.getLeavesTable().getRowsNumber());
        String status = personalLeavesPage.getLeavesTable()
                .getTableCell(LeaveTableColumn.STATUS.getName(), 1).getText();
        assertEquals("Draft", status);


        int newRemainingDays = personalLeavesPage.getRemainingDays(); //This counts the days next to "Remaining: "
        assertEquals(initialRemainingDays , newRemainingDays);

    }
    @Test
    @Order(4)
    public void checkAllElementsOnEditDateModal() throws InterruptedException {
        Thread.sleep(1000);
        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        personalLeavesPage.clickEditButton();
        EditLeaveModal editLeaveModal = new EditLeaveModal();
        editLeaveModal.verifyCorrectModal();
        assertTrue(editLeaveModal.isSaveButtonVisible());
        assertTrue(editLeaveModal.isCancelButtonVisible());
        assertTrue(editLeaveModal.isFromCalendarVisible());
        assertTrue(editLeaveModal.isToFieldVisible());
        assertTrue(editLeaveModal.isFromCalendarVisible());
        assertTrue(editLeaveModal.isToCalendarVisible());
        assertTrue(editLeaveModal.areDaysVisible());
        assertTrue(editLeaveModal.areDateOffVisible());
        assertEquals(editLeaveModal.currentDate(), editLeaveModal.toDate());
        assertEquals(editLeaveModal.currentDate(),editLeaveModal.fromDate());
        assertEquals(editLeaveModal.isDaysOne(),"Days: 1");
        assertEquals(editLeaveModal.isDaysOffOne(),"Days off: 1");
        editLeaveModal.clickSaveButton();
    }

}
