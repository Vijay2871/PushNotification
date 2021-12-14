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

public class ErrorNotification {

        @JsonProperty("errorCode")
        private Integer errorCode;
        @JsonProperty("errorMessage")
        private String errorMessage;

    }
