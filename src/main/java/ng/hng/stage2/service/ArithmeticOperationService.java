package ng.hng.stage2.service;

import ng.hng.stage2.model.AiArithmeticOperation;
import ng.hng.stage2.model.ArithmeticOperation;
import ng.hng.stage2.model.ArithmeticOperationResponse;
import ng.hng.stage2.model.enums.ArithmeticType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ArithmeticOperationService {

    public ArithmeticOperationResponse solve(ArithmeticOperation arithmeticOperation) {

        String operationType = arithmeticOperation.getOperationType();
        Integer x = arithmeticOperation.getX();
        Integer y = arithmeticOperation.getY();
        ArithmeticOperationResponse arithmeticOperationResponse = new ArithmeticOperationResponse();
        int result = 0;

        if (operationType.equals(ArithmeticType.ADDITION.getValue())) {
            result = add(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.ADDITION);
        } else if (operationType.equals(ArithmeticType.SUBTRACTION.getValue())) {
            result = subtract(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.SUBTRACTION);
        } else if (operationType.equals(ArithmeticType.MULTIPLICATION.getValue())) {
            result = multiply(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.MULTIPLICATION);
        } else if (operationType.equals(ArithmeticType.DIVISION.getValue())) {
            result = divide(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.DIVISION);
        }
        else {
            arithmeticOperationResponse.setResult(0);
            arithmeticOperationResponse.setOperationType(ArithmeticType.UNKNOWN);
        }
        return arithmeticOperationResponse;
    }

    public ArithmeticOperationResponse solve(AiArithmeticOperation arithmeticOperation) {

        String question = arithmeticOperation.getQuestion();

        Integer x = 1;
        Integer y = 1;
        ArithmeticOperationResponse arithmeticOperationResponse = new ArithmeticOperationResponse();
        int result = 0;

        Matcher m = Pattern.compile("\\d+").matcher(question);
        List<Integer> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }

        if (numbers.size() < 2) {
            arithmeticOperationResponse.setResult(0);
            arithmeticOperationResponse.setOperationType(ArithmeticType.UNKNOWN);
            return arithmeticOperationResponse;
        }

        x = numbers.get(0);
        y = numbers.get(1);

        if (question.contains("add") || question.contains("addition")) {
            result = add(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.ADDITION);
        } else if (question.contains("subtract") || question.contains("minus") || question.contains("subtraction")) {
            result = subtract(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.SUBTRACTION);
        } else if (question.contains("multiply") || question.contains("multiplication")) {
            result = multiply(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.MULTIPLICATION);
        } else if (question.contains("divide") || question.contains("division") || question.contains("quotient")) {
            result = divide(x, y);
            arithmeticOperationResponse.setResult(result);
            arithmeticOperationResponse.setOperationType(ArithmeticType.DIVISION);
        }
        else {
            arithmeticOperationResponse.setResult(0);
            arithmeticOperationResponse.setOperationType(ArithmeticType.UNKNOWN);
        }
        return arithmeticOperationResponse;
    }

    private int add(Integer x, Integer y) {
        return x + y;
    }

    private int multiply(Integer x, Integer y) {
        return x * y;
    }

    private int subtract(Integer x, Integer y) {
        return x - y;
    }

    private int divide(Integer x, Integer y) {
        return x / y;
    }
}
