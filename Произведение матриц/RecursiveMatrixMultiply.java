public class RecursiveMatrixMultiply {
    public static double[][] matrA = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    public static double[][] matrB = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    public static int n = 4;

    public static double[][] recursiveMatrixMultiply(double[][] matrA, double[][] matrB, int n, int startRowA, int finishRowA, int startColumnA, int finishColumnA, int startRowB, int finishRowB, int startColumnB, int finishColumnB){
        double[][] matrC = new double[n][n];
        if(n == 1){
            matrC[0][0] = matrA[startRowA][startColumnA] * matrB[startRowB][startColumnB];
        } else {
            sumOfMatrixes(recursiveMatrixMultiply(matrA, matrB, n / 2,  startRowA, (startRowA + finishRowA)/2, startColumnA, (startColumnA + finishColumnA)/2, startRowB, (startRowB + finishRowB)/2, startColumnB, (startColumnB + finishColumnB)/2), recursiveMatrixMultiply(matrA, matrB, n / 2, startRowA, (startRowA + finishRowA)/2, ((startColumnA + finishColumnA)/2) + 1, finishColumnA , ((startRowB + finishRowB)/2) + 1, finishRowB, startColumnB, (startColumnB + finishColumnB)/2), matrC, 0, n/2 - 1, 0, n/2 - 1);
            sumOfMatrixes(recursiveMatrixMultiply(matrA, matrB, n / 2,  startRowA, (startRowA + finishRowA)/2, startColumnA, (startColumnA + finishColumnA)/2, startRowB, (startRowB + finishRowB)/2, ((startColumnB + finishColumnB)/2) + 1, finishColumnB), recursiveMatrixMultiply(matrA, matrB, n / 2, startRowA, (startRowA + finishRowA)/2, ((startColumnA + finishColumnA)/2) + 1, finishColumnA , ((startRowB + finishRowB)/2) + 1, finishRowB, ((startColumnB + finishColumnB)/2) + 1, finishColumnB), matrC, 0, n/2 - 1, n/2, n - 1);
            sumOfMatrixes(recursiveMatrixMultiply(matrA, matrB, n / 2,  ((startRowA + finishRowA)/2) + 1, finishRowA, startColumnA, (startColumnA + finishColumnA)/2, startRowB, (startRowB + finishRowB)/2, startColumnB, (startColumnB + finishColumnB)/2), recursiveMatrixMultiply(matrA, matrB, n / 2, ((startRowA + finishRowA)/2) + 1, finishRowA, ((startColumnA + finishColumnA)/2) + 1, finishColumnA , ((startRowB + finishRowB)/2) + 1, finishRowB, startColumnB, (startColumnB + finishColumnB)/2), matrC, n/2, n - 1, 0, n/2 - 1);
            sumOfMatrixes(recursiveMatrixMultiply(matrA, matrB, n / 2,  ((startRowA + finishRowA)/2) + 1, finishRowA, startColumnA, (startColumnA + finishColumnA)/2, startRowB, (startRowB + finishRowB)/2, ((startColumnB + finishColumnB)/2) + 1, finishColumnB), recursiveMatrixMultiply(matrA, matrB, n / 2, ((startRowA + finishRowA)/2) + 1, finishRowA, ((startColumnA + finishColumnA)/2) + 1, finishColumnA , ((startRowB + finishRowB)/2) + 1, finishRowB, ((startColumnB + finishColumnB)/2) + 1, finishColumnB), matrC, n/2,n - 1,  n/2, n - 1);
            // в функции sumOfMatrixes в нужную часть матрицы C записывается сумма матриц A и B с размерами n/2
        }

        return matrC;
    }


    public static void sumOfMatrixes(double[][] matrA, double[][] matrB, double[][] matrC, int startRow, int finishRow, int startColumn, int finishColumn) {
        int k = 0;
        int l = 0;
        for (int i = startRow; i <= finishRow; i++) {
            for (int j = startColumn; j <= finishColumn; j++) {
                matrC[i][j] = matrA[k][l] + matrB[k][l];
                l++;
            }
            l = 0;
            k++;
        }
    }




    public static void main(String[] args) {
        double[][] result = recursiveMatrixMultiply(matrA,  matrB, n, 0, n-1, 0, n-1, 0, n-1, 0, n-1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}