import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumSubsetDifference {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        
        FastReader input = new FastReader();
        int n = input.nextInt();

        int[] a = new int[n];
        int range = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
            range += a[i];
        }

        boolean[][] dp = new boolean[n + 1][range + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(i == 0){
                    dp[i][j] = false;
                }
                if(j == 0){
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= range; j++) {
                
                int w = a[i - 1];

                if(j >= w){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - w];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < range + 1; i++) {
            if(dp[n][i] == true){
                ans = Math.min(ans, Math.abs(range - 2 * i));
            }
        }

        System.out.println(ans);
    }
}
