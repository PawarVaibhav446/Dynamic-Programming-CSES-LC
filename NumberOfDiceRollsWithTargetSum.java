import java.util.Arrays;

class Solution {
    public int numRollsToTarget(int n, int k, int target) {

        int[][] dp = new int[n + 1][target + 1];
        
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }

        return numRollsToTarget2(n, k, target, dp);        
    }

    private int numRollsToTarget2(int n, int k, int target, int[][] dp) {

        int MOD = (int) (1e9 + 7);

        if(target == 0 && n == 0){
            return 1;
        }

        if(target < 0 || n == 0){
            return 0;
        }

        if(dp[n][target] != -1){
            return dp[n][target];
        }

        int count = 0;

        for(int i = 1;i <= k;i++){
            count = (count + numRollsToTarget2(n - 1, k, target - i, dp) % MOD) % MOD;
        }

        return dp[n][target] = count;
    }
}