package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/java/features/LoginApp.feature"},
        glue = {"/steps"},
        publish = true)

public class TestRunner {
}
