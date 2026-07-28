import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); // sort array first
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) { // check adjacent after sorting
                return true; // duplicate found
            }
        }
        
        return false; // no duplicates
    }
}
