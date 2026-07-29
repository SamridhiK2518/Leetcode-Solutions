import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> freqMap = new HashMap<>(); // original frequencies
        TreeMap<Integer, Integer> diff = new TreeMap<>(); // difference map for sweep line
        
        // Mark intervals
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            diff.put(num, diff.getOrDefault(num, 0)); // ensure 'num' is a key
            diff.put(num - k, diff.getOrDefault(num - k, 0) + 1);
            diff.put(num + k + 1, diff.getOrDefault(num + k + 1, 0) - 1);
        }

        int ans = 0;
        int overlapping = 0;

        // Sweep through all possible target values
        for (Map.Entry<Integer, Integer> e : diff.entrySet()) {
            overlapping += e.getValue();

            int currentValue = e.getKey();
            int originalCount = freqMap.getOrDefault(currentValue, 0);

            // compute maximum frequency at this point
            int currentFreq = Math.min(overlapping, originalCount + numOperations);
            ans = Math.max(ans, currentFreq);
        }

        return ans;
    }
}
