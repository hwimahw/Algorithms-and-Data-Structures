package pr;

public class FibonacciMatrix {

    public static final int[][] matrix = {{0,1}, {1,1}};
//    public static final int[] vector = {0, 1};

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println(fastFibonacci(6));
        System.out.println(fastRecursiveFibonacci(6));
    }

    public static int[] multiplicationVectorMatrix(int[] vector, int[][] matrix){
        int[] result = new int[2];
        result[0] = vector[0] * matrix[0][0] + vector[1] * matrix[1][0];
        result[1] = vector[0] * matrix[0][1] + vector[1] * matrix[1][1];
        return result;
    }

    public static int[][] multiplyTwoMatrixes(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        return C;
    }

    public static int fibonacci(int n){
        int[] result = {0, 1};
        for(int i = 0; i < n; i++){
            result = multiplicationVectorMatrix(result, matrix);
        }
        return result[0];
    }

    public static int fastFibonacci(int n){
        int[][] C = {{0,1},{1,1}};
        int[][] B = {{1,0},{0,1}};
        int[] result = {0, 1};
        while(n != 0){
            if(n % 2 == 0){
                C = multiplyTwoMatrixes(C, C);
                n = n / 2;
            }else{
                B = multiplyTwoMatrixes(B, C);
                n = n - 1;
            }
        }
        result = multiplicationVectorMatrix(result, B);
        return result[0];
    }

    public static int fastRecursiveFibonacci(int n){
        int[][] C = {{0,1},{1,1}};
        int[][] B = {{1,0},{0,1}};
        return fastRecursiveFibonacciIter(C, B, n);
    }

    public static int fastRecursiveFibonacciIter(int[][] C, int[][] B, int n){
        if(n == 0){
            int[] result = {0, 1};
            result =  multiplicationVectorMatrix(result, B);
            return result[0];
        }
        if(n % 2 == 0){
            return fastRecursiveFibonacciIter(multiplyTwoMatrixes(C, C), B, n / 2);
        }else{
            return fastRecursiveFibonacciIter(C, multiplyTwoMatrixes(C, B), n - 1);
        }
    }

}
