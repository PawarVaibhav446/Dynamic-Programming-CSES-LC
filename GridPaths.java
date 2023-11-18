import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridPaths {

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
        int number = input.nextInt();
        
        char[][] grid = new char[number][number];
        for (int i = 0; i < number; i++) {
            String line = input.nextLine();
            for (int j = 0; j < number; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int M = (int) 1e9 + 7;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '*'){
                    dp[i][j] = 0;
                }else{
                    if(i > 0){
                        dp[i][j] += dp[i - 1][j];
                        dp[i][j] %= M;
                    }
                    if(j > 0){
                        dp[i][j] += dp[i][j - 1];
                        dp[i][j] %= M;
                    }
                }
            }
        }

        System.out.println(dp[m - 1][n - 1] % M);

    }
}
