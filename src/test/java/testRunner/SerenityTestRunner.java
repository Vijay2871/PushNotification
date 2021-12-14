package testRunner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/java/features/LoyaltySignUp.feature"},
        glue = {"/steps"},
        publish = true)

public class SerenityTestRunner {
}
