package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Vcode {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("mobileNumber")
    private String mobileNumber;

//    @JsonProperty("userId")
//    public String getUserId() {
//        return userId;
//    }
//
//    @JsonProperty("userId")
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    @JsonProperty("mobileNumber")
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    @JsonProperty("mobileNumber")
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }

}

