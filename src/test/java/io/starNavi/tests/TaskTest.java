package io.starNavi.tests;

import io.starNavi.pages.StarNaviTaskPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends TestBase {

    StarNaviTaskPage taskPage = new StarNaviTaskPage();
    int rowNumber = 2; // 1-5 according to the requirements
    int cellNumber = 4; // 1-5 according to the requirements

    @Test
    public void verifyingSizeOfTable() {
        Select dropdownName = new Select(taskPage.pickModeDropDowns);
        dropdownName.selectByVisibleText("Easy");
        taskPage.startButton.click();

        Assert.assertTrue(taskPage.isTableSizeCorrect(5));
    }

    @Test
    public void verifyingCellColorChanging() {
        taskPage.openTable();

        Assert.assertTrue(taskPage.isCellColorChangingAfterHover());
    }


    @Test
    public void hoverSquareListTest() {
        taskPage.openTable();
        taskPage.moveToCertainCell(rowNumber, cellNumber);

        Assert.assertTrue(taskPage.isCellDisplayedInHoverSquaresList(rowNumber, cellNumber));
    }

}
