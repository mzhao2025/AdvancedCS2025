public class MatrixFun {
    private int[][] matrix;

    public MatrixFun(int numberOfRows, int numberOfCols) {
        if (numberOfRows <= 0 || numberOfCols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive");
        }
        matrix = new int[numberOfRows][numberOfCols];
        generateRandomNumber(matrix);
    }

    public MatrixFun(int[][] starterMatrix) {
        matrix = starterMatrix;
        validateRect(matrix);
    }

    public MatrixFun() {
        matrix = new int[3][3];
        generateRandomNumber(matrix);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        StringBuilder firstRow = new StringBuilder();
        for (int j = 0; j < matrix[0].length; j++) {
            firstRow.append(matrix[0][j]).append(" ");
        }

        int visibleLength = firstRow.length();

        sb.append("=".repeat(visibleLength)).append("\n");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append("=".repeat(visibleLength)).append("\n");

        return sb.toString();
    }

    public boolean equals(MatrixFun other) {
        if (this.toString().equals(other.toString())) {
            return true;
        }
        return false;
    }

    public boolean equals(int[][] otherMatrix) {
        MatrixFun other = new MatrixFun(otherMatrix);
        return this.equals(other);
    }

    public void replaceAll(int oldValue, int newValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == oldValue) {
                    matrix[i][j] = newValue;
                }
            }
        }
    }

    public void swapRow(int rowA, int rowB) {
        if (rowA < 0 || rowA >= matrix.length || rowB < 0 || rowB >= matrix.length) {
            throw new IllegalArgumentException("Row indices are out of bounds");
        }
        int[] temp = matrix[rowA];
        matrix[rowA] = matrix[rowB];
        matrix[rowB] = temp;
    }

    public void generateRandomNumber(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public void validateRect(int[][] matrix) {
        int rowLength = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != rowLength) {
                throw new IllegalArgumentException("Matrix is not rectangular");
            }
        }
    }
}
