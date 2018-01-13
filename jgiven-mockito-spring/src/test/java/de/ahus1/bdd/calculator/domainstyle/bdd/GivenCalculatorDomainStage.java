package de.ahus1.bdd.calculator.domainstyle.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import de.ahus1.bdd.calculator.application.CalculatorApplication;
import de.ahus1.bdd.calculator.adapter.inmemory.InMemoryCalculatorRepository;

public class GivenCalculatorDomainStage<SELF extends GivenCalculatorDomainStage<?>> extends Stage<SELF> {

    @ProvidedScenarioState
    private CalculatorApplication calculatorApplication;

    @BeforeScenario
    public void init() {
        calculatorApplication = new CalculatorApplication( new InMemoryCalculatorRepository() );

    }

    public SELF with_an_initial_state() {
        calculatorApplication.reset();
        return self();
    }

}
