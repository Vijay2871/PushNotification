package steps;

import Utils.FakeData;
import api.application.BodyRefactor;
import api.application.PostGreConfig;
import api.application.PushApi;
import api.application.Routes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.CreateLoyaltyAccount;
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
    CreateLoyaltyAccount requestCreateLoyalty;
    Response response;
    HomePhone requestHomePhone;
    GetResponse getResponse;
    String uname = FakeData.generateEmailAddress();
    String pname = FakeData.generatePassword();

    public LoginAppSteps() throws FileNotFoundException {
    }

    @Given("I login as a Guest via the Red App")
    public void i_login_as_a_guest_via_the_red_app() {

        requestHomePhone = BodyRefactor.getBodyBuilder(FakeData.generatePreferedStore(), FakeData.generatePreferedStore());
        requestRegisterCustomer = BodyRefactor.getRegisterBuilder(uname, FakeData.generateName(), FakeData.generateLastName(), pname, FakeData.generateRandomToken(), FakeData.generateCustomerId());
        requestRegisterCustomer.setHomePhone(requestHomePhone);
    }

    @Given("I register as a customer")
    public void i_register_as_a_customer() throws FileNotFoundException, InterruptedException {

        PushApi.post(requestRegisterCustomer, Routes.REGISTER_PUSH);
        Thread.sleep(22000);
    }

    @Then("I can now login as a registered Red App Customer")
    public void i_can_now_login_as_a_registered_red_app_customer() throws FileNotFoundException, InterruptedException {

        getResponse = PushApi.getResponse(uname, pname).as(GetResponse.class);

    }

    @Given("my SFSC Customer ID is available")
    public void my_sfsc_customer_id_is_available() throws SQLException {
        String crm_id = getResponse.getSalesforceCustomerId();
        String crm_database=PostGreConfig.PostGreConfigdetailsGetCrmId(crm_id);
//        System.out.println(crm_id);
//        System.out.printf(crm_database);
        assertThat(crm_id,equalTo(crm_database));

    }

    @Then("I can start signing up to MarketClub")
    public void i_can_start_signing_up_to_market_club() {
        requestCreateLoyalty=BodyRefactor.getCreateLoyaltyBodyBuilder(getResponse.getSalesforceCustomerId(),FakeData.generateBrand(),FakeData.generateName()+FakeData.generateLastName(),FakeData.generateName(),FakeData.generateLastName(),uname);
    }
    @Then("I can validate my phone number")
    public void i_can_validate_my_phone_number() throws FileNotFoundException {
       PushApi.postCreateLoyalty(requestCreateLoyalty);
    }
    @Then("I can choose a cause that I like")
    public void i_can_choose_a_cause_that_i_like() {
       System.out.println("f");
    }

}