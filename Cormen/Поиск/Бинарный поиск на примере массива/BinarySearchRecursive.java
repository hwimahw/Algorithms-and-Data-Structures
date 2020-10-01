public class BinarySearchRecursive{
    public static double[] array = {1,2,3,4,5,6,7};

    public static int binarySearch(double[] array, double key,  int p, int r){
        if(p <= r) {
            int q = (p + r) / 2;
            if (key > array[q]) {
                return binarySearch(array, key, q + 1, r);
            } else if (key < array[q]) {
                return binarySearch(array, key, p, q - 1);
            } else {
                return q;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        int result = binarySearch(array, 7, 0, array.length - 1);
        System.out.println(result);

    }
}
// Рассмотрим наихудший случай: искомого элемента нет в массиве
// Пусть n = 2^k => деление пополам означает уменьшение степени k на 1 (n/2 = 2^k/2 = 2^(k-1)).
// Это будет продолжаться до тех пор пока k не станет равным 0. То есть алгоритм работает за k = log2(2^k) = log2(n)
