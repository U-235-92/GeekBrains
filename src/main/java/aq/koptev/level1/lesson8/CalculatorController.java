package aq.koptev.level1.lesson8;

import java.math.BigDecimal;

public class CalculatorController {

    private CalculatorModel calculatorModel;
    private CalculatorView calculatorView;

    public CalculatorController(CalculatorModel calculatorModel) {
        this.calculatorModel = calculatorModel;
        calculatorView = new CalculatorView(this);
    }

    public void launchCalculator() {
        calculatorView.createView();
    }

    protected void pushOperand(String operand) {
        calculatorModel.pushOperand(operand);
    }

    protected void pushOperator(String operator) {
        calculatorModel.pushOperator(operator);
    }

    protected void cleanMemory() {
        calculatorModel.cleanMemory();
    }

    protected String getResult() {
        return calculatorModel.getResult();
    }

    protected String printResult() {
        return calculatorModel.printResult();
    }

    protected String printError() {
        return calculatorModel.printError();
    }
}
