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
//        firstOperand = new BigDecimal("0");
//        lastOperand = new BigDecimal("0");
        lastOperator = "";
        firstOperator = "";
    }

    public void pushOperand(String operand) {
        System.out.println(operand);
        stackOperand.push(new BigDecimal(operand));
    }

    public void pushOperator(String operator) {
        stackOperator.push(operator);
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
        String stringResult = EMPTY_RESULT;
        if(stackOperand.size() == 2) {
            lastOperator = stackOperator.pop();
            if(lastOperator.equals(OPERATOR_EQU)) {
                firstOperator = stackOperator.pop();
                lastOperand = stackOperand.pop();
                firstOperand = stackOperand.pop();
                stringResult = doCalculate(firstOperand, lastOperand, firstOperator);
                if(stringResult.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || stringResult.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
                    return stringResult;
                } else {
                    pushOperand(stringResult);
                    pushOperand(lastOperand.toString());
                    pushOperator(firstOperator);
                    System.out.println(stringResult);
                }
            } else {
                firstOperator = stackOperator.pop();
                lastOperand = stackOperand.pop();
                firstOperand = stackOperand.pop();
                stringResult = doCalculate(firstOperand, lastOperand, firstOperator);
                if(stringResult.equals(DIVIDE_BY_ZERO_ERROR_MESSAGE) || stringResult.equals(TO_LONG_RESULT_VALUE_ERROR_MESSAGE)) {
                    return stringResult;
                } else {
                    pushOperand(stringResult);
                    pushOperator(lastOperator);
                    System.out.println(stringResult);
                }
            }
        } else if(stackOperand.size() > 2) {
            stackOperand.pop();
            stringResult = getResult();
        }
        return stringResult;
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
        return resultOperand.toString();
    }

    /*Ввод числа. Ввод оператора. Добавление числа в стек. Добавление оператора в стек.
    Проверить сколько элементов находится в стеке чисел.
    Если одно, то, поместить введенный оператор в стек операторов, продолжить.
    Если число не одно, то запомнить последнее введенное число, запомнить последний введенный оператор,
    Извлеч из стека оператор введенный на предыдущем шаге. Выполнить оператор. Проверить результат выражения.
    Если корректно, поместить результат в стек чисел, поместить оператор в стек операторов.
    Если некорректно, вывод сообщения об ошибке. Продолжить.

    Ввели число (А), ввели оператор, поместили А в стек, поместили оператор в стек,
    Ввели число (Б), ввели оператор,  запомнили его. Извлекаем А и Б из стека, извлекаем оператор из стека,
    Принимаем оператор и записываем результат С в стек. Помещаем последний введенный оператор в стек.
    */
}
