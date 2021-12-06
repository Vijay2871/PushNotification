package api;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import pojo.PushBody;

import java.io.FileNotFoundException;

import static api.specbuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {
    public static Response post(Object requestPush, String path) throws FileNotFoundException {
        return SerenityRest.given(getRequestSpec()).body(requestPush).when().post(path)
                .then().spec(getResponseSpec()).extract().response();
    }
    public static Headers get(String path) throws FileNotFoundException {
        return SerenityRest.given(getRequestSpecGet()).when().get(path).
                then().spec(getResponseSpec()).extract().headers();
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