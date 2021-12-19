public class Task4 {
    public static int[] sortingArray(int [] arr){
        int temp;
        for (int i = 0; i < arr.length ; ++i){
            for (int j = 0 ; j< arr.length -1 ; ++j){
                if (arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static boolean isFullGoesDownArray(int [] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length-1; ++i)
            if (arr[i + 1] != (arr[i] - 1)) {
                flag = false;
                break;
            }
        return flag;
    }

    public static boolean isFullArray(int [] arr){
        arr = sortingArray(arr);
        return isFullGoesDownArray(arr);
    }
    public static void main(String[] args) {
        System.out.println(isFullArray(new int[]{15,28,90,-21,-12,-100}));
        System.out.println(isFullArray(new int[]{11,19,12,15,14,13,20,16,18,17}));
        System.out.println(isFullGoesDownArray(new int[]{11,19,12,15,14,13,20,16,18,17}));
        System.out.println(isFullGoesDownArray(new int[]{20,19,18,17,16,15,14,13}));
    }
}
