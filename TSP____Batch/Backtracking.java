public class Backtracking{
    public static void printBoxes(int[] ar,int count, int idx, String asf){
        
        if(idx == ar.length){
            if(count <= 2)
                System.out.println(asf);
            return;
        }
        //yes call 
        printBoxes(ar, count+1,idx+1, asf+" "+idx);
        //no call
        printBoxes(ar, count,idx+1, asf);
    }
    //printing all possible ways 
    public static void print2DBoxes(int n,int m, int r, int c, String asf){
        if(r==n){
            System.out.println(asf);
            return;
        }
        if(c + 1 < m){
            //yes call
            print2DBoxes(n,m, r, c+1, asf+"("+r+", "+c+"), ");
            //no call
            print2DBoxes(n,m, r, c+1, asf);
        }else{
            //yes call
            print2DBoxes(n,m, r+1, 0, asf+"("+r+", "+c+"), ");
            //no call
            print2DBoxes(n,m, r+1, 0, asf);
        }
    }
    //choose one box from one row
    public static void print2DBoxes2(int n,int m, int r, int c,int bsf, String asf){
        if(r==n){
            if(bsf==2)
                System.out.println(asf);
            return;
        }
        if(c + 1 < m){ //next column is valid
            //yes call
            print2DBoxes2(n,m, r+1, 0, bsf+1,asf+"("+r+", "+c+"), ");
            //no call
            print2DBoxes2(n,m, r, c+1,bsf, asf);
        }else{ //next col is not valid
            //yes call
            print2DBoxes2(n,m, r+1, 0,bsf+1, asf+"("+r+", "+c+"), ");
            //no call
            print2DBoxes2(n,m, r+1, 0, bsf,asf);
        }
    }
   
    
    public static boolean isSafeHereToPlace(int[][] board, int r, int c){
        int[][] dir = {
            {-1, 0},
            {-1, 1},
            {-1, -1}
        };
        int radius = board.length;
        for(int rad=1; rad<radius; rad++){
            for(int d=0; d<dir.length; d++){
                int rr = r + (rad*dir[d][0]);
                int cc = c + (rad*dir[d][1]);
                //calls
                if(rr>=0 && rr<radius && cc>=0 && cc<radius){
                    if(board[rr][cc] == 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean isValidToPlace(int[][] board, int r, int c) {
        int[][] dir = {
            {-1, 0},
            {-1, 1},
            {-1, -1}
        };
        
        int radius = board.length;
        for(int rad = 1; rad < radius; rad++) {
            for(int d = 0; d < dir.length; d++) {
                int rr = r + (rad * dir[d][0]);
                int cc = c + (rad * dir[d][1]);

                // calls
                if(rr >= 0 && rr < radius && cc >= 0 && cc < radius) {
                    if(board[rr][cc] == 1) 
                        return false;   
                }   
            }
        }
        return true;
    }
    public static void nqueen(int[][] board, int sr, int sc, int qpsf, String asf) {
        int n = board.length;
        int m = board[0].length;
        if(sr == n){
            if(qpsf == board.length)
                System.out.println(asf+".");
            return;
        }
        if(sc+1<m){ //next col is valid
            //yes call
            if(isSafeHereToPlace(board, sr, sc)==true){
                board[sr][sc] = 1;
                nqueen(board, sr+1, 0, qpsf+1, asf+sr+"-"+sc+", ");
                board[sr][sc] = 0;
            }    
             //no call
            nqueen(board, sr, sc+1, qpsf, asf);
        }else{  //next col is not valid
            if(isSafeHereToPlace(board, sr, sc)==true){
                board[sr][sc] = 1;
                nqueen(board, sr+1, 0, qpsf+1, asf+sr+"-"+sc+", ");
                board[sr][sc] = 0;
            }
            //no call
            nqueen(board, sr+1, 0, qpsf, asf);
        }
    }
    public static void ques(){
        // int[] ar = new int[4];
        // printBoxes(ar, 0,0, "");
        // print2DBoxes(2,2, 0, 0, "");
        // print2DBoxes2(2, 2, 0, 0, 0, "");
        int[][] board = new int[4][4];
        nqueen(board, 0, 0, 0, "");
    }
    public static void main(String[] args){
        ques();
    }
}