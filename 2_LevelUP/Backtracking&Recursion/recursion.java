public class recursion{
    
    public static void permutations(int[] boxes, int ci, int ti){
        if(ci>ti){
            for(int v : boxes){
                System.out.print(v);
            }
            System.out.println();
            return;
        }
        for(int i=0; i<boxes.length; i++){
            if(boxes[i] == 0){
                // box is empty
                // place object
                boxes[i] = ci;
                permutations(boxes, ci+1, ti);
                // unplace objects
                boxes[i] = 0;
            }
        }
    }
    // cb-> current box, tb-> total box, isf -> item so far, ti -> total index, asf-> ans so far
    public static void combinations(int cb, int tb, int isf, int ti, String asf){
        if(cb > tb){
            if(isf == ti){
                System.out.println(asf);
            }
            return;
        }
        // yes call
        if(isf+1 <= ti)
            combinations(cb+1, tb, isf+1, ti, asf+"i");
        // no call
        combinations(cb+1, tb, isf, ti, asf+"_");
    }
    // cb-> current box, tb-> total box, isf -> item so far, ti -> total index, asf-> ans so far
    public static void permutations(int cb, int tb, int[] items, int isf, int ti, String asf){
        if(cb>tb){
            if(isf == ti){
                System.out.println(asf);
            }
            return;
        }
        for(int i=0; i<items.length && isf<ti; i++){
            if(items[i] == 0){
                // select item
                items[i] = 1;
                permutations(cb+1, tb, items, isf+1, ti, asf+(i+1));
                items[i] = 0;
            }
        }
        // no call
        permutations(cb+1, tb, items, isf, ti, asf+"0");
    }
    public static void func(){

    }
    public static void main(String[] args) {
        func();
    }
}