package pt.pt.lmelgarejo.core;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


import static pt.pt.lmelgarejo.core.DriverFactory.getDriver;
import static pt.pt.lmelgarejo.core.DriverFactory.killDriver;

public class BaseTest {

    @AfterEach
    public void tearDown(TestInfo testInfo) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testInfo.getTestMethod() + ".jpg"));

        if(Properties.FECHAR_BROWSER) {
            killDriver();
        }

    }
}
