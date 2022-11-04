package ng.hng.stage2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ng.hng.stage2.model.enums.ArithmeticType;
import ng.hng.stage2.validator.ArithmeticTypeValidator;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ArithmeticOperation {

    @JsonProperty("operation_type")
    @NotNull(message = "{arithmeticOperation.type.notNull}")
    @ArithmeticTypeValidator(enumClass = ArithmeticType.class, message = "{arithmeticOperation.type.enum}")
    private String operationType;

    @NotNull(message = "{arithmeticOperation.x.notNull}")
    private Integer x;

    @NotNull(message = "{arithmeticOperation.y.notNull}")
    private Integer y;
}
