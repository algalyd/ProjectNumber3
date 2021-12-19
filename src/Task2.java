
public class Task2 {

    public static int sumDigits(int number){
        int sum = 0 ;
        while (number > 0){
            sum += number % 10 ;
            number /= 10 ;
        }
        return sum;
    }

    public static boolean isBrothers(int testedNumber1, int testesNumber2){
    boolean isBrothers = false;
    if(sumDigits(testedNumber1) == sumDigits(testesNumber2)){
        isBrothers = true;
    }
    return isBrothers;
    }

    public static int theMostRelativeNumber(int[] arr1, int[] arr2){
        int mostRelativeLocation = -1;
        int currentNumberBrothers;
        int mostRelativeBrothers = 0;

        for (int m = 0; arr1.length > m; m++){
            currentNumberBrothers = 0;
            for (int c = 0; arr2.length > c; c++){
                if (isBrothers(arr1[m] , arr2[c])){
                    currentNumberBrothers = currentNumberBrothers + 1;

                }
                if (currentNumberBrothers > mostRelativeBrothers){
                    mostRelativeBrothers = currentNumberBrothers;
                    mostRelativeLocation = m;
                }
            }
        }
        return mostRelativeLocation;
    }

    public static void main(String[] args) {
        int[] arr1 = {324,423512,34543,453,23423,45674,1332,456546,345435,234234,5};
        int[] arr2 = {111,1221,21,3,666,5,41,221,32};
        System.out.println(isBrothers(122,41));
        System.out.println(isBrothers(15552,882));
        System.out.println(isBrothers(3332,65));
        System.out.println(isBrothers(122,11111));
        System.out.println(isBrothers(122,1111));

        System.out.println(theMostRelativeNumber(arr1, arr2));
    }
}

