package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static config.ApplicationConfig.getDriver;

public class LeavesTable extends Table {

    String TABLE_XPATH = "//app-leaves//table";
    String ROW_XPATH = "//app-leaves//table//tr";
    String TABLE_HEADER_XPATH = "//app-leaves//table//th";

    public List<String> getTableHeaders(){
        List<WebElement>headers = getDriver().findElements(By.xpath(TABLE_HEADER_XPATH));
        List<String> headerNames = new ArrayList<>();
        for (WebElement header:headers){
            headerNames.add(header.getText());
        }
        return headerNames;
    }

    @Override
    public WebElement getTableCell(String columnName, int rowNumber) {
        List<WebElement> headers = getDriver().findElements(By.xpath(TABLE_HEADER_XPATH));
        int headerIndex = 0;
        for (WebElement header : headers) {
            if (columnName.equals(header.getText())) {
                headerIndex = headers.indexOf(header);
                break;
            }
        }

        return getDriver().findElement(By.xpath(ROW_XPATH +
                "[" + (rowNumber + 1) + "]" + "//td[" + (headerIndex + 1) + "]"));
    }

    @Override
    public int getRowsNumber() {
        return getDriver().findElements(By.xpath(ROW_XPATH)).size() - 1;
    }
}
