class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        // Fill the rest with zeros
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}
