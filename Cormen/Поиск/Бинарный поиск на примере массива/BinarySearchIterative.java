public class BinarySearchIterative{
    public static double[] array = {1,2,3,4,5,6,7,8,9};

    public static int binarySearch(int p, int q, int search){
        while(p <= q) {
            int r = (p + q) / 2;
            if (search < array[r]) {
                q = r - 1;
            }
            if (search > array[r]) {
                p = r + 1;
            }
            if (search == array[r]) {
                return r;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a = binarySearch(0, array.length - 1, 10);
        System.out.println(a);
    }
}
