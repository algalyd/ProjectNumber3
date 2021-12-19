public class Task3 {
    public static void main(String[] args) {
        int[] arr = numberFactorization(12600);
        for (int m = 0; arr.length > m; m++){
            System.out.println(arr[m]);
        }
    }

    public static int[] numberFactorization(int factorizeNumber){
        int counter7 = 0;
        int counter5 = 0;
        int counter3 = 0;
        int counter2 = 0;
        int c2;
        int c3;
        int c5;
        int c7;

        while (factorizeNumber % 7 == 0){
            factorizeNumber = factorizeNumber/7;
            counter7 = counter7 + 1;
        }
        while (factorizeNumber % 5 == 0){
            factorizeNumber = factorizeNumber/5;
            counter5 = counter5 + 1;
        }
        while (factorizeNumber % 3 == 0){
            factorizeNumber = factorizeNumber/3;
            counter3 = counter3 + 1;
        }
        while (factorizeNumber % 2 == 0){
            factorizeNumber = factorizeNumber/2;
            counter2 = counter2 + 1;
        }

        int[] array = new int[counter7+counter5+counter3+counter2];

        for (c2 = 0; counter2 > c2 ; c2++){
            array[c2] = 2;
        }
        for (c3 = 0; counter3 > c3 ; c3++){
            array[c2+c3] = 3;
        }
        for (c5 = 0; counter5 > c5 ; c5++){
            array[c2+c3+c5] = 5;
        }
        for (c7 = 0; counter7 > c7 ; c7++){
            array[c2+c3+c5+c7] = 7;
        }

        return array;
    }
}
