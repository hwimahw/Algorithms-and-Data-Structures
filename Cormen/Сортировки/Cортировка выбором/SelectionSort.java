public class SelectionSort {

    public static double[] array = {9,8,7,6,5,4,3,2,1, 100,0,-1,-2,-100,-55, 23,1,1,1,4,4,44, -100};

    public static int findIndexOfMin(double[] array, int start){
        double min = array[start];
        int indexOfMin = start;
       // System.out.println(start);
        for(int i = start; i < array.length; i++){
                    if(array[i] < min){
                        min = array[i];
                        indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    public static void swap(double[] array, int i, int j){
        double c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

    public static void sorting(double[] array){
        for(int i = 0; i < array.length - 1; i++){
            int indexOfMin = findIndexOfMin(array, i);
           // System.out.println(indexOfMin);
            swap(array, i, indexOfMin);
        }
    }
    public static void main(String[] args) {
        sorting(array);
       // System.out.println(findIndexOfMin(array));
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }
}
