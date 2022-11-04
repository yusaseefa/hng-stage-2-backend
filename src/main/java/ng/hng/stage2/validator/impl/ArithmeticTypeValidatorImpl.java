package ng.hng.stage2.validator.impl;

import ng.hng.stage2.validator.ArithmeticTypeValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticTypeValidatorImpl implements ConstraintValidator<ArithmeticTypeValidator, CharSequence> {

    private List<String> acceptedValues = new ArrayList<String>();

    @Override
    public void initialize(ArithmeticTypeValidator annotation) {
        for (Enum<?> enumValue : annotation.enumClass().getEnumConstants()) {
            acceptedValues.add(enumValue.toString());
        }
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return acceptedValues.contains(value.toString());
    }

}
