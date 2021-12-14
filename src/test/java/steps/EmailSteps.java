package steps;

import Utils.FakeData;
import api.application.BodyRefactor;
import api.application.PostGreConfig;
import api.application.PushApi;
import api.application.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.ErrorNotification;
import pojo.PushBody;
import pojo.UnauthorisedError;

import java.io.FileNotFoundException;
import java.sql.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EmailSteps {
    Response response;
    String Status=FakeData.generateStatus();
    String Duplicate_email = FakeData.generateDuplicateEmail();
    String email = FakeData.generateEmailAddress();
    String firebasetoken = FakeData.generateCustomerId();
    PushBody requestPush;

    @Given("I have email and firebaseToken")
    public void i_have_email_and_firebase_token() throws FileNotFoundException {

        requestPush= BodyRefactor.getEmailBuilder(email,firebasetoken);
    }
    @Given("I have duplicate email and firebaseToken")
    public void i_have_duplicate_email_and_firebase_token() {

        requestPush= BodyRefactor.getEmailBuilder(Duplicate_email,firebasetoken);
    }

    @Given("I have null email and firebaseToken")
    public void i_have_null_email_and_firebase_token() {

        requestPush=BodyRefactor.getEmailBuilder("",firebasetoken);
    }

    @Given("I have  email and null firebaseToken")
    public void i_have_email_and_null_firebase_token() {

        requestPush=BodyRefactor.getEmailBuilder(email,"");

    }
    @When("I hit POST")
    public void i_hit_post() throws FileNotFoundException {

        response = PushApi.post(requestPush);
    }

    @When("I hit POST with invalid Ocp-Apim-Subscription-Key")
    public void i_hit_post_with_invalid_ocp_apim_subscription_key() throws FileNotFoundException {

        response= PushApi.postInvalidOcp(requestPush);
    }

    @Then("I get a successful Response")
    public void i_get_a_successful_response() {

        assertThat(response.statusCode(), equalTo(204));
    }

    @Then("I get a error code for email")
    public void i_get_a_error_code_for_email() {

        assertThat(response.as(ErrorNotification.class).getErrorCode(), equalTo(StatusCode.STATUS_CODE_Email_400.getCode()));
    }

    @Then("I get a error code for token")
    public void i_get_a_error_code_for_token() {

        assertThat(response.as(ErrorNotification.class).getErrorCode(), equalTo(StatusCode.STATUS_CODE_Token_400.getCode()));

    }

    @Then("I get a error Response")
    public void i_get_a_error_response() {

        assertThat(response.as(ErrorNotification.class).getErrorCode(), equalTo(400));
    }

    @Then("I get a error message as access denied")
    public void i_get_a_error_message_as_access_denied() {

        assertThat(response.as(UnauthorisedError.class).getStatusCode(), equalTo(StatusCode.STATUS_CODE_UnauthorisedKey_401.getCode()));

    }
    @Then("I get a Unauthorised Response")
    public void i_get_a_unauthorised_response() {

        assertThat(response.as(UnauthorisedError.class).getMessage(), equalTo(StatusCode.STATUS_CODE_UnauthorisedKey_401.getstatus()));

    }

    @Then("I get a error message as Invalid email")
    public void i_get_a_error_message_as_invalid_email() {

        assertThat(response.as(ErrorNotification.class).getErrorMessage(), equalTo(StatusCode.STATUS_CODE_Email_400.getstatus()));
    }
    @Then("I get a error Response as Invalid Firebase Token")
    public void i_get_a_error_response_as_invalid_firebase_token() {

        assertThat(response.as(ErrorNotification.class).getErrorMessage(), equalTo(StatusCode.STATUS_CODE_Token_400.getstatus()));
    }

    @Then("the database is populated correctly")
    public void the_database_is_populated_correctly() throws SQLException {

        PostGreConfig.PostGreConfigdetails(email);

    }

    @Then("the datetime is modified")
    public void the_datetime_is_modified() throws SQLException {
        PostGreConfig.PostGreConfigdetailsDuplicateEmail(Duplicate_email);
    }

    @Then("the status is New")
    public void the_status_is_new() throws SQLException {

        PostGreConfig.PostGreConfigdetailsStatus(Status);
    }
}
