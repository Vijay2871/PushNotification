package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
@Getter
@Setter
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetResponse {

        @JsonProperty("customerId")
        private String customerId;
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("email")
        private String email;
        @JsonProperty("gender")
        private Integer gender;
        @JsonProperty("dmpUid")
        private String dmpUid;
        @JsonProperty("salesforceCustomerId")
        private String salesforceCustomerId;
        @JsonProperty("demandwareCustomerNo")
        private String demandwareCustomerNo;
        @JsonProperty("dynamicYieldIdentity")
        private String dynamicYieldIdentity;
        @JsonProperty("preferredBranchIds")
        private List<String> preferredBranchIds = null;
        @JsonProperty("loyaltySegmentId")
        private String loyaltySegmentId;
        @JsonProperty("eReceiptsPreferred")
        private Boolean eReceiptsPreferred;
        @JsonProperty("lastAppLoginDateTime")
        private String lastAppLoginDateTime;
        @JsonProperty("token")
        private String token;
        @JsonProperty("expiresDatetime")
        private String expiresDatetime;
        @JsonProperty("expiryMinutes")
        private Integer expiryMinutes;
        @JsonProperty("guest")
        private Boolean guest;
        @JsonProperty("platformDemandWare")
        private String platformDemandWare;
        @JsonProperty("environment")
        private String environment;
        @JsonProperty("developmentPlatform")
        private Boolean developmentPlatform;
        @JsonProperty("apiVersion")
        private Float apiVersion;
        @JsonProperty("requestedApiVersion")
        private Float requestedApiVersion;
    }

