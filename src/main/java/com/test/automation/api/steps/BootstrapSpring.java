package com.test.automation.api.steps;

import com.test.automation.api.AutomationTestingApiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = AutomationTestingApiApplication.class)
public class BootstrapSpring {}
