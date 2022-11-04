package ng.hng.stage2.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ArithmeticType {

    ADDITION("addition"),
    SUBTRACTION("subtraction"),
    DIVISION("division"),
    MULTIPLICATION("multiplication"),
    UNKNOWN("unknown");
    private String value;

    ArithmeticType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
