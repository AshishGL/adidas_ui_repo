package com.adidas.steps;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/adidas/",

		format = { "pretty", "html:target/site/cucumber-report", "json:target/cucumber.json", })
public class RunnerTest {

}