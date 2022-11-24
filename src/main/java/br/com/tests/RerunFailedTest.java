package br.com.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = {"br/com/steps", "br/com/core"},
        plugin = { "pretty","rerun:target/rerun.txt" },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RerunFailedTest {
}