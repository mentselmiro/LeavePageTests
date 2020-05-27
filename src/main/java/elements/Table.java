package elements;

import org.openqa.selenium.WebElement;

public abstract class Table {

    public abstract int getRowsNumber();

    public abstract WebElement getTableCell(String columnName, int rowNumber);
}
