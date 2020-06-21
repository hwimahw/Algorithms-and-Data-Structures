public class FindMaximumSubarray {

    public static double[] array = {13, -3, -25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

    public static double[] findMaximumSubarray(double[] array){
        double[] result = new double[3];
        result[0] = 0;
        result[1] = 0;
        result[2] = 0;
        double sum = 0;
        double max_sum = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                sum = sum + array[j];
                if(sum > max_sum){
                    max_sum = sum;
                    result[0] = i;
                    result[1] = j;
                    result[2] = max_sum;
                }
            }
            sum = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = findMaximumSubarray(array);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}

/*
i = 0: совершается n итераций
i = 1: совершается  n - 1 итераций
.....
i = n: совершается 0 итераций
Итого время работы алгоритма = n + (n-1) + (n-2) +... + 1 = ((n+1)*n)/2
за n^2

Инвариант цикла:
В max_sum содержится макисмальная сумма подмассива массива A[i...j],
то есть на каждой i-той итерации находится максимальная сумма подмассива масива A[i...n]
*/