package api.application;

import Utils.FakeData;
import api.RestResource;
import api.specbuilder;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import pojo.HomePhone;
import pojo.PushBody;
import pojo.RegisterCustomer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static api.application.Routes.BASE_GET;
import static api.specbuilder.*;
import static io.restassured.RestAssured.given;

public class PushApi {


    public PushApi() throws FileNotFoundException {
    }

    public static Response post(PushBody requestPush) throws FileNotFoundException {
        return RestResource.post(requestPush, Routes.POST_PUSH);
    }

    public static Headers get() throws FileNotFoundException {
        return RestResource.get(Routes.BASE_GET);
    }
    public static Response getResponse(String username,String password) throws FileNotFoundException, InterruptedException {
        return RestResource.getCustomer(Routes.BASE_GET,username,password);
    }

    public static Response post(RegisterCustomer requestRegisterCustomer, String path) throws FileNotFoundException, InterruptedException {
        return RestResource.postRegister(requestRegisterCustomer,path);
    }


}