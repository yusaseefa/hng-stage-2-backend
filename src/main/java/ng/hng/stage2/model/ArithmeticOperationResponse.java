package ng.hng.stage2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ng.hng.stage2.model.enums.ArithmeticType;

@Getter
@Setter
@ToString
public class ArithmeticOperationResponse {

    private String slackUsername;
    private Integer result;

    @JsonProperty("operation_type")
    private ArithmeticType operationType;

    public ArithmeticOperationResponse() {
        this.slackUsername = "YusufAlamu";
    }
}
