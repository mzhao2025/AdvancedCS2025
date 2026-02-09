public class SkyView {
    private double[][] view;

    public SkyView(int numberOfRows, int numberOfCols, double[] scanned) {
        if (numberOfRows <= 0 || numberOfCols <= 0 || scanned == null
                || scanned.length != numberOfRows * numberOfCols) {
            throw new IllegalArgumentException();
        }
        view = new double[numberOfRows][numberOfCols];
        int k = 0;
        for (int r = 0; r < numberOfRows; r++) {
            if (r % 2 == 0) {
                for (int c = 0; c < numberOfCols; c++) {
                    view[r][c] = scanned[k++];
                }
            } else {
                for (int c = numberOfCols - 1; c >= 0; c--) {
                    view[r][c] = scanned[k++];
                }
            }
        }
    }

    public double[][] getView() {
        return view;
    }

    public void setView(double[][] view) {
        this.view = view;
    }

    public double getAverage(int startRow, int endRow, int startCol, int endCol) {
        if (startRow < 0 || endRow >= view.length || startRow > endRow || startCol < 0 || endCol >= view[0].length
                || startCol > endCol) {
            throw new IllegalArgumentException();
        }
        double sum = 0.0;
        int count = 0;
        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                sum += view[r][c];
                count++;
            }
        }
        return sum / count;
    }

    public boolean equals(SkyView other) {
        if (other == null || other.view == null || view == null) {
            return false;
        }
        if (view.length != other.view.length) {
            return false;
        }
        for (int r = 0; r < view.length; r++) {
            if (view[r].length != other.view[r].length)
                return false;
            for (int c = 0; c < view[r].length; c++) {
                if (Double.compare(view[r][c], other.view[r][c]) != 0)
                    return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < view.length; r++) {
            for (int c = 0; c < view[r].length; c++) {
                sb.append(view[r][c]).append(" ");
            }
            if (r < view.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
