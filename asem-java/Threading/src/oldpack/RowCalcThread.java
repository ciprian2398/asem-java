package oldpack;

public class RowCalcThread extends Thread {

    private int[] result;
    private int[][] row;

    public int[] getResult() {
        return result;
    }

    public RowCalcThread(int[][] row) {
        this.row = row;
        result = new int[row[1].length];
    }


    @Override
    public void run() {
        super.run();

        synchronized (this) {
            for (int i = 1; i < row[1].length - 1; i++) {
                result[i] = calc(1, i);
            }
            notify();
        }
    }

    private int calc(int i, int j) {
        return row[i - 1][j - 1] + row[i - 1][j] + row[i - 1][j + 1] +
                row[i][j - 1] + row[i][j] + row[i][j + 1] +
                row[i + 1][j - 1] + row[i + 1][j] + row[i + 1][j + 1];
    }

}

