public class FindTwoElementsForSum{

    public static double[] array = {5, 5, 8,4,2,101};

    public static int findIndexOfSecondElement(double[] array, double sum){
        int indexOfSecondElement = -1;
        for(int i = 0; i < array.length; i++){
            double key = sum - array[i];
            indexOfSecondElement = binarySearch(array, key, 0, array.length - 1);
            if(indexOfSecondElement != -1 && indexOfSecondElement != i){
                System.out.println(array[i]);
                return indexOfSecondElement;
            }
        }
        return -1;
    }

    public static int binarySearch(double[] array, double key, int p, int r){
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

    public static void merge(int p, int q, int r) {
        double[] arr1 = new double[q - p + 1 + 1];
        double[] arr2 = new double[r - (q + 1) + 1 + 1];
        for(int i = 0; i < arr1.length - 1; i++) {
            arr1[i] = array[p + i];
        }
        for(int i = 0; i < arr2.length - 1; i++) {
            arr2[i] = array[q + 1 + i];
        }
        arr1[arr1.length - 1] = Double.POSITIVE_INFINITY;
        arr2[arr2.length - 1] = Double.POSITIVE_INFINITY;
        int k = 0;
        int l = 0;
        for(int i = p; i <= r; i++){
            if(arr1[k] < arr2[l]){
                array[i] = arr1[k];
                k++;
            }
            else {
                array[i] = arr2[l];
                l++;
            }
        }

    }

    public static void mergeSort(int p, int r){
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }


    public static void main(String[] args){
        double sum = 108;
        mergeSort(0, array.length - 1);
        int indexOfSecondElement = findIndexOfSecondElement(array, sum);
        if(indexOfSecondElement != -1){
            System.out.println(array[indexOfSecondElement]);
        }
        else{
            System.out.println(-1);
        }
    }

}
/* Сначала за сортировкой слиянием за n*log2(n) отсортировал массив. Затем каждой итерации i цикла for бинарным поиском за
log2(n) ищу элемент элемент = значение суммы - array[i];
Итого: nlog2(n) + nlog2(n) = 2nlog2(n), то есть время работы программы nlog2(n);
 */