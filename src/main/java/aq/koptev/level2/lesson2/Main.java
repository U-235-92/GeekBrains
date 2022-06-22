package aq.koptev.level2.lesson2;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        ExceptionRunner exceptionRunner = new ExceptionRunner();
        String[][] numberMatrix = main.getNumberMatrix(4, 4);
        String[][] nullBigMatrix = main.getNullMatrix(5, 5);
        String[][] randomSymbolMatrix = main.getRandomMatrix(4, 4);
        String[][] numberSymbolMatrix = main.getNumberSymbolMatrix();
        Object[] objects = {numberMatrix, nullBigMatrix, randomSymbolMatrix, numberSymbolMatrix};
        System.out.println("Расчет суммы числовых элементов каждой матрицы");
        getSumElementsEachMatrix(exceptionRunner, objects);
    }

    private String[][] getNumberMatrix(int rows, int cols) {
        String[][] numberMarix = new String[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int number = (int) (Math.random() * 50);
                numberMarix[i][j] = "" + number;
            }
        }
        return numberMarix;
    }
    private String[][] getNullMatrix(int rows, int cols) {
        return new String[5][5];
    }
    private String[][] getRandomMatrix(int rows, int cols) {
        String[][] rndMatrix = new String[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int symb = (int) Math.random() * 255;
                rndMatrix[i][j] = "" + (char) symb;
            }
        }
        return rndMatrix;
    }
    private String[][] getNumberSymbolMatrix() {
        return new String[][]{{"1", "2", "3", "4a"},
                                {".", "f33", "10", "100"},
                                {"7", "h", "3", "3"},
                                {"5", "6", "8", "9"}};
    }

    private static void printMatrix(String[][] matrix) {
        for(String[] row : matrix) {
            for(String element : row) {
                System.out.printf("%-5s", element);
            }
            System.out.println();
        }
    }

    private static void printArrayMatrix(Object[] objects) {
        for(Object obj : objects) {
            printMatrix((String[][]) obj);
            System.out.println();
        }
    }

    private static void getSumElementsEachMatrix(ExceptionRunner exceptionRunner, Object[] objects) {
        for(int i = 0; i < objects.length; i++) {
            System.out.println("Расчитываем результат матрицы №" + (i + 1));
            printMatrix((String[][]) objects[i]);
            int result = exceptionRunner.getSumNumberElementMatrix((String[][]) objects[i]);
            System.out.println("Сумма числовых элементов матрицы №" + (i + 1) + " = " + result + "\n");
        }
    }
}
