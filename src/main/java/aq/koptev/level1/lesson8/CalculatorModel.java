package aq.koptev.level1.lesson8;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class CalculatorModel {

    private final String DIVIDE_BY_ZERO_ERROR_MESSAGE = "Divide by zero";
    private final String TO_LONG_RESULT_VALUE_ERROR_MESSAGE = "Out of limit";
    private Deque<String> stackOperator;
    private Deque<BigDecimal> stackOperand;

    private String lastOperator;

    private BigDecimal operandA;
    private BigDecimal operandB;
    private BigDecimal resultOperand;

    public CalculatorModel() {
        stackOperand = new LinkedList<>();
        stackOperator = new LinkedList<>();
    }

    public void pushOperand(String operand) {
//        stackOperand.push(operand);
    }

    public void pushOperator(String operator) {
        stackOperator.push(operator);
    }

    public String printResult() {
        operandA = popOperand();
        operandB = popOperand();
        lastOperator = popOperator();
        resultOperand = doCalculate(operandA, operandB, lastOperator);
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

    private BigDecimal doCalculate(BigDecimal operandA, BigDecimal operandB, String operator) {

        return null;
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
