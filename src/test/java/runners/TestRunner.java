package runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME,
        value = "stepdefinitions"
)
@ConfigurationParameter(
        key = io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, html:build/reports/cucumber-report.html"
)
public class TestRunner {
}

