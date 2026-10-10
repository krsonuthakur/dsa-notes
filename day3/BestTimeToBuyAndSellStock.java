package day3;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
// #121
// 2026-10-07
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1 || prices.length > 100_000) {
            throw new IllegalArgumentException("Array length must be between 1 and 100,000.");
        }

        int min_price = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min_price > prices[i]) {
                min_price = prices[i];
            } else {
                int diff = prices[i] - min_price;
                if (diff > profit) {
                    profit = diff;
                }
            }

        }

        return profit;
    }

    //    ChatGpt Suggestion, same way as above just use Math fnction
    public int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock buyAndSellStock = new BestTimeToBuyAndSellStock();

        int profit = buyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit);

        System.out.println(buyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(buyAndSellStock.maxProfit(new int[]{7, 3, 4, 6, 1}));

        System.out.println(buyAndSellStock.maxProfit2(new int[]{7, 3, 4, 6, 1}));
        System.out.println(buyAndSellStock.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
