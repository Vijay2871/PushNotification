package api.application;

import api.RestResource;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import pojo.CreateLoyaltyAccount;
import pojo.PushBody;
import pojo.RegisterCustomer;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class PushApi {


    public PushApi() throws FileNotFoundException {
    }

    public static Response post(PushBody requestPush) throws FileNotFoundException {
        return RestResource.post(requestPush, Routes.POST_PUSH);
    }
    public static Response postCreateLoyalty(CreateLoyaltyAccount requestCreateLoyalty) throws FileNotFoundException {
        return RestResource.postCreateLoyalty(requestCreateLoyalty,Routes.POST_CREATE_LOYALTY);
    }

    public static Response postInvalidOcp(PushBody requestPush) throws FileNotFoundException {
        return RestResource.postInvalidKey(requestPush, Routes.POST_PUSH);
    }

    public static Headers get() throws FileNotFoundException {
        return RestResource.get(Routes.BASE_GET);
    }

    public static Response getInvalidOcpKey() throws FileNotFoundException, InterruptedException {
        return RestResource.getInvalidKey(Routes.BASE_GET);
    }

    public static Response getResponse(String username,String password) throws FileNotFoundException, InterruptedException {
        return RestResource.getCustomer(Routes.BASE_GET,username,password);
    }

    public static Response post(RegisterCustomer requestRegisterCustomer, String path) throws FileNotFoundException, InterruptedException {
        return RestResource.postRegister(requestRegisterCustomer,path);
    }


}