public class InsertionSort {
    public static int[] array = {5,4,3,2,1};

    public static void insertionSort(){
        for(int i = 0; i < array.length; i++){
            int key  = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    public static void main(String[] args){
        insertionSort();
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
