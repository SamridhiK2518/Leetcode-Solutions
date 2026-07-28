class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;    // simply add 1
                return digits;  // no carry, return result
            }
            digits[i] = 0;      // 9 becomes 0, carry goes to next
        }

        // If we reached here, all digits were 9
        int[] result = new int[n + 1];
        result[0] = 1; // example: 999 → 1000
        return result;
    }
}
