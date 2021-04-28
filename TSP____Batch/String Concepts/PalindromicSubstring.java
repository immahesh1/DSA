import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPaliSubstring(str);
    }
    public static void printPaliSubstring(String str){
        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                String subs = str.substring(i, j+1);
                if(isPalindrome(subs))
                    System.out.println(subs);
            }
        }
    }
    public static boolean isPalindrome(String str){
        int i = 0; int j = str.length() - 1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}