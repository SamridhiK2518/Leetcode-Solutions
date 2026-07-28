class Solution {
    public int maxProfit(int[] prices) {
        // Initialize minPrice to a very large number
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit to 0
        int maxProfit = 0;

        // Loop through each day's price
        for (int price : prices) {
            // Update the minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate potential profit if we sell today
            int profit = price - minPrice;
            // Update maxProfit if this profit is higher
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
