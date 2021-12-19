import java.util.Scanner;
public class Task7 {
    public static boolean isValidEquation(String quadraticEquation) {
        boolean isValidEquation=true;
        int[]equationParts={'x','^','-','+','1','2','3','4','5','6','7','8','9'};
        int[] numbers ={'1','2','3','4','5','6','7','8','9'};
        int m;
        int t;

        for(m =0; m<quadraticEquation.length()-3; m++) {
            if(isValidEquation){
                isValidEquation = false;
                for (t=0;t<equationParts.length;t++){
                    if (quadraticEquation.charAt(m) == equationParts[t])
                        isValidEquation = true;
                }}}

        if(quadraticEquation.length() > 12 || quadraticEquation.length()<8){
            return true;}

        if(quadraticEquation.length()>=9 && quadraticEquation.charAt(6)!='x' && quadraticEquation.charAt(7)!='x'){
            isValidEquation=false;}
        if(quadraticEquation.charAt(0)!='-'&&quadraticEquation.length()==12){
            return true;
        }
        if(quadraticEquation.charAt(quadraticEquation.length()-1)!='0'|| quadraticEquation.charAt(quadraticEquation.length()-2)!='='){
            isValidEquation=false;}

        int signSpot = quadraticEquation.charAt(quadraticEquation.length() - 4);
        int numSpot = quadraticEquation.charAt(quadraticEquation.length() - 3);
        if(numSpot!='x' && signSpot!='-'&& signSpot!='+')
            isValidEquation=false;

        if(isValidEquation){
            if((quadraticEquation.charAt(1)!='x'|
                    quadraticEquation.charAt(2)!='^'|
                    quadraticEquation.charAt(3)!='2')|
                    (quadraticEquation.charAt(0)=='-'&&
                            quadraticEquation.charAt(2)!='x'|
                                    quadraticEquation.charAt(3)!='^'|
                                    quadraticEquation.charAt(4)!='2')){
                isValidEquation=false;}}

        if(quadraticEquation.charAt(0)!='-'){
            if(quadraticEquation.charAt(4)!='-'&&
                    quadraticEquation.charAt(4)!='+'){
                if(quadraticEquation.charAt(4)!='=')
                    isValidEquation=false;}
        }
        if(quadraticEquation.charAt(0)=='-'){
            if(quadraticEquation.charAt(5)!='-'&&
                    quadraticEquation.charAt(5)!='+'){
                if(quadraticEquation.charAt(5)!='=')
                    isValidEquation=false;}
        }
        if(quadraticEquation.charAt(0)!='-'){
            m=0;
            while (m!=numbers.length-1&&quadraticEquation.charAt(5)!=numbers[m]&&
                    quadraticEquation.charAt(6)!='='){
                m++;}
            if (m==numbers.length-1){
                isValidEquation=false;}

        }
        if(quadraticEquation.charAt(0)=='-'){
            m=0;
            if(quadraticEquation.charAt(0)!='-'){
                while (quadraticEquation.charAt(6) != numbers[m] | quadraticEquation.charAt(7) != numbers[m] && quadraticEquation.charAt(m) != '='){
                    m++;
                    if (m == numbers.length - 1) {
                        isValidEquation = false;
                        break;
                    }
                }
            }

            if(quadraticEquation.charAt(0)=='-'){
                while ((quadraticEquation.charAt(6)!=numbers[m] &&
                        quadraticEquation.charAt(7)!='=')){
                    m++;
                    if (m == numbers.length - 1) {
                        isValidEquation = false;
                        break;
                    }}}

        }
        return isValidEquation;
    }
    public static int aValue(String quadraticEquation){
        int intChanger = '0';
        int a = 0;
        if(quadraticEquation.charAt(0)!='-')
            a=quadraticEquation.charAt(0)-intChanger;
        else if (quadraticEquation.charAt(0)=='-')
            a=(quadraticEquation.charAt(1)-'0')*-1;
        return a;
    }
    public static int bValue(String quadraticEquation){
        int intChanger = '0';
        int b = 0;
        if(quadraticEquation.charAt(6)=='x')
            b = quadraticEquation.charAt(5)-intChanger;
        if(quadraticEquation.charAt(4)=='-')
            b=-b;

        if(quadraticEquation.charAt(7)=='x')
            b=quadraticEquation.charAt(6);
        if(quadraticEquation.charAt(5)=='-')
            b=-b;

        return b;
    }
    public static int cValue(String quadraticEquation) {
        int c = 0;
        int intChanger = '0';
        int signLocation = (quadraticEquation.length() - 4);
        int cLocation = (quadraticEquation.length() - 3);

        if(quadraticEquation.charAt(signLocation)=='+'){
            c=quadraticEquation.charAt(cLocation)-intChanger;
        }
        else if(quadraticEquation.charAt(signLocation)=='-'){
            c=-(quadraticEquation.charAt(cLocation)-intChanger);}
        return c;
    }
    public static void quadraticEquationSolution(int aValue, int bValue, int cValue){
        double quadraticEquationCalculate1;
        double quadraticEquationCalculate2;
        double quadraticEquationCalculate3;
        double quadraticEquationCalculate4;
        double quadraticEquationFirstSolution;
        double quadraticEquationSecondSolution;

        quadraticEquationCalculate1 = bValue * bValue;
        quadraticEquationCalculate2 = (-4) * aValue * cValue;
        quadraticEquationCalculate3 = quadraticEquationCalculate1 + quadraticEquationCalculate2;
        quadraticEquationCalculate4 = Math.sqrt(quadraticEquationCalculate3);

        quadraticEquationFirstSolution = ((-bValue) + quadraticEquationCalculate4) / (2 * aValue);
        quadraticEquationSecondSolution = ((-bValue) - quadraticEquationCalculate4) / (2 * aValue);


        if (quadraticEquationFirstSolution == quadraticEquationSecondSolution) {
            System.out.println("There is only one solution for this quadratic equation: X = " + quadraticEquationFirstSolution);
        }
        else if ((Double.isNaN(quadraticEquationFirstSolution)) & (Double.isNaN(quadraticEquationSecondSolution))) {
            System.out.println("There is two solutions for this quadratic equation: X1 = " + quadraticEquationFirstSolution + " and X2 = " + quadraticEquationSecondSolution);
        }
        else {
            System.out.println("There is no solution for this quadratic equation");
        }
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String quadraticEquation;
        int aValue;
        int bValue;
        int cValue;
        System.out.println(isValidEquation("3x^2-6x-9=0"));
        System.out.println("Enter quadratic equation in the following format - ax^2+bx+c=0 :");
        quadraticEquation = scanner.next();
        if (isValidEquation(quadraticEquation)){
            aValue = aValue(quadraticEquation);
            bValue = bValue(quadraticEquation);
            cValue = cValue(quadraticEquation);
            quadraticEquationSolution(aValue, bValue, cValue);}
        else System.out.println("your equation format invalid");

    }
}