/** Без использования сигнальных элементов (элементов бесконечности)
 */
public class MergeSort2{
    public static double[] array = {9,8,7,6,5,4,3,2,1};


    public static void merge(double[] array, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - (q + 1) + 1;
        double[] arr1 = new double[n1];
        double[] arr2 = new double[n2];
        for(int i = 0; i < n1; i++) {
            arr1[i] = array[p + i];
        }
        for(int i = 0; i < n2; i++){
            arr2[i] = array[q + 1 + i];
        }
        int k = 0;
        int l = 0;
        while(k != n1 && l != n2) {
            if(arr1[k] < arr2[l]){
                array[p] = arr1[k];
                k++;
            }
            else{
                array[p] = arr2[l];
                l++;
            }
            p++;
        }

        if(k == n1){
            for(int i = 0; i < arr2.length - l; i++){
                array[p + i] = arr2[l + i];
            }
        }
        else if (l == n2){
            for(int i = 0; i < arr1.length - k; i++){
                array[p + i] = arr1[k + i];
            }
        }
    }

    public static void mergeSort(int p, int r){
        if(r > p) {
            int q = (r + p) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(array, p, q, r);
        }
    }

    public static void main(String[] args) {
        mergeSort(0, array.length - 1);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

}