import java.util.Arrays;
import java.util.Scanner;

public class MinimumCoins {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 3
        int x = input.nextInt(); // 11

        int[] coins = new int[n]; // 1 5 7

        for (int i = 0; i < n; i++) {
            coins[i] = input.nextInt();
        }
        
        int[] dp = new int[x + 1];
        Arrays.fill(dp, (int) (1e9 + 7));

        dp[0] = 0; // Base Case

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        System.out.println(dp[x] < 1e9 ? dp[x] : -1);

        input.close();
    }
}
