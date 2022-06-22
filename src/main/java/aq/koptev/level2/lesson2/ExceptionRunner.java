package aq.koptev.level2.lesson2;

public class ExceptionRunner {

    private final int MATRIX_SIZE = 4;

    public int getSumNumberElementMatrix(String[][] matrixNumber) {
        return getSumNumberElementMatrix(matrixNumber, 0, 0);
    }

    private int getSumNumberElementMatrix(String[][] matrixNumber, int startRowIndex, int startColumnIndex) {
        if(catchWrongSizeMatrix(matrixNumber)) {
            return 0;
        }
        return getSumNumberElementMatrix0(matrixNumber, startRowIndex, startColumnIndex);
    }

    private boolean catchWrongSizeMatrix(String[][] matrixNumber) {
        try {
            if(matrixNumber.length != MATRIX_SIZE && matrixNumber[0].length != MATRIX_SIZE) {
                throw new MatrixSizeException(matrixNumber.length, matrixNumber[0].length);
            }
        } catch (MatrixSizeException e) {
            e.printStackTrace();
            System.out.println("Обнаружена ошибка размера массива!");
            return true;
        }
        return false;
    }

    private int getSumNumberElementMatrix0(String[][] matrixNumber, int startRowIndex, int startColumnIndex) {
        int result = 0;
        int wrongRow = 0, wrongColumn = 0;
        try {
            for(int i = startRowIndex; i < matrixNumber.length; i++) {
                if(i > startRowIndex && startColumnIndex > 0) {
                    startColumnIndex = 0;
                }
                if(startColumnIndex == matrixNumber[0].length) {
                    startColumnIndex = 0;
                    continue;
                }
                for(int j = startColumnIndex; j < matrixNumber[0].length; j++) {
                    String tmp = matrixNumber[i][j];
                    if(tmp.matches("\\d+")) {
                        int number = Integer.valueOf(tmp);
                        result += number;
                    } else {
                        wrongRow = i;
                        wrongColumn = j;
                        throw new MatrixDataException(wrongRow, wrongColumn);
                    }
                }
            }
        } catch (MatrixDataException e) {
            e.printStackTrace();
            System.out.println("Обнаружен неформатируемый элемент в позиции массива " +
                    "[" + wrongRow + "; " + wrongColumn + "]");
            result += getSumNumberElementMatrix0(matrixNumber, wrongRow, wrongColumn + 1);
        }
        return result;
    }
}
