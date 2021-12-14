package steps;

import api.application.PushApi;
import api.application.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.Error;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;

public class InvalidSubscriptionKeySteps {
Response response;
Error error;
    @Given("I Login to Red Application")
    public void i_login_to_red_app() throws FileNotFoundException, InterruptedException {
     response = PushApi.getInvalidOcpKey();
    }

    @Given("I register a customer with invalid Ocp-Apim-Subscription-Key")
    public void i_register_a_customer_with_invalid_ocp_apim_subscription_key() {

         error=response.as(Error.class);
         assertThat(error.getStatusCode(),equalTo(StatusCode.STATUS_CODE_401.getCode()));
    }


    @Then("I see the Error message")
    public void i_see_the_error_message() {
        assertThat(error.getMessage(),equalTo(StatusCode.STATUS_CODE_401.getstatus()));

    }

}
