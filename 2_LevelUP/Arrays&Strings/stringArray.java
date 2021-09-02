
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
    public static test(){

    }
    public static void main(String[] args){
        test();
    }
}
