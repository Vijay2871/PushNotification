package steps;

import Utils.FakeData;
import api.application.PostGreConfig;
import api.application.PushApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.PushBody;

import java.io.FileNotFoundException;
import java.sql.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EmailSteps {
    Response response;
    String email = FakeData.generateEmailAddress();
    String firebasetoken = FakeData.generateCustomerId();

    @Given("I send the the email")
    public void i_send_the_the_email() throws FileNotFoundException {

        PushBody requestPush = new PushBody();
        requestPush.setEmail(email);
        requestPush.setFirebaseToken(firebasetoken);

        response = PushApi.post(requestPush);

    }

    @Given("I send the firebase token")
    public void i_send_the_firebase_token() {

        assertThat(response.statusCode(), equalTo(204));
    }

    @Then("I see the above details in Database")
    public void i_see_the_above_details_in_database() throws ClassNotFoundException, SQLException {
        //AssertionDatabase.DatabaseAssertion();
//        ResultSet rs = PostGreConfig.PostGreConfig(email);
//        while (rs.next()) {
//            String myEmail = rs.getString(1);
//            String myFirebaseToken = rs.getString(2);
//            String myStatus = rs.getString(4);
//            System.out.println(myEmail);
//            System.out.println(myFirebaseToken);
//            System.out.println(myStatus);
//
//            Assert.assertEquals(myEmail, email);
//            Assert.assertNotNull(myFirebaseToken);
//            Assert.assertEquals(myStatus, "New");

        PostGreConfig.PostGreConfigdetails(email);

    }
}
