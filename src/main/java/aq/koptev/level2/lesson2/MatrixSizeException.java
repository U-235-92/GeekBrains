package aq.koptev.level2.lesson2;

public class MatrixSizeException extends Exception {

    private int rows;
    private int columns;

    public MatrixSizeException(int rows, int columns) {
        super();
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": указан недопустимый размер массива [" + rows + "; " + columns + "]";
    }
}
