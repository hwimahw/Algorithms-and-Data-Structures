public class InsertionSortWithBinarySearch2{
    public static double[] array = {9,8,7,6,5,7,1,2,6,4,456,876,234,888,-1,-6,-9000,5,6,7,7,3,2};

    public static void sort(double[] array){
        for(int i = 1; i < array.length; i++){
            double key = array[i];
            int j = i - 1;
            int l = binarySearch(array, key, 0, j);
            for(int k = i; k > l; k--){
               array[k] = array[k - 1];
            }
            array[l] = key;
        }
    }

    public static int binarySearch(double[] array, double key, int p, int r){
        // здесь есть изменения c подаваемыми в функции индексами, если сравнивать с обычным бинарным поиском.
        // теперь такого, что p > r не произойдет, то есть выражение return -1 никогда не достигнется.
        if(p < r) {
            int q = (p + r) / 2;
            if (key > array[q]) {
                return binarySearch(array, key, q + 1, r);
            } else if (key < array[q]) {
                return binarySearch(array, key, p, q);    // ИЗМЕНЕНИЕ
            } else {
                return q;
            }
        }
        if(p == r){
            if(key < array[p]){
                return p;
            }
            else{
                return p + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        sort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }


}