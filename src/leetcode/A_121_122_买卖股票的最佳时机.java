package leetcode;

public class A_121_122_买卖股票的最佳时机 {
    //一笔交易
    public int maxProfit_1(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int minPrice=prices[0],max=0;
        for(int i:prices){
            if(i-minPrice>max){
                max=i-minPrice;
            }
            if(minPrice>i){
                minPrice=i;
            }
        }
        return max;
    }
    //两笔交易
    public int maxProfit_2(int[] prices) {
        int sumMax=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                sumMax=sumMax+prices[i]-prices[i-1];
            }
        }
        return sumMax;
    }
}
