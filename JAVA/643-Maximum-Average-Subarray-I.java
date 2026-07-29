public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Step 1: Calculate the sum of the first k elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        // Step 2: Initialize maxSum to the sum of the first window
        int maxSum = sum;
        
        // Step 3: Slide the window and update the sum and maxSum
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Add next element, remove the first one in the window
            if (sum > maxSum) {
                maxSum = sum; // Update maxSum if current window has a higher sum
            }
        }
        
        // Step 4: Calculate and return the maximum average
        return maxSum / (double) k;
    }
}
