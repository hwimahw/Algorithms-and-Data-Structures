class FindMaximumSubarray2 {
    public static double[] array = {-1, 1, 2 ,3};

    public static double[] findMaxCrossingSubarray(double[] array, int low, int mid, int high){
        double sum = 0;
        double[] result = new double[3];

        double left_sum = Double.NEGATIVE_INFINITY;
        int max_left = mid;
        for(int i = mid; i >= low; i--){   // Очень важно в левой части начинать бежать с mid, а в правой с mid + 1, (не mid - 1 и mid). Из-за того,что
            sum = sum + array[i];	   // при подсчете серединного индекса, он получается смещенным к левой части в случае четного числа элементов
            if(sum > left_sum){		   // массива. И для двухэлементного массива с индексами 0 1, mid = 0 и mid - 1 уже выходит за пределы массива
                left_sum = sum;        // И следовательно left_sum = Negative_Infinity
                max_left = i;
            }
        }

        sum = 0;
        double right_sum = Double.NEGATIVE_INFINITY;
        int max_right = mid + 1;
        for(int i = mid + 1; i <= high; i++){
            sum = sum + array[i];
            if(sum > right_sum){
                right_sum = sum;
                max_right = i;
            }
        }

        result[0] = max_left;
        result[1] = max_right;
        result[2] = left_sum + right_sum;
        return result;
    }

    public static double[] findMaximumSubarray(double[] array, int low, int high,double[] resultLeft, double[] resultRight){
        if(low == high){
            double[] result = new double[3];
            result[0] = low;
            result[1] = high;
            result[2] = array[low];
            return result;
        }
        int mid = (low + high) / 2;
        resultLeft = findMaximumSubarray(array ,low, mid, resultLeft, resultRight);
        resultRight = findMaximumSubarray(array, mid + 1, high, resultLeft, resultRight);
        double[] resultCross = findMaxCrossingSubarray(array, low, mid, high);
        int a = 4;
        if(resultLeft[2] >= resultCross[2] && resultLeft[2] >= resultRight[2]){
            return resultLeft;
        }
        else if(resultRight[2] >= resultCross[2] && resultRight[2] >= resultLeft[2]){
            return resultRight;
        }
        else{
            return resultCross;
        }
    }

    public static void main(String[] args) {
        double[] resultLeft = new double[3];
        double[] resultRight = new double[3];
        double[] result = findMaximumSubarray(array, 0, array.length - 1,resultLeft, resultRight);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
