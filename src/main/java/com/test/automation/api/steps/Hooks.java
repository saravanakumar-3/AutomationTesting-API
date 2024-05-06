package com.test.automation.api.steps;

import io.cucumber.java.Before;

public class Hooks extends BaseStepDef {
  @Before
  public void beforeScenario() {
    response = null;
  }
}
