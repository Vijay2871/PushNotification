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

public class RegisterCustomer {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("firebaseToken")
    private String firebaseToken;
    @JsonProperty("homePhone")
    private HomePhone homePhone;
    @JsonProperty("preferredBranchIds")
    private List<String> preferredBranchIds = null;


}
