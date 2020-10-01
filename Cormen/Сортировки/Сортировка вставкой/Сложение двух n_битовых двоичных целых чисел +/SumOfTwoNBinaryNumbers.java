
class SumOfTwoNBinaryNumbers{
    static int n = 5;
    public static int[] n1 = {1,1,1,1,1};
    public static int[] n2 = {1,1,1,1,1};
    public static int[] result = new int[n + 1];

    public static int[] sum(int n, int[] n1, int[] n2) {
        int add = 0;
        for(int i = n1.length - 1; i >= 0; i--) {
            int sum = n1[i] + n2[i] + add;
            if (sum == 0 || sum == 1) {
                result[i + 1] = sum;
                add = 0;
            }
            if(sum == 2) {
                result[i + 1] = 0;
                add = 1;
                if(i == 0){
                    result[i] = 1;
                }
            }
            if(sum == 3){
                result[i + 1] = 1;
                add = 1;
                if(i == 0){
                    result[i] = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = sum(n, n1, n2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }

    }

}
