public class RecursiveInsertionSort{

    static double[] array = {9,8,7,6,5, -100, -500,-2323, 900, -5, 0, 0, 55, 10000, 34, -9};

    public static void insertionSort(double[] array){
        for(int i = 1; i < array.length; i++){
            double key = array[i];
            int j = i - 1;
            while(j >= 0 && key < array[j]){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void recursiveInsertionSort(double[] array, int i){
        if(i == 0){
            return;
        }
        recursiveInsertionSort(array, i - 1);
        double key = array[i];
        int j = i - 1;
        while(j >= 0 && key < array[j]){
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = key;

    }

    public static void main(String[] args) {
        recursiveInsertionSort(array, array.length - 1);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
