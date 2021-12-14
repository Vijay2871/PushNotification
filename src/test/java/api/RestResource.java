package api;

import api.application.BlackListHeaders;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import pojo.PushBody;

import java.io.FileNotFoundException;

import static api.specbuilder.*;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class RestResource {
    public static Response post(Object requestPush, String path) throws FileNotFoundException {
        return SerenityRest.given(getRequestSpec()).body(requestPush).when().post(path)
                .then().spec(getResponseSpec()).extract().response();
    }

    public static Response postCreateLoyalty(Object requestPush, String path) throws FileNotFoundException {
        return SerenityRest.given(getRequestSpecCreateLoyalty()).body(requestPush).when().post(path)
                .then().spec(getResponseSpec()).extract().response();
    }
    public static Response postInvalidKey(Object requestPush, String path) throws FileNotFoundException {
        return SerenityRest.given(getRequestSpecInvalidOCP()).body(requestPush).when().post(path)
                .then().spec(getResponseSpec()).extract().response();
    }

    public static Headers get(String path) throws FileNotFoundException {

        return SerenityRest.given(getRequestSpecGet()).when().get(path).
                then().spec(getResponseSpec()).extract().headers();
    }

    public static Response getInvalidKey(String path) throws FileNotFoundException {

        return SerenityRest.given(getRequestSpecGetInvalid()).when().get(path).
                then().spec(getResponseSpec()).extract().response();
    }
    public static Response getCustomer(String path,String username,String password) throws FileNotFoundException {
        return SerenityRest.given(getRequestSpecGetBasic()).auth().preemptive().basic(username,password).when().get(path).
                then().spec(getResponseSpec()).extract().response();
    }
    public static Response postRegister(Object requestRegisterCustomer, String path) throws FileNotFoundException {
        return SerenityRest.given(getRequestSpecPostApp()).body(requestRegisterCustomer).when().post(path)
                .then().spec(getResponseSpec()).extract().response();
    }
}