package com.alfresco.site.steps;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/alfresco/",
//tags = { "@Like" },
// dryRun=true,
//				glue= "src/test/java/com.alfresco.steps.site",
		format = { "pretty", "html:target/site/cucumber-report", "json:target/cucumber.json", })
public class RunnerTest {

}