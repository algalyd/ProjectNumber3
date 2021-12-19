public class Task5 {
    public static void main(String[] args) {
        System.out.println(charFrequencyReplacement("ababababmmgrjgktrgjntkjgnababababababababababababa"));

    }

    public static String charFrequencyReplacement(String stringInput) {
        char mostFrequencyChar;
        char secondMostFrequencyChar;
        String withoutMostFrequencyChar = "";
        String stringAfterChange = "";

        mostFrequencyChar = mostFrequencyChar(stringInput);

        for (int c = 0; stringInput.length() > c; c++) {
            if (stringInput.charAt(c) != mostFrequencyChar) {
                withoutMostFrequencyChar = withoutMostFrequencyChar + stringInput.charAt(c);
            }
        }

        secondMostFrequencyChar = mostFrequencyChar(withoutMostFrequencyChar);

        for (int l = 0; stringInput.length() > l; l++){
            if (stringInput.charAt(l) == mostFrequencyChar){
                stringAfterChange = stringAfterChange + secondMostFrequencyChar;
            }
            else if (stringInput.charAt(l) == secondMostFrequencyChar){
                stringAfterChange = stringAfterChange + mostFrequencyChar;
            }
            else {
                stringAfterChange = stringAfterChange + stringInput.charAt(l);
            }
        }

        return stringAfterChange;
    }

    public static char mostFrequencyChar(String testedString){
        char mostFrequencyChar = ' ';
        int counterCharFrequency;
        int counterMostFrequencyChar = 0;


        for (int i = 0; testedString.length() > i; i++) {
            counterCharFrequency = 0;

            for (int m = 0; testedString.length() > m; m++) {
                if (testedString.charAt(i) == testedString.charAt(m)) {
                    counterCharFrequency = counterCharFrequency + 1;
                }

            }
            if (counterCharFrequency > counterMostFrequencyChar) {
                counterMostFrequencyChar = counterCharFrequency;
                mostFrequencyChar = testedString.charAt(i);
            }

        }
        return mostFrequencyChar;
    }
}