import java.lang.String;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {111,3453463,687767,23423545,43534,46,42435,33,1134,33};
        System.out.println(smallestChangeNumber(arr));
        System.out.println(isChangeNumber(163458));
        System.out.println(isChangeNumber(1634589));
        System.out.println(isChangeNumber(163789));
        System.out.println(isChangeNumber(6));
        System.out.println(isChangeNumber(12));
    }

    public static boolean isChangeNumber(int testedNumber){
        int i;
        int leftNumber;
        int rightNumber;
        boolean isChangeNumbers = true;
        String numberAsString = Integer.toString(testedNumber);

        for (i = 0; i < numberAsString.length()-1; i++){        //I used ascii values because like the numbers, ascii values are following each other
            leftNumber = numberAsString.charAt(i);
            rightNumber = numberAsString.charAt(i+1);
            if (leftNumber%2 == 0 && rightNumber%2 == 0 || leftNumber%2 != 0 && rightNumber%2 != 0){
                isChangeNumbers = false;
                break;
            }
        }return isChangeNumbers;
    }

    public static int smallestChangeNumber(int[] arr){
        int c;
        int smallestNumberIndex = -1;
        int smallestNumber = 0;
        int currentNumber;
        int arrayPartCopy;


        for (c = 0; c < arr.length; c++){
            if (isChangeNumber(arr[c])){
                arrayPartCopy = arr[c];
                smallestNumber = numberDigitsSum(arrayPartCopy);
                smallestNumberIndex = c;
                break;
                }
        }


        for (; c < arr.length; c++){
            arrayPartCopy = arr[c];
            currentNumber = numberDigitsSum(arrayPartCopy);

            if (isChangeNumber(arr[c]) && currentNumber < smallestNumber ){
                smallestNumber = currentNumber;
                smallestNumberIndex = c;
            }
        }
        return smallestNumberIndex;
    }

    public static int numberDigitsSum(int number){
        int digitsSum = 0;
        while (number%10 != 0 ) {
            digitsSum += number % 10;
            number /= 10;
        }
        return digitsSum;
    }
}