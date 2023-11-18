
import java.util.Scanner;

public class DiceCombinations {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] dp = new int[n + 1];

        int MOD = (int) (1e9 + 7); 

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if(j <= i){
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }

        System.out.println(dp[n]);

        input.close();
    }
}
