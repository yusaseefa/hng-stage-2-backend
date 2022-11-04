package ng.hng.stage2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AiArithmeticOperation {

    @NotNull(message = "{arithmeticOperation.question.notNull}")
    @JsonProperty("operation_type")
    private String question;
}
