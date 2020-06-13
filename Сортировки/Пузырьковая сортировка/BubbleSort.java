public class BubbleSort {

    public static int[] array = {9,8,7,6,5,4,3,2,1};

    public static void bubbleSort1() {
        for(int i = 0; i < array.length; i++) {
            for(int j = 1; j < array.length - i; j++) {   // здесь в наилучшем случае и в наихудшем случае алгоритм работает за n^2
                if(array[j] < array[j - 1]){
                    int c = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = c;
                }
            }
        }
    }

    public static void bubbleSort2() {
        int flag;
        do {
            flag = 0;
            for(int i = 1; i < array.length; i++){      // здесь в наихудшем случае алгоритм работает за n^2, но в наилучшем случае - за n.
                if(array[i] < array[i - 1]) {
                    int c = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = c;
                    flag = 1;
                }
            }
        } while(flag == 1);
    }

    public static void main(String[] args) {
        bubbleSort2();
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
// Инвариант цикла 7-13: "Наибольший элемент массива A[0...j] встает на последнее место (A[j]] - наибольший элемент массива A[0...j])"
// Инвариант цикла 6 - 14: "Наибольший элемент массива A[0...n-1-i] встает на последнее место n-1-i 
//(A[n-1-i] - наибольший элемент массива A[0...n-1-i])"

/* Предположим, что счет в массиве ведется с единицы.
Инвариант для внешнего цикла: максимальный элемент массива A[1..n-i+1] лежит в A[n-i+1]
Инвариант для внутреннего цикла: максимальный элемент массива A[1..j] лежит в A[j]

 */
