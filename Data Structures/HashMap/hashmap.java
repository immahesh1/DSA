import java.util.*;
class hashmap{
    public static void highestFreqChar(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            Character s = str.charAt(i);
            if(map.containsKey(s)==true){
                Integer kv = map.get(s)+1;
                map.put(s, kv);
            }else{
                map.put(s,1);
            }
        }
        // System.out.println(map);
        char c = 'a';
        int maxFreq = 0;
        for(char key : map.keySet()){
            if(map.get(key) > maxFreq){
                maxFreq = map.get(key);
                c = key;
            }
        }
        System.out.println(maxFreq);
    }
    public static void getCommonElements1(int[] ar1, int[] ar2){
        // 1. prepare map for array 1 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<ar1.length; i++){
            map.put(ar1[i], 1);
        }

        // 2. traverse through array2 and if key found print and remove
        for(int i=0; i<ar2.length; i++){
            if(map.containsKey(ar2[i])){
                System.out.print(ar2[i]+" ");
                map.remove(ar2[i]);
            }
        }
    }
    public static void getCommonElements2(int[] ar1, int[] ar2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key : ar1){
            if(map.containsKey(key)){
                int v = map.get(key);
                map.put(key, v+1);
            }else{
                map.put(key, 1);
            }
        }

        // 2. traver through arr2, if key found and value is greater than zero then print and sub value of the key
        for(int key : ar2){
            if(map.containsKey(key) && (map.get(key)>0)){
                System.out.println(key);
                map.put(key, map.get(key)-1);
            }
        }
    }
    public static void longestConsecutiveSeq(int[] arr){
        // 1. add true to all elements
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int key : arr){
            map.put(key, true);
        }

        // 2. if prev element present then mark false
        for(int key : arr){
            if(map.containsKey(key-1)){
                map.put(key, false);
            }
        }

        // 3. get length and starting point of seq
        int maxLenght = 0;
        int starting = 0;

        for(int key : arr){
            if(map.get(key) == true){
                // key is starting point
                int len = 1;
                int st = key;

                while(map.containsKey(key+1) == true){
                    len++;
                    key++;
                }
                if(maxLenght < len){
                    maxLenght = len;
                    starting = st;
                }

                map.put(st,false);
            }
        }

        // 4. printing
        for(int i=0; i<maxLenght; i++){   
            System.out.println(starting);
            starting++;
        }
    }
    public static void demo(){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 1);
        map.put('a', 1);
        map.put('d', 1);
        System.out.println(map);
    }   
    public static void main(String[] args) {
        // demo();
        // highestFreqChar("aabbdccds");
        int[] arr = {20,25,1,21,2,23,3,22,4,24,5,9,8,6};
        longestConsecutiveSeq(arr);
    }
}