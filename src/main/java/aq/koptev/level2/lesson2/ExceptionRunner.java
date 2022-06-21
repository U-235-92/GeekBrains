package aq.koptev.level2.lesson2;

public class ExceptionRunner {

    private final int MATRIX_SIZE = 4;

    public int dangerSumElementMatrix(String[][] matrixNumber) {
        return dangerSumElementMatrix0(matrixNumber, 0, 0);
    }

    private int dangerSumElementMatrix0(String[][] matrixNumber, int startRowIndex, int startColumnIndex) {
        try {
            if(matrixNumber.length != MATRIX_SIZE && matrixNumber[0].length != MATRIX_SIZE) {
                throw new MatrixSizeException(matrixNumber.length, matrixNumber[0].length);
            }
        } catch (MatrixSizeException e) {
            e.printStackTrace();
            System.out.println("Обнаружена ошибка размера массива!");
            return 0;
        }
        int result = 0;
        int wrongRow = 0, wrongColumn = 0;
        try {
            for(int i = startRowIndex; i < matrixNumber.length; i++) {
                if(startColumnIndex == matrixNumber[0].length) {
                    startColumnIndex = 0;
                    startRowIndex = startRowIndex + 1;
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
                        throw new MatrixDataException(i, j);
                    }
                }
            }
        } catch (MatrixDataException e) {
            e.printStackTrace();
            System.out.println("Обнаружен неформатируемый элемент в позиции массива " +
                    "[" + wrongRow + "; " + wrongColumn + "]");
            result += dangerSumElementMatrix0(matrixNumber, wrongRow, wrongColumn + 1);
//            if(wrongRow < matrixNumber.length) {
//                if(wrongColumn < matrixNumber[0].length) {
//                    result += dangerSumElementMatrix0(matrixNumber, wrongRow, wrongColumn + 1);
//                } else {
//                    result += dangerSumElementMatrix0(matrixNumber, wrongRow + 1, 0);
//                }
//            }
        }
        return result;
    }
}
