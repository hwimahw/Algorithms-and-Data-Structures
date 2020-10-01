public class MergeSort{
    public static double[] array = {9,8,7,6,5};

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

    public static void main(String[] args) {
        mergeSort(0, 4);
       // mergeSort(0, array.length - 1);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

}
