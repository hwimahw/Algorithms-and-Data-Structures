public class QuantityOfInversionsInArray{
    public static double[] array = {5,4,3,2,1};

    public static void merge(int p, int q, int r, int[] result) {
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
                //System.out.println(arr1.length);
                array[i] = arr1[k];
                k++;
            }
            else {
                if(arr2[l] != arr1[k]) {
                // если элемент arr2[l] < arr1[k], то arr2[l] автоматически становится
                // меньше чем все следующие элементы arr1[(k + 1)...(length - 1)]
                // Вычитается единица, так как в массивах arr содержатся сигнальные элементы
                    result[0] = result[0] + arr1.length - 1 - k; 
                }
                array[i] = arr2[l];
                l++;
            }
        }

    }

    public static void mergeSort(int p, int r, int[] result){
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q, result);
            mergeSort(q + 1, r, result);
            merge(p, q, r, result);
        }
    }

    public static void main(String[] args) {
        int[] result = {0};
        mergeSort(0, 4, result);
        System.out.println(result[0]);
        // mergeSort(0, array.length - 1);
        /*for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }*/
    }

}