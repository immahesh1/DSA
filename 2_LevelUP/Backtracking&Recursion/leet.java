import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class leet {

  // return type List<List<Integer>>
  public static List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    List<List<Integer>> finalRes = new ArrayList<>();
    permute(nums, new boolean[nums.length], new ArrayList<>(), finalRes);
    return finalRes;
  }

  public static void permute(
    int[] nums,
    boolean[] visited,
    List<Integer> curRes,
    List<List<Integer>> finalRes
  ) {
    if (curRes.size() == nums.length) {
      finalRes.add(new ArrayList<>(curRes));
      return;
    }
    for (int i = 0; i < visited.length; i++) {
      if (visited[i] == false) {
        curRes.add(nums[i]);
        visited[i] = true;
        permute(nums, visited, curRes, finalRes);
        visited[i] = false;
        curRes.remove(curRes.size() - 1);
      }
    }
  }

  public static List<List<Integer>> combinationSum(
    int[] candidates,
    int target
  ) {
    List<List<Integer>> ans = new ArrayList<>();
    combinationSum(candidates, target, 0, 0, new ArrayList<>(), ans);
    return ans;
  }

  public static void combinationSum(
    int[] candidates,
    int target,
    int ssf,
    int idx,
    List<Integer> sans,
    List<List<Integer>> ans
  ) {
    if (ssf == target) {
      ans.add(new ArrayList<>(sans));
      return;
    }
    if (idx == candidates.length) {
      return;
    }
    // yes call
    if (ssf + candidates[idx] <= target) {
      sans.add(candidates[idx]);
      combinationSum(candidates, target, ssf + candidates[idx], idx, sans, ans);
      sans.remove(sans.size() - 1);
    }
    // no call
    combinationSum(candidates, target, ssf, idx + 1, sans, ans);
  }

  public static List<List<Integer>> combinationSum2(
    int[] candidates,
    int target
  ) {
    HashSet<Integer> unique = new HashSet<>();
    for (int e : candidates) {
      unique.add(e);
    }
    int i = 0;
    int[] nums = new int[unique.size()];
    for (Integer e : unique) {
      nums[i++] = e;
    }
    List<List<Integer>> ans = new ArrayList<>();
    combinationSum2(candidates, target, 0, 0, new ArrayList<>(), ans);
    return ans;
  }

  public static void combinationSum2(
    int[] nums,
    int target,
    int idx,
    int ssf,
    List<Integer> sans,
    List<List<Integer>> ans
  ) {
    if (ssf == target) {
      ans.add(new ArrayList<>(sans));
      return;
    }
    if (idx == nums.length) {
      return;
    }
    // yes call
    if (ssf + nums[idx] <= target) {
      sans.add(nums[idx]);
      combinationSum2(nums, target, idx + 1, ssf + nums[idx], sans, ans);
      sans.remove(sans.size() - 1);
    }
    // no call
    combinationSum2(nums, target, idx + 1, ssf, sans, ans);
  }

  public static void targetSum(
    int[] nums,
    int target,
    int idx,
    int ssf,
    String asf
  ) {
    if (ssf == target) {
      System.out.println(asf);
      return;
    }
    if (idx == nums.length) {
      return;
    }
    if (ssf + nums[idx] <= target) {
      targetSum(nums, target, idx, ssf + nums[idx], asf + " " + nums[idx]);
    }
    targetSum(nums, target, idx + 1, ssf, asf);
  }

  // m - row count, n - col count
  public static int uniqePath(int row, int col, int m, int n, int[][] dp) {
    if (row == m - 1 && col == n - 1) {
      return dp[row][col] = 1;
    }
    int count = 0;
    if (dp[row][col] != 0) {
      return dp[row][col];
    }
    if (row + 1 < m) {
      count += uniqePath(row + 1, col, m, n, dp);
    }
    if (col + 1 < n) {
      count += uniqePath(row, col + 1, m, n, dp);
    }
    return dp[row][col] = count;
  }

  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) return;
    solveSudoku(board, 0, 0);
  }

  public static boolean isSafeToPlace(
    char[][] board,
    int row,
    int col,
    char num
  ) {
    // check in row
    for (int c = 0; c < board[0].length; c++) {
      if (board[row][c] == num) {
        return false;
      }
    }
    // check in col
    for (int r = 0; r < board.length; r++) {
      if (board[r][col] == num) {
        return false;
      }
    }
    // 3X3 box check
    int rr = row - (row % 3);
    int cc = col - (col % 3);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i + rr][j + cc] == num) {
          return false;
        }
      }
    }
    return true;
  }

  public static void solveSudoku(char[][] board, int r, int c) {
    if (r == board.length) return;
    if (board[r][c] == '.') {
      for (char num = '1'; num <= '9'; num++) {
        // check
        if (isSafeToPlace(board, r, c, num)) {
          // place
          board[r][c] = num;
          // call
          if (c == board[0].length - 1) {
            solveSudoku(board, r + 1, 0);
          } else {
            solveSudoku(board, r, c + 1);
          }

          // unplace
          board[r][c] = '.';
        }
      }
    } else {
      if (c == board[0].length - 1) {
        solveSudoku(board, r + 1, 0);
      } else {
        solveSudoku(board, r, c + 1);
      }
    }
  }

  public static void func() {
    // int[] nums = { 2, 3, 6, 7 };
    // // List<List<Integer>> l = permute(nums);
    // List<List<Integer>> l = combinationSum(nums, 7);
    // targetSum(nums, 7, 0, 0, "");
    // int[] nums2 = { 10, 1, 2, 7, 6, 1, 5 };
    // List<List<Integer>> ll = combinationSum2(nums2, 8);
    // // System.out.println(ll);
    // int ans = uniqePath(0, 0, 3, 7, new int[4][8]);
    // System.out.println(ans);

    // char[][] ar = {
    //   { "5", "3", ".", ".", "7", ".", ".", ".", "." },
    //   { "6", ".", ".", "1", "9", "5", ".", ".", "." },
    //   { ".", "9", "8", ".", ".", ".", ".", "6", "." },
    //   { "8", ".", ".", ".", "6", ".", ".", ".", "3" },
    //   { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
    //   { "7", ".", ".", ".", "2", ".", ".", ".", "6" },
    //   { ".", "6", ".", ".", ".", ".", "2", "8", "." },
    //   { ".", ".", ".", "4", "1", "9", ".", ".", "5" },
    //   { ".", ".", ".", ".", "8", ".", ".", "7", "9" },
    // };
  }

  // public static int numDecodings(String s) {
  // int count = 0;
  // if (s.length() == 0) {
  //   count++;
  //   return count;
  // }
  // if (s.length() < 2) {
  //   count = count + 1;
  // } else {
  //   int num1 = s.charAt(0) - '0';
  //   if (num1 != 0) {
  //     int num2 = s.charAt(1) - '0';
  //     count = numDecodings(s.substring(1));
  //     int num = num1 * 10 + num2;
  //     if (num <= 26) {
  //       count = numDecodings(s.substring(2));
  //     }
  //   }
  // }
  // return count;
  // }

  // static int count = 0;

  // public static int numDecodings(String s, int idx, int[] dp) {
  //   if (s.length() == 0) {
  //     return 1;
  //     // return count;
  //   }
  //   if (s.charAt(0) == '0') {
  //     return 0;
  //   }
  //   int count = 0;
  //   // length 1 num
  //   int num1 = s.charAt(0) - '0';
  //   // System.out.println(num1);
  //   count += numDecodings(s.substring(1));
  //   if (s.length() > 1) {
  //     int num2 = s.charAt(1) - '0';
  //     int num = num1 * 10 + num2;
  //     if (num <= 26) {
  //       count += numDecodings(s.substring(2));
  //     }
  //   }
  //   return count;
  // }

  // public int numDecodings(String s) {}

  public static int numDecodings_(String s, int idx, int[] dp) {
    if (s.length() == idx) {
      return dp[idx] = 1;
    }
    int n1 = s.charAt(idx) - '0';
    if (n1 == 0) {
      return 0;
    }

    if (dp[idx] != 0) {
      return dp[idx];
    }
    int count = 0;
    count += numDecodings_(s, idx + 1, dp);
    if (idx + 1 < s.length()) {
      int num = n1 * 10 + s.charAt(idx + 1) - '0';
      if (num <= 26) {
        count += numDecodings_(s, idx + 2, dp);
      }
    }
    return dp[idx] = count;
  }

  public static int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    int res = numDecodings_(s, 0, dp);
    return res;
  }

  public static void func2() {
    String s = "10";
    int n = numDecodings(s);
    System.out.println(n);
  }

  public static void main(String[] args) {
    // func();
    func2();
  }
}
