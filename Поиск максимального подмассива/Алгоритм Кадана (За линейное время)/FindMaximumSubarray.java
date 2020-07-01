public class FindMaximumSubarray {

    public static double[] array = {13, -3, -25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

    public static double[] findMaximumSubarray(double[] array){
        double[] result = new double[3];
        double max_sum = Double.NEGATIVE_INFINITY;
        double sum = 0;
        result[0] = 0;
        result[1] = 0;
        result[2] = Double.NEGATIVE_INFINITY;

        int leftMax = 0;
        int rightMax = 0;
        int flag = 1;

        for(int i = 0; i < array.length; i++){
            if(flag == 1){
                leftMax = i;
                flag = 0;
            }
            sum = sum + array[i];
            if(sum > max_sum){
                rightMax = i;
                max_sum = sum;
            }
            if(sum < 0){
                sum = 0;
                flag = 1;
            }

        }
        result[0] = leftMax;
        result[1] = rightMax;
        result[2] = max_sum;
        return result;
    }

    public static void main(String[] args) {
        double[] result = findMaximumSubarray(array);

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}

/*
Рассмотрим массив a[] из n элементов a0, a1, a2,… an-1.
Будем идти по массиву и накапливать в некоторой переменной sum текущую частичную сумму.
Если в какой-то момент sum окажется отрицательной, то мы просто присвоим sum = 0.
Максимум из всех значений переменной sum, случившихся за время работы, и будет ответом на задачу.
Этот алгоритм называется Алгоритмом Кадана. Время выполнения — O(n), т.к. мы осуществляем один проход по массиву a[] из n элементов.
Условие по дополнительной памяти — O(1).
*/
