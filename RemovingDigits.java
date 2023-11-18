import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RemovingDigits{

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

        int[] dp = new int[n + 1];
        Arrays.fill(dp, (int)(1e9 + 7));
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            for (int j = 0; j < number.length(); j++) {
                int digit = number.charAt(j) - '0';
                if(digit != 0){
                    dp[i] = Math.min(dp[i], dp[i - digit] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}