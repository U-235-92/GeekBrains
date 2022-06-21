package aq.koptev.level2.lesson2;

public class MatrixDataException extends Exception {

    private int row;
    private int column;

    public MatrixDataException(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": неверный формат данных в позиции [" + row + "; " + column + "]";
    }
}
