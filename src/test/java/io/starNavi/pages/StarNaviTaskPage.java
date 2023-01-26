package io.starNavi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static io.starNavi.utilities.Driver.getDriver;

public class StarNaviTaskPage extends BasePage {

    @FindBy(css = "select[class='Select_select__y1CZ9']")
    public WebElement pickModeDropDowns;

    @FindBy(tagName = "button")
    public WebElement startButton;

    @FindBy(tagName = "table")
    public WebElement table;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> listOfRows;

    @FindBy(xpath = "//div[@class='Logger_logsWrapper__ZmaZS']")
    public List<WebElement> hoverSquaresList;

    @FindBy(xpath = "//table/tbody/tr/td")
    public List<WebElement> listOfCellsInTable;

    @FindBy(xpath = "//table/tbody//tr//td")
    public WebElement oneCell;

    @FindBy(xpath = "//table/tbody/tr[1]/td")
    public List<WebElement> listOfFirstRow;

    @FindBy(xpath = "//table/tbody/tr[2]/td")
    public List<WebElement> listOfSecondRow;

    @FindBy(xpath = "//table/tbody/tr[3]/td")
    public List<WebElement> listOfThirdRow;

    @FindBy(xpath = "//table/tbody/tr[4]/td")
    public List<WebElement> listOfForthRow;

    @FindBy(xpath = "//table/tbody/tr[5]/td")
    public List<WebElement> listOfFifthRow;

    public boolean isTableSizeCorrect(int expectedSizeOfCellsPerRow) {
        boolean result = false;
        for (int i = 1; i <= listOfRows.size(); i++) {
            var path = String.format("//table/tbody/tr/td[%d]", i);
            int sizePerRow = getDriver().findElements(By.xpath(path)).size();
            if (sizePerRow == expectedSizeOfCellsPerRow) {
                result = true;
            }
        }
        return result;
    }

    public void openTable() {
        Select dropdownName = new Select(pickModeDropDowns);
        dropdownName.selectByVisibleText("Easy");
        startButton.click();
    }

    Actions action = new Actions(getDriver());

    public boolean isCellColorChangingAfterHover() {
        boolean result = false;
        String previousClassAttribute = oneCell.getAttribute("class");
        action.moveToElement(oneCell).perform();
        if (!(oneCell.getAttribute("class").equals(previousClassAttribute))) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public void moveToCertainCell(int rowNumber, int cellNumber) {
        if(rowNumber == 1) {
            action.moveToElement(listOfFirstRow.get(cellNumber)).perform();
        }else if(rowNumber == 2) {
            action.moveToElement(listOfSecondRow.get(cellNumber)).perform();
        }else if(rowNumber == 3) {
            action.moveToElement(listOfThirdRow.get(cellNumber)).perform();
        }else if(rowNumber == 4) {
            action.moveToElement(listOfForthRow.get(cellNumber)).perform();
        }else if(rowNumber == 5) {
            action.moveToElement(listOfFifthRow.get(cellNumber)).perform();
        }
    }

    public boolean isCellDisplayedInHoverSquaresList(int rowNumber, int cellNumber) {
        boolean result = false;
        String displayedText = "row " + rowNumber + " col " + (cellNumber+1);
        for (WebElement eachCell : hoverSquaresList) {
            if (eachCell.getText().equals(displayedText)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

}


