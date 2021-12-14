package api;

import Utils.ConfigLoader;
import api.application.BlackListHeaders;
import api.application.PushApi;
import api.application.Routes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import steps.LoginAppSteps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class specbuilder  {

RequestSpecification requestSpecification;
ResponseSpecification responseSpecification;

    public specbuilder() throws FileNotFoundException {
    }

    public static RequestSpecification getRequestSpec() throws FileNotFoundException {
       PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationAPI.log"));
        return new RequestSpecBuilder().
                setBaseUri("https://twg.azure-api.net").setBasePath(Routes.BASE_PATH)
                .addHeader("Ocp-Apim-Subscription-Key", ConfigLoader.getInstance().getHeader()).setConfig(SerenityRest.config().logConfig(LogConfig.logConfig().blacklistHeaders(BlackListHeaders.BlackListHeaderDetails())))
                .addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream))
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }

    public static RequestSpecification getRequestSpecInvalidOCP() throws FileNotFoundException {
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationAPI_InvalidKey.log"));
        return new RequestSpecBuilder().
                setBaseUri("https://twg.azure-api.net").setBasePath(Routes.BASE_PATH)
                .addHeader("Ocp-Apim-Subscription-Key", ConfigLoader.getInstance().getHeader()+"123A").setConfig(SerenityRest.config().logConfig(LogConfig.logConfig().blacklistHeaders(BlackListHeaders.BlackListHeaderDetails())))
                .addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream))
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }
    public static RequestSpecification getRequestSpecGet() throws FileNotFoundException {

        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationGet.log"));
        return new RequestSpecBuilder().
                setBaseUri("https://twg.azure-api.net").setContentType(ContentType.JSON)
                .addHeader("Authorization","Guest")
                .addHeader("Ocp-Apim-Subscription-Key",ConfigLoader.getInstance().getHeaderGetRedApp())
                .addHeader("X-TWL-API-Version",ConfigLoader.getInstance().getHeaderGetXTWLAPI())
                .addHeader("X-TWL-Device",ConfigLoader.getInstance().getHeaderGetXTWLDevice()).setConfig(SerenityRest.config().logConfig(LogConfig.logConfig().blacklistHeaders(BlackListHeaders.BlackListHeaderDetails())))
                .addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream))
                .log(LogDetail.ALL).build();
    }

    public static RequestSpecification getRequestSpecGetInvalid() throws FileNotFoundException {

        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationGetInvalid.log"));
        return new RequestSpecBuilder().
                setBaseUri("https://twg.azure-api.net").setContentType(ContentType.JSON)
                .addHeader("Authorization","Guest")
                .addHeader("Ocp-Apim-Subscription-Key",ConfigLoader.getInstance().getHeaderGetRedApp()+"a")
                .addHeader("X-TWL-API-Version",ConfigLoader.getInstance().getHeaderGetXTWLAPI())
                .addHeader("X-TWL-Device",ConfigLoader.getInstance().getHeaderGetXTWLDevice()).setConfig(SerenityRest.config().logConfig(LogConfig.logConfig().blacklistHeaders(BlackListHeaders.BlackListHeaderDetails())))
                .addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream))
                .log(LogDetail.ALL).build();
    }
    public static RequestSpecification getRequestSpecGetBasic() throws FileNotFoundException {
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationGetBasicAuth.log"));
        return new RequestSpecBuilder().
                setBaseUri("https://twg.azure-api.net")
                .addHeader("Ocp-Apim-Subscription-Key",ConfigLoader.getInstance().getHeaderGetRedApp())
                .addHeader("X-TWL-API-Version",ConfigLoader.getInstance().getHeaderGetXTWLAPI())
                .addHeader("X-TWL-Device",ConfigLoader.getInstance().getHeaderGetXTWLDevice()).setConfig(SerenityRest.config().logConfig(LogConfig.logConfig().blacklistHeaders(BlackListHeaders.BlackListHeaderDetails())))
                .addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream)).setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }
    public static RequestSpecification getRequestSpecPostApp() throws FileNotFoundException {
        Headers headers=PushApi.get();
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationPost.log"));
        return new RequestSpecBuilder().
                setBaseUri("https://twg.azure-api.net")
                .addHeader("Ocp-Apim-Subscription-Key",ConfigLoader.getInstance().getHeaderGetRedApp())
                .addHeader("X-TWL-API-Version",ConfigLoader.getInstance().getHeaderGetXTWLAPI())
                .addHeader("X-TWL-Token",headers.getValue("X-TWL-Token")).setConfig(SerenityRest.config().logConfig(LogConfig.logConfig().blacklistHeaders(BlackListHeaders.BlackListHeaderDetails())))
                .addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream)).setContentType(ContentType.JSON).log(LogDetail.ALL).build();
    }
    public static RequestSpecification getRequestSpecCreateLoyalty() throws FileNotFoundException {
        Headers headers=PushApi.get();
        PrintStream fileOutPutStream=new PrintStream(new File("PushNotificationLoyalty.log"));
        return new RequestSpecBuilder().
                setBaseUri("https://test-api.twg.co.nz").setBasePath(Routes.POST_CREATE_LOYALTY)
                .addHeader("x-api-key", "tKySF1qrPUt768FCuQ2N7dZV8OqoQoXdDTsFoWb0")
                .addFilter(new RequestLoggingFilter(fileOutPutStream)).
                addFilter(new ResponseLoggingFilter(fileOutPutStream))
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    }
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL).build();

    }
}
