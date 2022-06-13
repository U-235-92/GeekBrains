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

    public String getResult() {
        String resultString = EMPTY_RESULT;
        if(stackOperand.size() > 1) {
            lastOperator = popOperator();
            if(lastOperator.equals(OPERATOR_EQU)) {
                if(stackOperand.size() > 2) {
                    while(stackOperand.size() != 2) {
                        popOperand();
                    }
                }
                firstOperator = popOperator();
                lastOperand = popOperand();
                firstOperand = popOperand();
                resultString = doCalculate(firstOperand, lastOperand, firstOperator);
                if(resultString.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || resultString.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
                    return resultString;
                } else {
                    pushOperand(resultOperand.toString());
                    pushOperand(lastOperand.toString());
                    pushOperator(firstOperator);
                    firstOperator = lastOperator;
                }
            } else if(lastOperator.equals(OPERATOR_PERCENT)) {
//                lastOperand = popOperand();
//                firstOperand = peekOperand();
//                String resultPercent = doCalculate(firstOperand, lastOperand, lastOperator);
//                if(resultPercent.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || resultPercent.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
//                    return resultPercent;
//                }
//                firstOperator = stackOperator.pop();
//                resultString = doCalculate(firstOperand, new BigDecimal(resultPercent), firstOperator);
//                if(resultString.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || resultString.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
//                    return resultString;
//                } else {
//                    popOperand();
//                    pushOperand(resultOperand.toString());
//                    pushOperand(resultPercent);
//                    pushOperator(firstOperator);
//                    firstOperator = lastOperator;
//                }

                lastOperand = popOperand();
                firstOperand = peekOperand();
                resultString = doCalculate(firstOperand, lastOperand, lastOperator);
                if(resultString.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || resultString.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
                    return resultString;
                } else {
                    popOperand();
                    pushOperand(resultOperand.toString());
                    pushOperand(resultString);
                    pushOperator(firstOperator);
                    firstOperator = lastOperator;
                }
            } else {
                if(firstOperator.equals(OPERATOR_EQU) || firstOperator.equals(OPERATOR_PERCENT)) {
                    resultString = resultOperand.toString();
                    popOperand();
                    popOperand();
                    popOperator();
                    pushOperator(lastOperator);
                } else {
                    firstOperator = popOperator();
                    lastOperand = popOperand();
                    firstOperand = popOperand();
                    resultString = doCalculate(firstOperand, lastOperand, firstOperator);
                    if(resultString.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || resultString.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
                        return resultString;
                    } else {
                        pushOperand(resultOperand.toString());
                        pushOperator(lastOperator);
                    }
                }
            }
        } else {
            if(stackOperand.peek().toString().equals("0") && stackOperator.peek().equals(OPERATOR_PERCENT)) {
                popOperator();
                popOperand();
            } else if (stackOperator.peek().equals(OPERATOR_PERCENT)) {
                popOperator();
                resultString = popOperand().toString();
            }
        }
        return resultString;
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
//                resultOperand = operandB.divide(new BigDecimal(100)).multiply(operandA);
                resultOperand = operandB.divide(new BigDecimal(100)).multiply(operandA);
                break;

        }
        if(resultOperand.toString().length() > CalculatorView.MAX_NUMBER_COUNT) {
            return TO_LONG_RESULT_VALUE_ERROR_MESSAGE;
        }
        return resultOperand.toString();
    }

    private String popOperator() {
        return stackOperator.pop();
    }

    private BigDecimal popOperand() {
        return stackOperand.pop();
    }

    private BigDecimal peekOperand() {
        return stackOperand.peek();
    }

    public void pushOperator(String operator) {
        stackOperator.push(operator);
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
}
