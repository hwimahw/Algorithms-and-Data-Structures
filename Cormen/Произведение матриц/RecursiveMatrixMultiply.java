public class RecursiveMatrixMultiply{

    static int[][] A = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    static int[][] B = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};


    public static void main(String[] args) {
      int[][]C =  multiply(A, B, 0, 3, 0, 3,
              0, 3, 0, 3, 4);
      for(int i = 0; i < 4; i++){
          for(int j = 0; j < 4; j++){
              System.out.print(C[i][j] + " ");
          }
          System.out.println();
      }
    }

    public static int[][] multiply(int[][] A, int[][] B, int beginColumnA, int endColumnA,
                                int beginRowA, int endRowA,int beginColumnB, int endColumnB,
                                   int beginRowB, int endRowB , int n){
        if(n == 1){
            int[][] C = new int[1][1];
            C[0][0] = A[beginRowA][beginColumnA] * B[beginRowB][beginColumnB];
            return C;
        }
        int[][] C11 = matriceSum(multiply(A, B, beginColumnA, (beginColumnA + endColumnA)/2, beginRowA, (beginRowA + endRowA)/2,
                beginColumnB,  (beginColumnB + endColumnB)/2, beginRowB, (beginRowB + endRowB)/2, n/2),
                multiply(A, B, (beginColumnA + endColumnA)/2 + 1, endColumnA, beginRowA, (beginRowA + endRowA)/2,
                        beginColumnB, (beginColumnB + endColumnB)/2, (beginRowB + endRowB)/2 + 1, endRowB,n/2), n/2);
        int[][] C12 = matriceSum(multiply(A, B, beginColumnA, (beginColumnA + endColumnA)/2, beginRowA, (beginRowA + endRowA)/2,
                (beginColumnB + endColumnB)/2 + 1, endColumnB, beginRowB, (beginRowB + endRowB)/2, n/2),
                multiply(A, B, (beginColumnA + endColumnA)/2 + 1, endColumnA, beginRowA, (beginRowA + endRowA)/2,
                        (beginColumnB + endColumnB)/2 + 1, endColumnB, (beginRowB + endRowB)/2 + 1, endRowB,n/2), n/2);
        int[][] C21 = matriceSum(multiply(A, B, beginColumnA, (beginColumnA + endColumnA)/2, (beginRowA + endRowA)/2 + 1, endRowA,
                beginColumnB, (beginColumnB + endColumnB)/2, beginRowB, (beginRowB + endRowB)/2, n/2),
                multiply(A, B, (beginColumnA + endColumnA)/2 + 1, endColumnA, (beginRowA + endRowA)/2 + 1, endRowA,
                        beginColumnB, (beginColumnB + endColumnB)/2, (beginRowB + endRowB)/2 + 1, endRowB, n/2), n/2);
        int[][] C22 = matriceSum(multiply(A, B, beginColumnA, (beginColumnA + endColumnA)/2, (beginRowA + endRowA)/2 + 1, endRowA,
                (beginColumnB + endColumnB)/2 + 1, endColumnB, beginRowB, (beginRowB + endRowB)/2, n/2),
        multiply(A, B, (beginColumnA + endColumnA)/2 + 1, endColumnA, (beginRowA + endRowA)/2 + 1, endRowA,
                (beginColumnB + endColumnB)/2 + 1, endColumnB, (beginRowB + endRowB)/2 + 1, endRowB, n/2), n/2);
        int[][] C = combineIntoOneMatrice(C11, C12, C21, C22, n);
       return C;

    }

    public static int[][] matriceSum(int[][] A, int[][] B, int n){
        int[][] C = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] combineIntoOneMatrice(int[][] C11, int[][] C12,
                                                int[][] C21, int[][] C22, int n){
       int k = 0;
       int l = 0;
        int[][] C = new int[n][n];
        for(int i = 0; i <= n/2 - 1; i++){
            for(int j = 0; j <= n/2 - 1; j++){
                C[i][j] = C11[k][l];
                l++;
            }
            k++;
            l = 0;
        }
        k = 0;
        l = 0;
        for(int i = 0; i <= n/2 - 1; i++){
            for(int j = n/2; j <= n - 1; j++){
                C[i][j] = C12[k][l];
                l++;
            }
            k++;
            l = 0;
        }
        k = 0;
        l = 0;
        for(int i = n/2; i <= n - 1; i++){
            for(int j = 0; j <= n/2 - 1; j++){
                C[i][j] = C21[k][l];
                l++;
            }
            k++;
            l = 0;
        }
        k = 0;
        l = 0;
        for(int i = n/2; i <= n - 1; i++){
            for(int j = n/2; j <= n - 1; j++){
                C[i][j] = C22[k][l];
                l++;
            }
            k++;
            l = 0;
        }

        return C;

    }
}
