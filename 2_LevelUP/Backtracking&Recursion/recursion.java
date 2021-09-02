import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class recursion {

    public static void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {
            for (int v : boxes) {
                System.out.print(v);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                // box is empty
                // place object
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                // unplace objects
                boxes[i] = 0;
            }
        }
    }

    // cb-> current box, tb-> total box, isf -> item so far, ti -> total index,
    // asf-> ans so far
    public static void combinations(int cb, int tb, int isf, int ti, String asf) {
        if (cb > tb) {
            if (isf == ti) {
                System.out.println(asf);
            }
            return;
        }
        // yes call
        if (isf + 1 <= ti)
            combinations(cb + 1, tb, isf + 1, ti, asf + "i");
        // no call
        combinations(cb + 1, tb, isf, ti, asf + "_");
    }

    // cb-> current box, tb-> total box, isf -> item so far, ti -> total index,
    // asf-> ans so far
    public static void permutations(int cb, int tb, int[] items, int isf, int ti, String asf) {
        if (cb > tb) {
            if (isf == ti) {
                System.out.println(asf);
            }
            return;
        }
        for (int i = 0; i < items.length && isf < ti; i++) {
            if (items[i] == 0) {
                // select item
                items[i] = 1;
                permutations(cb + 1, tb, items, isf + 1, ti, asf + (i + 1));
                items[i] = 0;
            }
        }
        // no call
        permutations(cb + 1, tb, items, isf, ti, asf + "0");
    }

    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("i");
                }
            }
            System.out.println();
            return;
        }
        for (int i = lb + 1; i < boxes.length; i++) {
            boxes[i] = 1;
            combinations(boxes, ci + 1, ti, i);
            // unmark
            boxes[i] = 0;
        }
    }

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }
        if (col + 1 < tq) {
            // yes call
            if (qpsf < tq)
                queensCombinations(qpsf + 1, tq, row, col + 1, asf + "q");
            // no calll
            queensCombinations(qpsf, tq, row, col + 1, asf + "-");
        } else {
            // yes call
            if (qpsf < tq)
                queensCombinations(qpsf + 1, tq, row + 1, 0, asf + "q\n");
            // no calll
            queensCombinations(qpsf, tq, row + 1, 0, asf + "-\n");
        }
    }

    public static void queensPermutations(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            // print result
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if (chess[i][j] != 0) {
                        System.out.print("q" + chess[i][j] + "\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] == 0) {
                    // place queen
                    chess[i][j] = qpsf + 1;
                    queensPermutations(qpsf + 1, tq, chess);
                    // unplace queen
                    chess[i][j] = 0;
                }
            }
        }
    }

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        // yes call
        for (int q = 0; q < queens.length; q++) {
            if (queens[q] == false) {
                // place queen
                queens[q] = true;
                if (col + 1 < tq) {
                    queensPermutations(qpsf + 1, tq, row, col + 1, asf + "q" + (q + 1) + "\t", queens);
                } else {
                    queensPermutations(qpsf + 1, tq, row + 1, 0, asf + "q" + (q + 1) + "\n", queens);
                }
                // unplace queen
                queens[q] = false;
            }
        }
        // no call
        if (col + 1 < tq) {
            queensPermutations(qpsf, tq, row, col + 1, asf + "-\t", queens);
        } else {
            queensPermutations(qpsf, tq, row + 1, 0, asf + "-\n", queens);
        }
    }

    // public static void queensCombinations(int qpsf, int tq, boolean[][] chess,
    // int i, int j){
    // for(int )
    // }
    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // direction 1
        for (int c = col; c >= 0; c--) {
            if (chess[row][c] == true) {
                return false;
            }
        }
        // direction 2
        for (int c = col, r = row; c >= 0 && r >= 0; c--, r--) {
            if (chess[r][c] == true) {
                return false;
            }
        }
        // direction 3
        for (int r = col; r >= 0; r--) {
            if (chess[r][col] == true) {
                return false;
            }
        }
        // direction 4
        for (int c = col, r = row; c < chess[0].length && r >= 0; c++, r--) {
            if (chess[r][c] == true) {
                return false;
            }
        }
        return true;
    }

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        if (qpsf == tq) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if (chess[i][j] == true) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int b = lcno + 1; b < chess.length * chess[0].length; b++) {
            int r = b / chess.length;
            int c = b % chess[0].length;

            // place
            chess[r][c] = true;
            queensCombinations(qpsf + 1, tq, chess, b);
            chess[r][c] = false;
        }
    }

    public static void queensCombinations1D(int ti, int ci, int[] boxes, int lb) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("i");
                }
            }
            System.out.println();
            return;
        }

        for (int b = lb + 1; b < boxes.length; b++) {
            // if(boxes[b] != 1){
            // place queen
            boxes[b] = 1;
            queensCombinations1D(ti, ci + 1, boxes, b);
            // unplace queen
            boxes[b] = 0;
            // }
        }
    }

    // cs -> current space/selections, ts -> total space
    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }
        for (char ch : fmap.keySet()) {
            int oldFreq = fmap.get(ch);
            if (oldFreq > 0) {
                // mark
                fmap.put(ch, oldFreq - 1);
                generateWords(cs + 1, ts, fmap, asf + ch);
                // unmark for backtracking
                fmap.put(ch, oldFreq);
            }
        }
    }

    public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> li) {
        if (cc == str.length()) {
            for (char c : spots) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(cc);
        int lsi = li.get(ch); // last spot index

        for (int box = lsi + 1; box < spots.length; box++) {
            if (spots[box] == null) {
                spots[box] = ch;
                li.put(ch, box);
                generateWords(cc + 1, str, spots, li);
                spots[box] = null;
                li.put(ch, lsi);
            }
        }
    }

    // i -> current index, ustr-> unique string, ssf -> selected so far, ts -> total
    // selection
    public static void combination(int i, String ustr, int ssf, int ts, String asf) {
        if (i == ustr.length()) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(i);
        // yes call
        combination(i + 1, ustr, ssf + 1, ts, asf + ch);
        // no call
        combination(i + 1, ustr, ssf, ts, asf);
    }

    // Words - K Length Words - 2
    public static void permutation(String ustr, HashSet<Character> vis, int cs, int ts, String asf) {
        if (cs == ts) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            if (vis.contains(ch) == false) {
                // mark
                vis.add(ch);
                permutation(ustr, vis, cs + 1, ts, asf + ch);
                // unmark
                vis.remove(ch);
            }
        }
    }

    // Words - K Selection - 3
    public static void combination(String ustr, int cc, HashMap<Character, Integer> fmap, String asf, int k) {
        int ssf = asf.length();
        if (ssf == k) {
            System.out.println(asf);
            return;
        }

        if (cc == ustr.length())
            return;

        char ch = ustr.charAt(cc);
        int freq = fmap.get(ch);

        // yes call
        for (int i = freq; i > 0; i--) {
            if (i + ssf <= k) {
                String str = "";
                for (int j = 0; j < i; j++) {
                    str += ch;
                }
                combination(ustr, cc + 1, fmap, asf + str, k);
            }
        }
        // no call
        combination(ustr, cc + 1, fmap, asf, k);
    }
    // Words - K Length Words - 3

    // coin change
    // coin change combination 1
    public static void coinChangeCombination1(int i, int[] coins, int amtsf, int tamt, String asf) {
        if (amtsf == tamt) {
            System.out.println(asf + ".");
            return;
        }
        if (i == coins.length) {
            return;
        }
        // yes call
        if (amtsf + coins[i] <= tamt)
            coinChangeCombination1(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");

        // no call
        coinChangeCombination1(i + 1, coins, amtsf, tamt, asf);
    }

    // coin change combinarion 2
    public static void coinChangeCombination2(int i, int[] coins, int amtsf, int tamt, String asf) {
        if (amtsf == tamt) {
            System.out.println(asf + ".");
            return;
        }
        if (i == coins.length) {
            return;
        }
        // yes call
        if (amtsf + coins[i] <= tamt)
            coinChangeCombination2(i, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");

        // no call
        coinChangeCombination2(i + 1, coins, amtsf, tamt, asf);
    }

    // coin change permutation 1
    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used) {
        if (amtsf == tamt) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            if (used[i] == false && amtsf + coins[i] <= tamt) {
                used[i] = true;
                coinChange(coins, amtsf + coins[i], tamt, asf + coins[i] + "-", used);
                used[i] = false;
            }
        }
    }

    // coin change permutation 2
    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        if (amtsf == tamt) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            if (amtsf + coins[i] <= tamt) {
                coinChange(coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
            }
        }
    }

    // Abbreviation Using Backtracking
    public static void solution(String str, String asf, int count, int pos) {
        if (pos == str.length()) {
            String res = asf + (count != 0 ? count : "");
            System.out.println(res);
            return;
        }
        // yes call
        solution(str, asf + (count > 0 ? count : "") + str.charAt(pos), 0, pos + 1);

        // no call
        solution(str, asf, count + 1, pos + 1);
    }
    // N Queen Branch and bound
    public static boolean[] cols;
    public static boolean[] nd; // normal diagonal
    public static boolean[] rd; // reverse diagonal
    public static boolean isSafeHereToPlace(int r, int c) {
        if (cols[c] == true) {
            return false;
        }
        if (nd[r + c] == true) {
            return false;
        }
        if (rd[r - c + cols.length - 1] == true) {
            return false;
        }
        return true;
    }
    public static void nQueen(int n, int row, String asf) {
        if (row == n) {
            System.out.println(asf + ".");
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafeHereToPlace(row, col)) {
                // mark
                cols[col] = true;
                nd[row + col] = true;
                rd[row - col + n - 1] = true;

                // call
                nQueen(n, row + 1, asf + row + "-" + col + ", ");

                // unmark
                cols[col] = false;
                nd[row + col] = false;
                rd[row - col + n - 1] = false;
            }
        }
    }
    // max score
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }
        // no call
        int no_ans = solution(words, farr, score, idx + 1);

        int myScore = 0;
        String word = words[idx];
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            int charIdx = word.charAt(i) - 'a';
            myScore += score[charIdx];

            if (farr[charIdx] <= 0) {
                flag = false;
            }
            farr[charIdx]--;
        }
        int yes_ans = 0;
        if (flag == true) {
            yes_ans = myScore + solution(words, farr, score, idx + 1);
        }
        // reset freq
        for (int i = 0; i < word.length(); i++) {
            int charIdx = word.charAt(i) - 'a';
            farr[charIdx]++;
        }

        return Math.max(yes_ans, no_ans);
    }
    // Lexicographical order
    public static void lexicographical(int n, int val) {
        if (n < val) {
            return;
        }
        // self printing
        System.out.println(val);
        for (int i = 0; i <= 9; i++) {
            lexicographical(n, 10 * val + i);
        }
    }

    // sudoku solver
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
    }
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // col check
        for (int c = 0; c < board[0].length; c++) {
            if (board[row][c] == n) {
                return false;
            }
        }
        // row check
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == n) {
                return false;
            }
        }
        // rr = r - r % 3
        // cc = c - c % 3
        int rr = row - (row % 3);
        int cc = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + rr][j + cc] == n) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void solveSudoku(int[][] board, int i, int j) {
        if (i == board.length) {
            display(board);
            return;
        }
        if (board[i][j] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isSafe(board, i, j, num)) {
                    // place
                    board[i][j] = num;

                    // call
                    if (j == board[0].length - 1) {
                        solveSudoku(board, i + 1, 0);
                    } else {
                        solveSudoku(board, i, j + 1);
                    }

                    // unplace
                    board[i][j] = 0;
                }
            }
        } else {
            // call
            if (j == board[0].length - 1) {
                solveSudoku(board, i + 1, 0);
            } else {
                solveSudoku(board, i, j + 1);
            }
        }
    }

    // Cryptarithmetic
    public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
            String s1, String s2, String s3) {
        char ch = unique.charAt(idx);
        for (int i = 0; i < 10; i++) {
            // mark

            // unmark
        }
    }

    // crossword -- toughest
    public static boolean checkHorizontal(char[][] grid, int r, int c, String word){
        // left check
        if(c>0 && grid[r][c-1] != '+'){
            return false;
        }
        // right check
        if(c-1+word.length() >= grid.length){
            return false;
        }

        if((c-1+word.length()<grid[0].length -1) && (grid[r][c+word.length()] != '+')){
            return false;
        }

        for(int j=0; j<word.length(); j++){
            if(grid[r][c+j] != '-' && grid[r][c+j] != word.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkVertical(char[][] grid, int r, int c, String word){
        // left check
        if(r > 0 && grid[r-1][c] != '+'){
            return false;
        }
        // right check
        if(r - 1 + word.length() >= grid.length){
            return false;
        }

        if((r-1+word.length()<grid[0].length -1) && (grid[r + word.length()][c] != '+')){
            return false;
        }

        for(int j=0; j<word.length(); j++){
            if(grid[r + j][c] != '-' && grid[r + j][c] != word.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeHorizontal(char[][] grid, int r, int c, String word){
        boolean[] status = new boolean[word.length()];
        for(int j=0; j<word.length(); j++){
            if(grid[r][c + j] == '-'){
                grid[r][c + j] = word.charAt(j);
                status[j] = true;
            }
        }
        return status;
    }

    public static boolean[] placeVertical(char[][] grid, int r, int c, String word){
        boolean[] status = new boolean[word.length()];
        for(int j=0; j<word.length(); j++){
            if(grid[r + j][c] == '-'){
                grid[r + j][c] = word.charAt(j);
                status[j] = true;
            }
        }
        return status;
    }

    public static void unplaceHorizontal(char[][] grid, int r, int c, boolean[] status){
        for(int j=0; j<status.length; j++){
            if(status[j] == true){
                grid[r][c + j] = '-';
                status[j] = false;
            }
        }
    }

    public static void unplaceVertical(char[][] grid, int r, int c, boolean[] status){
        for(int j=0; j<status.length; j++){
            if(status[j] == true){
                grid[r + j][c] = '-';
                status[j] = false;
            }
        }
    }
    public static void print(char[][] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0 ; j < arr.length; j++) { 
				System.out.print(arr[i][j]);
			}
            System.out.println();
		}
	}
    public static void solution(char[][] grid, String[] words, int vidx){
		if(vidx == words.length){
            print(grid);
            return;
        }
        String word = words[vidx];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '-' || grid[i][j] == word.charAt(0)){
                    // check hortizontally
                    if(checkHorizontal(grid, i, j, word)){
                        // place
                        boolean[] status = placeHorizontal(grid, i, j, word);
                        solution(grid, words, vidx + 1);
                        // unplace
                        unplaceHorizontal(grid, i, j, status);
                    }

                    //check vertically
                    if(checkVertical(grid, i, j, word)){
                        // place
                        placeVertical(grid, i, j, word);
                        boolean[] status = placeVertical(grid, i, j, word);
                        solution(grid, words, vidx + 1);
                        // unplace 
                        unplaceVertical(grid, i, j, status);
                    }
                }
            }
        }
	}
    // friends pairing - 2
    public static int counter = 1;
    public static void solution(int i, int n, boolean[] used, String asf) {
        if(i>n){
            System.out.println(counter+"."+asf);
            counter++;
            return;
        }
        if(used[i] == true){
            solution(i+1, n, used, asf);
        }else{
            // single call
            used[i] = true;
            solution(i+1, n, used, asf+"("+i+") ");
            // pari up calls
            for(int j=i+1; j<=n; j++){
                if(used[j] == false){
                    used[j] = true;
                    solution(i+1, n, used, asf+"("+i+","+j+") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }

    // All Palindromic Partitions
    public static boolean isPalindromic(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void solution(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String option = str.substring(0, i+1);
            String roq = str.substring(i+1);
            if(isPalindromic(option)){
                solution(roq, asf+"("+option+") ");
            }
        }
	}
    // Partition in K subsets
    // ssf -> subset so far
    public static int ii = 0;
    public static void solution(int i, int n, int k, int ssf, ArrayList<ArrayList<Integer>> ans) {
        if(i>n){
            if(ssf == k){
                ii++;
                System.out.print(ii+".");
                for(ArrayList<Integer> e: ans){
                    System.out.print(e+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int j=0; j<ans.size(); j++){
            if(ans.get(j).size() > 0){
                ans.get(j).add(i);
                solution(i+1, n, k, ssf, ans);
                ans.get(j).remove(ans.get(j).size()-1);
            }else{
                ans.get(j).add(i);
                solution(i+1, n, k, ssf+1, ans);
                ans.get(j).remove(ans.get(j).size()-1);
                break;
            }
        }
	}
    // K Subsets With Equal Sum
    public static void solution(int[] arr, int vidx, int n , int k, int[] subsetSum, int ssssf, ArrayList<ArrayList<Integer>> ans) {
        if(vidx == arr.length){
            if(ssssf == k){
                boolean flag = true;
                for(int i=0; i<subsetSum.length-1; i++){
                    if(subsetSum[i] != subsetSum[i+1]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(ArrayList<Integer> set : ans){
                        System.out.print(set + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }
        for(int i=0; i<ans.size(); i++){
            if(ans.get(i).size() > 0){
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr, vidx+1, n, k, subsetSum, ssssf, ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
            }else{
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr, vidx+1, n, k, subsetSum, ssssf+1, ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }
    }
    // tug of war
    static int mindiff = Integer.MAX_VALUE;
	static String ans = "";
    public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1, int soset2) {
        if(vidx == arr.length){
            if(Math.abs(soset1 - soset2) < mindiff){
                ans = set1.toString() + " " + set2.toString();
                mindiff = Math.abs(soset1 - soset2);
            }
            return;
        }
        
        // set1
        if(set1.size() < (arr.length+1)/2){
            set1.add(arr[vidx]);
            solve(arr, vidx+1, set1, set2, soset1 + arr[vidx], soset2);
            set1.remove(set1.size() - 1);
        }

        // set2
        if(set2.size() < (arr.length + 1)/2){
            set2.add(arr[vidx])
            solve(arr, vidx+1, set1, set2, soset1, soset2 + arr[vidx]);
            set2.remove(set2.size() - 1);
        }
	}
    // pattern matching
    public static void solution(String str, String pattern, HashMap<Character,String> map, String asf, int idx){
        if(idx == pattern.length()){
            if(str.length() == 0){
                System.out.println(asf+".");
            }
            return;
        }
        char ch = pattern.charAt(idx);
        String mapping = map.get(ch);

        for(int i=0; i<str.length(); i++){
            String substr = str.substring(0, i+1);
            String roq = str.substring(i+1);

            // mapping
            map.put(ch, substr);
            if(mapping.length()>0){
                if(substr.equals(mapping) == true){
                    solution(roq, pattern, map, asf, idx + 1);
                }
            }else{
                solution(roq, pattern, map, asf + ch + " -> " + substr + ", ", idx + 1);
            }
            // reset mapping
            map.put(ch, mapping); 
        }
	}
    // word break
    public static void wordBreak(String str, String ans, HashSet<String> dict){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String word = str.substring(0, i+1);
            String roq = str.substring(i+1);
            if(dict.contains(word)){
                wordBreak(roq, ans + word + " ", dict);
            }
        }
	}
    // remove invalid parenthesis
    public static void solution(String str, int minRemoval, HashSet<String> ans) {
		if(minRemoval == 0){
            if(getMin(str) == 0 && ans.contains(str) == false){
                ans.add(str);
                System.out.println(str);
            }
            return;
        }
        
        for(int i=0; i<str.length(); i++){
            String left = str.substring(0, i); // we have to exclude ith for removal
            String right = str.substring(i+1);
            solution(left+right, minRemoval - 1, ans);
        }
	}

	public static int getMin(String str){
		Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                }
            }
        }
		return st.size();
	}
    public static void func() {
        int[] boxes = new int[4];

        // queensCombinations1D(3,1,boxes,-1);
        String str = "abac";
        combination1(str, new int[3], 0, 3, "");
    }

    public static void main(String[] args) {
        func();
    }
}