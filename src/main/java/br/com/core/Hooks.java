package br.com.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class Hooks {

    @Autowired
    private ReportGenerator reportGenerator;

    @Before
    public void startScenario(Scenario scenario) {
        log.debug("Starting scenario - {}", scenario.getName());
        reportGenerator.addScenarioInReport(scenario);
    }

    @After
    public void closeScenario(Scenario scenario) {
        log.debug("Close scenario - {}", scenario.getName());
        if (scenario.isFailed()) {
            log.warn("The scenario failed!");
            reportGenerator.logFail("O cenário falhou!");
        }
    }
}
