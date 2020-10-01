class Selection{
    public static void sort(Comparable[] array){
        int n = array.length;
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(less(array[j], array[min])){
                    min = j;
                }
            }
            exchange(array, i, min);
        }
    }

    public static boolean less(Comparable a, Comparable b){
        if(a.compareTo(b) < 0){
            return true;
        }
        return false;
    }

    public static void exchange(Comparable[] array, int i, int j){
        Comparable c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

    public static void main(String[] args) {
        String[] array = {"ccc", "bbb", "aaa"};
        sort(array);
        int a = 5;
    }
}
