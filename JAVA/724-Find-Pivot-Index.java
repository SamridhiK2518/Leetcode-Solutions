class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num; // get total sum of array
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i; // found pivot
            }
            leftSum += nums[i]; // update left sum for next index
        }

        return -1; // no pivot found
    }
}
