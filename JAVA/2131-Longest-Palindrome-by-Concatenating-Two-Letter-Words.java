import java.util.*;

public class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int totalLength = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (String word : countMap.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (!word.equals(reversed)) {
                if (countMap.containsKey(reversed)) {
                    int pairs = Math.min(countMap.get(word), countMap.get(reversed));
                    totalLength += pairs * 4;
                    countMap.put(word, countMap.get(word) - pairs);
                    countMap.put(reversed, countMap.get(reversed) - pairs);
                }
            } else {
                int pairs = countMap.get(word) / 2;
                totalLength += pairs * 4;
                countMap.put(word, countMap.get(word) - pairs * 2);
                if (countMap.get(word) > 0) {
                    hasMiddle = true;
                }
            }
        }

        if (hasMiddle) {
            totalLength += 2;
        }

        return totalLength;
    }

    // Only include this if testing locally
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words separated by commas (e.g., lc,cl,gg): ");
        String input = scanner.nextLine().trim();

        String[] words = Arrays.stream(input.split(","))
                               .map(String::trim)
                               .toArray(String[]::new);

        Solution solver = new Solution();
        int result = solver.longestPalindrome(words);
        System.out.println("Length of longest palindrome: " + result);
    }
}
