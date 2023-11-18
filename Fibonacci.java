public class Fibonacci{
    public static void main(String[] args) {
        
        // f(n) = f(n - 1) + f(n - 2)
        // f(1) = 1;
        // f(2) = 1;
        // eg. f(3) = f(2) + f(1) = 1 + 1 = 2

        // eg.      f(4)                  = 3
        //      f(3)     f(2)             = 2 + 1 = 3
        //    f(2) f(1)                   = 1 + 1 = 2
        
        int n = 6;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= 6; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}