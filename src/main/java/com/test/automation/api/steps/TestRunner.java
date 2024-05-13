package com.test.automation.api.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/features",
    glue = {"com.test.automation.api.steps"},
    plugin = {"json:target/cucumber-reports/Cucumber.json", "me.jvt.cucumber.report.PrettyReports:target"})
public class TestRunner {}
