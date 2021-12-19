
public class Task6 {
    // check if char is number between 0 to 9
    public static boolean isDigit(char c){
        if(c >= '0' && c <= '9')
            return true;
        else
            return false;
    }
    // casting string to number
    public static int isDigit2(String str){
        int len = str.length() -1;
        int i = 0;
        int number =0 ;
        while (len >=0){
            number += Math.pow(10,len)*(str.charAt(i)-'0');
            i++;
            len-- ;
        }
        return number;
    }
    // if it's operation
    public static boolean isOp(char c){
        if(c == '+' || c == '-' || c == '*' || c == '/')return true;
        return false;
    }
    // find ( )
    public static int findPrac(String str , int start , int end){
        int count = 0;
        int i = start;
        while(i <= end){
            if(str.charAt(i) == '(') count++;
            if(str.charAt(i) == ')')
                if(count == 0) return i;
                else{
                    count--;
                }
            i++;
        }
        return -1;
    }
    public static boolean  isValidExp_aux(String str , int start , int end ){
        if(end < start)
            return false;
        if(start == end){
            if(isDigit(str.charAt(start)))
                return true;
            else
                return false;
        }
        int i = start;
        if(str.charAt(i) == '(') {
            int j = findPrac(str , i+1 , end);
            if(j == -1) return false;
            if(j + 1 >=  end) return isValidExp_aux(str , i+1 , j-1);
            if(isOp(str.charAt(j+1))){
                return (isValidExp_aux(str , i+1 , j-1) && isValidExp_aux(str , j+2 , end));
            }
            if(isDigit(str.charAt(j+1)) || str.charAt(j+1) == '(' || str.charAt(j+1) == ')') return false;
        }
        if(str.charAt(i) == ')' || isOp(str.charAt(i))) return false;
        if(isDigit(str.charAt(i))){
            i++;
            while(i <= end){
                if(isOp(str.charAt(i))) return isValidExp_aux(str , i+1 , end);
                if(str.charAt(i) == '(' || str.charAt(i) == ')' ) return false;
                i++;
            }
        }
        return true;
    }
    public static boolean  isValidExp(String str){
        if(str.equals("")) return true;
        return isValidExp_aux(str , 0 ,str.length()-1);
    }
    public static int calExp1(String str){
        if (str.equals("") )return -1;
        return calcExp(str , 0 , str.length()-1);
    }
    public static int calcExp(String str,int start,int end ){
        int sum = 0;
        int i = start;
        if(str.charAt(i) == '(') {
            int j = findPrac(str , i+1 , end);
            if(j + 1 >=  end) return  calcExp(str , i+1 , j-1);
            if(isOp(str.charAt(j+1))){
                if (str.charAt(j+1)=='+')
                    return sum + (calcExp(str , i+1 , j-1) + calcExp(str , j+2 , end));
                if (str.charAt(j+1)=='-')
                    return sum - (calcExp(str , i+1 , j-1) - calcExp(str , j+2 , end));
                if (str.charAt(j+1)=='/')
                    return sum / (calcExp(str , i+1 , j-1) / calcExp(str , j+2 , end));
                if (str.charAt(j+1)=='*')
                    return sum * (calcExp(str , i+1 , j-1) * calcExp(str , j+2 , end));
            }
        }
        if(isDigit(str.charAt(i))){
            i++;
            while(i <= end){
                if(isOp(str.charAt(i))) return calcExp(str , i+1 , end);
                i++;
            }
        }
        return sum;
    }

    public static void main(String []args){
        String str = "(5+6) - 7 + 5";
        String str1 = "(5+6)-7/";
        System.out.println(isValidExp(str));

        System.out.println(isValidExp(str1));
        if (isValidExp(str))
            System.out.println(calExp1(str));
    }
}
