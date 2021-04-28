import java.util.Scanner;

class Main{
    public static String removeHi(String str){
        int fc = 0;
        int sc = 1;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sc <= str.length()){
            if(str.charAt(fc) == 'h' && str.charAt(sc) == 'i'){
                count++;
                fc += 2;
                sc += 2;
            }else{
                sb.append(str.charAt(fc));
                fc++; sc++;
            }
        }
        System.out.println(count);
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(removeHi(str));
    }
}