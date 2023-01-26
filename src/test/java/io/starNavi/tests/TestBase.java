package io.starNavi.tests;

import io.starNavi.utilities.ConfigurationReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.starNavi.utilities.Driver.closeDriver;
import static io.starNavi.utilities.Driver.getDriver;

public abstract class TestBase {

    @BeforeTest
    public void setupMethod() {
        getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }

}
