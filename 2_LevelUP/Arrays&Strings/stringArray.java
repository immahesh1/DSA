import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class stringArray {

    // https://leetcode.com/problems/long-pressed-name/submissions/
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()) return false;
        int i = 0;
        int j = 0;
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if(0<=i-1 && name.charAt(i-1) == typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }

        while(j<typed.length()){
            if(typed.charAt(j) != name.charAt(i-1)){
                return false;
            }
            j++;
        }

        return i<name.length() ? false : true;
    }
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0; int j = nums.length - 1;
        int k = nums.length-1;
        while(i <= j){
            int n1 = nums[i];
            int n2 = nums[j];
            if(n1*n1 > n2*n2){
                res[k--] = n1 * n1;
                i++;
            }else if(n1*n1 <= n2*n2){
                res[k--] = n2 * n2;
                j--;
            }
        }
        return res;
    }
    // https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ht = 0;
        int br = 0;
        int area = Integer.MIN_VALUE;
        while(left < right){
            ht = Math.min(height[left], height[right]);
            br = right - left;
            int ar = ht * br;
            if(ar > area){
                area = ar;
            }
            
            //move left and right
            if(height[left] < height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                left++;  right--;
            }
        }
        return area;
    }
    
    private static int findPotentialAns(int[] arr){
        int val = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++){
            if(val == arr[i]){
                // same element 
                count++;
            }else{
                // distinct element, map ele
                count--;
            }
            if(count == 0){
                val = arr[i];
                count = 1;
            }
        }
        return val;
    }
    public static void printMajorityElement(int[] arr) {
        int val = findPotentialAns(arr);

        int freq = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == val){
                freq++;
            }
        }
        if(freq >= arr.length/2){
            System.out.println(val);
        }else{
            System.out.println("No Majority Element exist");
        }
    }

    //229. Majority Element II: https://leetcode.com/problems/majority-element-ii/
    private boolean isFreqMoreThan3(int[] nums, int val){
        int freq = 0;
        for(int e : nums){
            if(e == val){
                freq++;
            }
        }
        return freq>nums.length/3;
    }  
    public List<Integer> majorityElement(int[] nums) {
        int val1 = nums[0];
        int count1 = 0;
        int val2 = nums[0];
        int count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val1){
                count1++;
            }else if(nums[i] == val2){
                count2++;
            }else{
                if(count1 == 0){
                    val1 = nums[i];
                    count1 = 1;
                }else if(count2 == 0){
                    val2 = nums[i];
                    count2 = 1;
                }else{
                    count1--;
                    count2--;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        if(isFreqMoreThan3(nums, val1))
            res.add(val1);

        if(val2 != val1 && isFreqMoreThan3(nums, val2))
            res.add(val2);

        return res;
    }
    // 628. Maximum Product of Three Numbers
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                max3 = nums[i];
            }

            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2){
                min2 = nums[i];
            }
        }

        return Math.max(max1*max2*max3, min1*min2*max1);
    }
    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int idx = -1;
        int ansIdx = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
                idx = i;
            }else if(nums[i] > max2){
                max2 = nums[i];
            }
        }

        if(max1 >= 2 * max2){
            ansIdx = idx;
        }

        return ansIdx;
    }
    
    public static int maxChunksToSorted(int[] arr) {
        int maxImp = arr[0];
        int chunkCount = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == maxImp){
                maxImp = arr[i];
                chunkCount++;
            }
        }
        return chunkCount;
    }
    
    // https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
    public static int maxChunksToSorted2(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            rightMin[i] = Math.max(rightMin[i+1],arr[i]);
        }

        int chunks = 0;
        int leftMax = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            // find leftMax 
            leftMax = Math.max(leftMax, arr[i]);
            if(leftMax <= rightMin[i+1])
                chunks++;
        }
        return chunks;
    }

    // https://leetcode.com/problems/reverse-vowels-of-a-string/
    public static boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c =='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        char[] ar = s.toCharArray();
        int left = 0;
        int right = ar.length - 1;
        while(left < right){
            // make left at vowel
            while(left < right && isVowel(ar[left])==false)
                left++;
            // make right at vowel
            while(left < right && isVowel(ar[right])==false)
                right--;
            
            char tmp = ar[left];
            ar[left] = ar[right];
            ar[right] = tmp;
            left++;
            right--;
        }

        return String.valueOf(ar);
    }

    // https://leetcode.com/problems/product-of-array-except-self/
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;

        int[] leftProd = new int[n];
        leftProd[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            leftProd[i] = leftProd[i-1] * arr[i];
        }

        int[] rightProd = new int[n];
        rightProd[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            rightProd[i] = rightProd[i+1] * arr[i];
        }

        int[] res = new int[n];
        res[0] = rightProd[0];
        res[n-1] = leftProd[n-2];

        for(int i=1; i<res.length-1; i++){
            res[i] = leftProd[i-1] * rightProd[i+1];
        }
        return res;
    }

    // Wiggle Sort 1
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void wiggleSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            if(i % 2 == 0){
                //even
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }else{
                //odd 
                if(arr[i] < arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }
    
    // https://leetcode.com/problems/wiggle-sort-ii/
    public static void wiggleSort2(int[] nums) {
        int n = nums.length;
        // create a duplicate array
        int[] dupl = new int[n];

        for(int i=0; i<n; i++){
            dupl[i] = nums[i];
        }

        Arrays.sort(dupl);

        int i = 1;
        int j = n-1;

        // fill odd
        while(i < n){
            nums[i] = dupl[j];
            i += 2;
            j--;
        }

        // fill even
        i = 0;
        while(i < n){
            nums[i] = dupl[j];
            i += 2;
            j--;
        }
    }
    
    public static int numSubarrayBoundedMax(int[] arr, int left, int right) {

    }

    // https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
    }

    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int i = 0;
        int len = 0;
        // left subpart 
        while(seats[i] != 1){
            i++;
            len++;
        }
        i++; // to reach at 0 again
        max = len;
        len = 0;
        // segment calculation
        while(i < seats.length){
            while(i < seats.length && seats[i] != 1){
                len++;
                i++;
            }
            if(i == seats.length){
                break;
            }
            i++;
            max = Math.max(max, (len+1)/2);
            len = 0;
        }
        
        return Math.max(max, len);
    }

    // https://leetcode.com/problems/first-missing-positive/

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // step 1: mark element which are out of range
        boolean one = false;
        for(int i=0; i<n; i++){
            if(nums[i] == 1) one = true;

            if(nums[i] < 1 || nums[i] > n){
                nums[i] = 1;
            }
        }
        if(one == false) return 1;
        // step 2 : mark index 
        for(int i=0; i<n; i++){
            int idx = nums[i] - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }

        // step 3 : check first missing postivie no.
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }

    // https://leetcode.com/problems/sort-array-by-parity/
    public int[] sortArrayByParity(int[] nums) {
        int i = 0; // first unsorted
        int j = 0; // first odd
        while(i < nums.length){
            if(nums[i] % 2 == 0){
                //even
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }else{
                //odd
                i++;
            }
        }
        return nums;
    }
    
    // https://www.lintcode.com/problem/903/
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        // Step 1: travel on query and mark
        for(int i=0; i<updates.length; i++){
            int st = updates[i][0];
            int end = updates[i][1];
            int incr = updates[i][2];

            res[st] += incr;
            if(end != length-1){
                res[end+1] -= incr;
            }
        } 

        // step 2: prefix sum
        for(int i=1; i<length; i++){
            res[i] += res[i-1];
        }
        return res;
    }

    //670. Maximum Swap: https://leetcode.com/problems/maximum-swap/
    public int maximumSwap(int n) {
        String num = n + "";
        char[] arr = num.toCharArray();

        int[] lastOcc = new int[10];
        for(int i=0; i < arr.length; i++){
            lastOcc[arr[i]-'0'] = i; // filling last occurance of digit
        }

        // travel and find swapping point
        for(int i=0; i < arr.length; i++){
            int val = arr[i] - '0';
            int indx = i;
            if(val != 9){
                for(int j=9; j > val; j--){
                    if(lastOcc[j] > i){
                        indx = lastOcc[j];
                        break;
                    }
                }

                if(indx != i){
                    char tmp = arr[i];
                    arr[i] = arr[indx];
                    arr[indx] = tmp;
                    break;
                }
            }
        }
        String res = String.valueOf(arr);
        // convert string into number
        return Integer.parseInt(res);
    }

    // https://www.lintcode.com/problem/912/
    public int minTotalDistance(int[][] grid) {
        int dist = 0;
        // fill xco-ordinates in arraylist in sorted order - row traversal
        ArrayList<Integer> xcord = new ArrayList<>();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    xcord.add(r);
                }
            }
        }

        // fill yco-ordinates in arraylist in sorted order - col traversal
        ArrayList<Integer> ycord = new ArrayList<>();
        for(int c = 0; c<grid[0].length; c++){
            for(int r = 0; r < grid.length; r++){
                if(grid[r][c] == 1){
                    ycord.add(c);
                }
            }
        }

        // find meeting point
        int x = xcord.get(xcord.size()/2);
        int y = ycord.get(ycord.size()/2);

        // apply manhattan formula to find distance between meeting point and person p
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    dist += Math.abs(x-r) + Math.abs(y-c);
                }
            }
        }

        return dist;
    }

    // https://leetcode.com/problems/pascals-triangle-ii/
    public static List<Integer> pascalRow(int n) {
        List<Integer> res = new ArrayList<>();
        long val = 1;
        for(int r=0; r<=n; r++){
            res.add((int)val);
            val = val * (n-r)/(r+1);
        }

        return res;
    }

    // https://leetcode.com/problems/complex-number-multiplication/
    public String complexNumberMultiply(String num1, String num2) {
        int a1 = Integer.parseInt(num1.substring(0,num1.indexOf("+")));
        int b1 = Integer.parseInt(num1.substring(num1.indexOf("+")+1, num1.length()-1));

        int a2 = Integer.parseInt(num2.substring(0,num2.indexOf("+")));
        int b2 = Integer.parseInt(num2.substring(num2.indexOf("+")+1, num2.length()-1));

        int a = a1 * a2 - b1 * b2;
        int b = a1 * b2 + a2 * b1;

        return a + "+" + b + "i";
    }

    public static List<List<Integer>> twoSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            // preprocessing
            if(left != 0 && arr[left] == arr[left-1]){
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if(sum == target){
                List<Integer> sub = new ArrayList<>();
                sub.add(arr[left]);
                sub.add(arr[right]);
                res.add(sub);
                left++;
                right--;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }

        return res;
    }

    private static List<List<Integer>> twoSumfor3Sum(int[] arr, int st, int end, int target){
        List<List<Integer>> res = new ArrayList<>();
        int left = st;
        int right = end;
        while(left < right){
            // preprocessing
            if(left != st && arr[left] == arr[left-1]){
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if(sum == target){
                List<Integer> sub = new ArrayList<>();
                sub.add(arr[left]);
                sub.add(arr[right]);
                res.add(sub);
                left++;
                right--;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }

        return res;
    }
    public static List<List<Integer>> threeSum(int[] nums, int targ) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int val = nums[i];
            int smallTarget = targ - val;
            List<List<Integer>> subres = twoSumfor3Sum(nums, i+1, nums.length-1, smallTarget);
            for(List<Integer> list : subres){
                list.add(val);
                res.add(list);
            }
        }

        return res;
    }
    public static test(){

    }
    public static void main(String[] args){
        test();
    }
}
