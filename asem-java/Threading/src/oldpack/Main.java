package oldpack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Main();
    }

    public Main() throws InterruptedException {
        job();
    }

    private int[][] mat = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 2, 2, 2, 2, 2, 0},
            {0, 3, 3, 3, 3, 3, 0},
            {0, 4, 4, 4, 4, 4, 0},
            {0, 5, 5, 5, 5, 5, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };


    private void job() throws InterruptedException {
        printMat();

        Performance.start();

        long start = System.currentTimeMillis();

        int[] auxResult = new int[]{0,0,0,0,0,0,0};
        for (int i = 1; i < mat.length - 1; i++) {
            int[][] row = new int[][]{mat[i - 1], mat[i], mat[i + 1]};

            mat[i-1] = auxResult;
            RowCalcThread rowCalcThread = new RowCalcThread(row);
            rowCalcThread.start();

            synchronized (rowCalcThread) {
                rowCalcThread.wait();
            }

            auxResult = rowCalcThread.getResult();

            //last row
            if (i == mat.length-2) mat[i] = auxResult;
        }

        Performance.stop();

        printMat();
    }

    private void printMat() {
        for (int i = 0; i < mat.length; i++) {
            Arrays.stream(mat[i]).forEach((n) -> System.out.print(n + "\t"));
            System.out.println();
        }
    }

}
