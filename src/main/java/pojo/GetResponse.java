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

//        @JsonProperty("customerId")
//        public String getCustomerId() {
//            return customerId;
//        }
//
//        @JsonProperty("customerId")
//        public void setCustomerId(String customerId) {
//            this.customerId = customerId;
//        }
//
//        @JsonProperty("firstName")
//        public String getFirstName() {
//            return firstName;
//        }
//
//        @JsonProperty("firstName")
//        public void setFirstName(String firstName) {
//            this.firstName = firstName;
//        }
//
//        @JsonProperty("lastName")
//        public String getLastName() {
//            return lastName;
//        }
//
//        @JsonProperty("lastName")
//        public void setLastName(String lastName) {
//            this.lastName = lastName;
//        }
//
//        @JsonProperty("email")
//        public String getEmail() {
//            return email;
//        }
//
//        @JsonProperty("email")
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        @JsonProperty("gender")
//        public Integer getGender() {
//            return gender;
//        }
//
//        @JsonProperty("gender")
//        public void setGender(Integer gender) {
//            this.gender = gender;
//        }
//
//        @JsonProperty("dmpUid")
//        public String getDmpUid() {
//            return dmpUid;
//        }
//
//        @JsonProperty("dmpUid")
//        public void setDmpUid(String dmpUid) {
//            this.dmpUid = dmpUid;
//        }
//
//        @JsonProperty("salesforceCustomerId")
//        public String getSalesforceCustomerId() {
//            return salesforceCustomerId;
//        }
//
//        @JsonProperty("salesforceCustomerId")
//        public void setSalesforceCustomerId(String salesforceCustomerId) {
//            this.salesforceCustomerId = salesforceCustomerId;
//        }
//
//        @JsonProperty("demandwareCustomerNo")
//        public String getDemandwareCustomerNo() {
//            return demandwareCustomerNo;
//        }
//
//        @JsonProperty("demandwareCustomerNo")
//        public void setDemandwareCustomerNo(String demandwareCustomerNo) {
//            this.demandwareCustomerNo = demandwareCustomerNo;
//        }
//
//        @JsonProperty("dynamicYieldIdentity")
//        public String getDynamicYieldIdentity() {
//            return dynamicYieldIdentity;
//        }
//
//        @JsonProperty("dynamicYieldIdentity")
//        public void setDynamicYieldIdentity(String dynamicYieldIdentity) {
//            this.dynamicYieldIdentity = dynamicYieldIdentity;
//        }
//
//        @JsonProperty("preferredBranchIds")
//        public List<String> getPreferredBranchIds() {
//            return preferredBranchIds;
//        }
//
//        @JsonProperty("preferredBranchIds")
//        public void setPreferredBranchIds(List<String> preferredBranchIds) {
//            this.preferredBranchIds = preferredBranchIds;
//        }
//
//        @JsonProperty("loyaltySegmentId")
//        public String getLoyaltySegmentId() {
//            return loyaltySegmentId;
//        }
//
//        @JsonProperty("loyaltySegmentId")
//        public void setLoyaltySegmentId(String loyaltySegmentId) {
//            this.loyaltySegmentId = loyaltySegmentId;
//        }
//
//        @JsonProperty("eReceiptsPreferred")
//        public Boolean geteReceiptsPreferred() {
//            return eReceiptsPreferred;
//        }
//
//        @JsonProperty("eReceiptsPreferred")
//        public void seteReceiptsPreferred(Boolean eReceiptsPreferred) {
//            this.eReceiptsPreferred = eReceiptsPreferred;
//        }
//
//        @JsonProperty("lastAppLoginDateTime")
//        public String getLastAppLoginDateTime() {
//            return lastAppLoginDateTime;
//        }
//
//        @JsonProperty("lastAppLoginDateTime")
//        public void setLastAppLoginDateTime(String lastAppLoginDateTime) {
//            this.lastAppLoginDateTime = lastAppLoginDateTime;
//        }
//
//        @JsonProperty("token")
//        public String getToken() {
//            return token;
//        }
//
//        @JsonProperty("token")
//        public void setToken(String token) {
//            this.token = token;
//        }
//
//        @JsonProperty("expiresDatetime")
//        public String getExpiresDatetime() {
//            return expiresDatetime;
//        }
//
//        @JsonProperty("expiresDatetime")
//        public void setExpiresDatetime(String expiresDatetime) {
//            this.expiresDatetime = expiresDatetime;
//        }
//
//        @JsonProperty("expiryMinutes")
//        public Integer getExpiryMinutes() {
//            return expiryMinutes;
//        }
//
//        @JsonProperty("expiryMinutes")
//        public void setExpiryMinutes(Integer expiryMinutes) {
//            this.expiryMinutes = expiryMinutes;
//        }
//
//        @JsonProperty("guest")
//        public Boolean getGuest() {
//            return guest;
//        }
//
//        @JsonProperty("guest")
//        public void setGuest(Boolean guest) {
//            this.guest = guest;
//        }
//
//        @JsonProperty("platformDemandWare")
//        public String getPlatformDemandWare() {
//            return platformDemandWare;
//        }
//
//        @JsonProperty("platformDemandWare")
//        public void setPlatformDemandWare(String platformDemandWare) {
//            this.platformDemandWare = platformDemandWare;
//        }
//
//        @JsonProperty("environment")
//        public String getEnvironment() {
//            return environment;
//        }
//
//        @JsonProperty("environment")
//        public void setEnvironment(String environment) {
//            this.environment = environment;
//        }
//
//        @JsonProperty("developmentPlatform")
//        public Boolean getDevelopmentPlatform() {
//            return developmentPlatform;
//        }
//
//        @JsonProperty("developmentPlatform")
//        public void setDevelopmentPlatform(Boolean developmentPlatform) {
//            this.developmentPlatform = developmentPlatform;
//        }
//
//        @JsonProperty("apiVersion")
//        public Float getApiVersion() {
//            return apiVersion;
//        }
//
//        @JsonProperty("apiVersion")
//        public void setApiVersion(Float apiVersion) {
//            this.apiVersion = apiVersion;
//        }
//
//        @JsonProperty("requestedApiVersion")
//        public Float getRequestedApiVersion() {
//            return requestedApiVersion;
//        }
//
//        @JsonProperty("requestedApiVersion")
//        public void setRequestedApiVersion(Float requestedApiVersion) {
//            this.requestedApiVersion = requestedApiVersion;
//        }

    }

