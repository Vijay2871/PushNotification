package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PushBody {


        @JsonProperty("email")
        private String email;
        @JsonProperty("firebaseToken")
        private String firebaseToken;

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        @JsonProperty("firebaseToken")
        public String getFirebaseToken() {
            return firebaseToken;
        }

        @JsonProperty("firebaseToken")
        public void setFirebaseToken(String firebaseToken) {
            this.firebaseToken = firebaseToken;
        }

}
