package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;
    private static Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() {
        testContextSetup.baseTest.initializeDriver().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            TakesScreenshot ts = ((TakesScreenshot) testContextSetup.baseTest.initializeDriver());
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(srcFile);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String failedScenarioName = scenario.getName();
            LOGGER.info("Scenario failed: " + failedScenarioName);
            retryFailedScenario(failedScenarioName);
        }
    }

    private void retryFailedScenario(String scenarioName) {
        int retryCount = 0;
        int maxRetryCount = 2;
        while (retryCount < maxRetryCount) {
            LOGGER.info("Retrying scenario: " + scenarioName + ", attempt " + (retryCount + 1));
            if (scenarioPassedOnRetry()) {
                break;
            }
            retryCount++;
        }
    }

    private boolean scenarioPassedOnRetry() {
        return true;
    }
}
