package aq.koptev.level1.lesson8;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class CalculatorModel {
    private final String DIVIDE_BY_ZERO_ERROR_MESSAGE = "Divide by zero";
    private final String TO_LONG_RESULT_VALUE_ERROR_MESSAGE = "Out of limit";
    private final String EMPTY_RESULT = "";
    private final String OPERATOR_ADD = "+";
    private final String OPERATOR_SUB = "-";
    private final String OPERATOR_DIV = "/";
    private final String OPERATOR_MUL = "*";
    private final String OPERATOR_EQU = "=";
    private final String OPERATOR_PERCENT = "%";
    private final String ZERO_VALUE = "0";
    private Deque<String> stackOperator;
    private Deque<BigDecimal> stackOperand;

    private String firstOperator;
    private String lastOperator;
    private BigDecimal firstOperand;
    private BigDecimal lastOperand;
    private BigDecimal resultOperand;

    public CalculatorModel() {
        stackOperand = new LinkedList<>();
        stackOperator = new LinkedList<>();
        lastOperator = "";
        firstOperator = "";
    }

    public void pushOperand(String operand) {
        switch (operand) {
            case EMPTY_RESULT:
                stackOperand.push(new BigDecimal(ZERO_VALUE));
                break;
            case DIVIDE_BY_ZERO_ERROR_MESSAGE:
            case TO_LONG_RESULT_VALUE_ERROR_MESSAGE:
                resetCalculator();
                break;
            default:
                stackOperand.push(new BigDecimal(operand));
        }
    }

    public void pushOperator(String operator) {
        stackOperator.push(operator);
    }

    public void cleanMemory() {
        resetCalculator();
    }
    private void resetCalculator() {
        firstOperand = null;
        lastOperand = null;
        resultOperand = null;
        lastOperator = "";
        firstOperator = "";
        stackOperator.removeAll(stackOperator);
        stackOperand.removeAll(stackOperand);
    }
    public String getResult() {
        String resultString = EMPTY_RESULT;
        if(stackOperand.size() > 1) {
            lastOperator = stackOperator.pop();
            if(lastOperator.equals(OPERATOR_EQU)) {
                if(stackOperand.size() > 2) {
                    while(stackOperand.size() != 2) {
                        stackOperand.pop();
                    }
                }
                firstOperator = stackOperator.pop();
                lastOperand = stackOperand.pop();
                firstOperand = stackOperand.pop();
                resultString = doCalculate(firstOperand, lastOperand, firstOperator);
                if(resultString.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || resultString.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
                    return resultString;
                } else {
                    stackOperand.push(resultOperand);
                    stackOperand.push(lastOperand);
                    stackOperator.push(firstOperator);
                    firstOperator = lastOperator;
                }
            } else {
                if(firstOperator.equals(OPERATOR_EQU)) {
                    resultString = resultOperand.toString();
                    stackOperand.pop();
                    stackOperand.pop();
                } else {
                    firstOperator = stackOperator.pop();
                    lastOperand = stackOperand.pop();
                    firstOperand = stackOperand.pop();
                    resultString = doCalculate(firstOperand, lastOperand, firstOperator);
                    if(resultString.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || resultString.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
                        return resultString;
                    } else {
                        stackOperand.push(resultOperand);
                        stackOperator.push(lastOperator);
                    }
                }
            }
        }
        return resultString;
    }

    public String printResult() {
        return resultOperand.toString();
    }

    public String printError() {
        return null;
    }

    private String popOperator() {
        return stackOperator.pop();
    }

    private BigDecimal popOperand() {
        return stackOperand.pop();
    }

    private String doCalculate(BigDecimal operandA, BigDecimal operandB, String operator) {
        resultOperand = new BigDecimal("0");
        switch (operator) {
            case OPERATOR_ADD:
                resultOperand = operandA.add(operandB);
                break;
            case OPERATOR_SUB:
                resultOperand = operandA.subtract(operandB);
                break;
            case OPERATOR_DIV:
                if(operandB.intValue() == 0) {
                    return DIVIDE_BY_ZERO_ERROR_MESSAGE;
                }
                resultOperand = operandA.divide(operandB);
                break;
            case OPERATOR_MUL:
                resultOperand = operandA.multiply(operandB);
                break;
            case OPERATOR_PERCENT:
                break;
        }
        if(resultOperand.toString().length() > CalculatorView.MAX_NUMBER_COUNT) {
            return TO_LONG_RESULT_VALUE_ERROR_MESSAGE;
        }
        return resultOperand.toString();
    }
}
