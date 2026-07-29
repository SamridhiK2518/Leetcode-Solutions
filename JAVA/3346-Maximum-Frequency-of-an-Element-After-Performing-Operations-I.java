import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // Step 1. Count original frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Step 2. Use TreeMap for difference array (range boundaries)
        TreeMap<Integer, Integer> diffMap = new TreeMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            // Ensure number itself is in diffMap
            diffMap.putIfAbsent(num, 0);

            // Mark the beginning of range [num - k, num + k]
            diffMap.put(num - k, diffMap.getOrDefault(num - k, 0) + 1);
            // Mark the end of range (exclusive)
            diffMap.put(num + k + 1, diffMap.getOrDefault(num + k + 1, 0) - 1);
        }

        // Step 3. Sweep through all keys in order
        int maxFreq = 0;
        int runningSum = 0;

        for (var entry : diffMap.entrySet()) {
            int position = entry.getKey();
            runningSum += entry.getValue();

            // Frequency achievable at this value
            int currentFreq = Math.min(runningSum,
                    freqMap.getOrDefault(position, 0) + numOperations);
            maxFreq = Math.max(maxFreq, currentFreq);
        }
        return maxFreq;
    }
}
