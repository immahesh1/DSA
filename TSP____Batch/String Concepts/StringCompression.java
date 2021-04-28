import java.util.Scanner;

public class StringCompression {
    public static String compression1(String str){
        if(str.length() == 0)   return "";
        char curr = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(curr);
        for(int i=1; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch != curr){
                sb.append(ch);
                curr = ch;
            }
        }
        return sb.toString();
    }
    public static String compression2(String str){
        if(str.length() == 0)   return "";
        char curr = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(curr);
        int count = 1;
        for(int i=1; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch != curr){
                if(count > 1){
                    sb.append(count);
                }
                sb.append(ch);
                curr = ch;
                count = 1;
            }else{
                count++;
            }
        }
        if(count > 1){
            sb.append(count);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }    
}
