package steps;

import Utils.FakeData;
import api.application.BodyRefactor;
import api.application.PostGreConfig;
import api.application.PushApi;
import api.application.Routes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.GetResponse;
import pojo.HomePhone;
import pojo.RegisterCustomer;

import java.io.FileNotFoundException;
import java.sql.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginAppSteps {

    RegisterCustomer requestRegisterCustomer;
    Response response;
    HomePhone requestHomePhone;
    GetResponse getResponse;
    String uname = FakeData.generateEmailAddress();
    String pname = FakeData.generatePassword();

    public LoginAppSteps() throws FileNotFoundException {
    }

    @Given("I Login to Red App")
    public void i_login_to_red_app() throws FileNotFoundException {

        requestHomePhone = BodyRefactor.getBodyBuilder(FakeData.generatePreferedStore(), FakeData.generatePreferedStore());
        requestRegisterCustomer = BodyRefactor.getRegisterBuilder(uname, FakeData.generateName(), FakeData.generateLastName(), pname, FakeData.generateRandomToken(), FakeData.generateCustomerId());
        requestRegisterCustomer.setHomePhone(requestHomePhone);
    }

    @Given("I register a customer with no preferred store")
    public void i_register_a_customer_with_no_preferred_store() throws FileNotFoundException, InterruptedException {

        PushApi.post(requestRegisterCustomer, Routes.REGISTER_PUSH);
        Thread.sleep(14000);
    }

    @Then("I see the customer details")
    public void i_see_the_customer_details() throws FileNotFoundException, InterruptedException, SQLException {

        response = PushApi.getResponse(uname, pname);
        getResponse = response.as(GetResponse.class);


    }

    @Then("I see the salesforce id in Database")
    public void i_see_the_salesforce_id_in_database() throws SQLException {
        String crm_id = getResponse.getSalesforceCustomerId();
        String crm_database=PostGreConfig.PostGreConfigdetailsGetCrmId(crm_id);
        System.out.println(crm_id);
        System.out.printf(crm_database);
        assertThat(crm_id,equalTo(crm_database));



    }
}