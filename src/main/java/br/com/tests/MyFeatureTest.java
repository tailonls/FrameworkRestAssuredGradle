package br.com.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags = "@teste",
        glue = {"br/com/steps", "br/com/core"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "rerun:target/rerun.txt"}
)
public class MyFeatureTest {
}