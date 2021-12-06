package api;

import Utils.ConfigLoader;
import api.application.PushApi;
import api.application.Routes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import steps.LoginAppSteps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class specbuilder  {

RequestSpecification requestSpecification;
ResponseSpecification responseSpecification;

    public specbuilder() throws FileNotFoundException {
    }

    public static RequestSpecification getRequestSpec() throws FileNotFoundException {
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationAPI.log"));
        return new RequestSpecBuilder().addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream)).
                setBaseUri("https://twg.azure-api.net").setBasePath(Routes.BASE_PATH)
                .addHeader("Ocp-Apim-Subscription-Key", ConfigLoader.getInstance().getHeader())
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }
    public static RequestSpecification getRequestSpecGet() throws FileNotFoundException {
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationGet.log"));
        return new RequestSpecBuilder().addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream)).
                setBaseUri("https://twg.azure-api.net")
                .addHeader("Authorization","Guest")
                .addHeader("Ocp-Apim-Subscription-Key",ConfigLoader.getInstance().getHeaderGetRedApp())
                .addHeader("X-TWL-API-Version",ConfigLoader.getInstance().getHeaderGetXTWLAPI())
                .addHeader("X-TWL-Device",ConfigLoader.getInstance().getHeaderGetXTWLDevice())
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }
    public static RequestSpecification getRequestSpecGetBasic() throws FileNotFoundException {
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationGetBasicAuth.log"));
        return new RequestSpecBuilder().addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream)).
                setBaseUri("https://twg.azure-api.net")
                .addHeader("Ocp-Apim-Subscription-Key",ConfigLoader.getInstance().getHeaderGetRedApp())
                .addHeader("X-TWL-API-Version",ConfigLoader.getInstance().getHeaderGetXTWLAPI())
                .addHeader("X-TWL-Device",ConfigLoader.getInstance().getHeaderGetXTWLDevice())
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }
    public static RequestSpecification getRequestSpecPostApp() throws FileNotFoundException {
        Headers headers=PushApi.get();
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationPost.log"));
        return new RequestSpecBuilder().addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream)).
                setBaseUri("https://twg.azure-api.net")
                .addHeader("Ocp-Apim-Subscription-Key",ConfigLoader.getInstance().getHeaderGetRedApp())
                .addHeader("X-TWL-API-Version",ConfigLoader.getInstance().getHeaderGetXTWLAPI())
                .addHeader("X-TWL-Token",headers.getValue("X-TWL-Token"))
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL).build();

    }
}
