public class RecursiveInsertionSort2{

    public static void insertionsSort(double[] array){
        for(int i = 1; i < array.length; i++){
            double key = array[i];
            insertionsSortIter(i - 1, key, array);
        }
    }

    private static void insertionsSortIter(int i, double key, double[] array){
        if(i < 0){
            array[i + 1] = key;
            return;
        }

        if(key < array[i]){
            array[i + 1] = array[i];
        }
        else if(key >= array[i]){
            array[i + 1] = key;
        }
        insertionsSortIter(i - 1, key, array);

    }


    public static void main(String[] args) {
        double[] array = {9,8,7,6,5,4,3,2,1};
        insertionsSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
