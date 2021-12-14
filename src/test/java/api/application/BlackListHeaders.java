package api.application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BlackListHeaders {

    public static List BlackListHeaderDetails() throws FileNotFoundException {

        List headers=new ArrayList<String>();
        headers.add("Ocp-Apim-Subscription-Key");
        headers.add("X-TWL-API-Version");
        headers.add("X-TWL-Device");
       headers.add("X-TWL-Token");
       headers.add("Authorization");
       headers.add("Accept");
       headers.add("Content-Type");

                return headers;
    }
}
