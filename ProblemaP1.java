
// Daniel Vergara - 202320392
// Camila Caballero - 202320565

import java.io.*;
import java.util.Arrays;

public class ProblemaP1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCasos = Integer.parseInt(br.readLine());

        ProblemaP1 instance = new ProblemaP1();

        for (int i = 0; i < numCasos; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            int k = Integer.parseInt(tokens[0]);
            int n = Integer.parseInt(tokens[1]);
            int[] P = new int[5];
            for (int j = 0; j < 5; j++) {
                P[j] = Integer.parseInt(tokens[2 + j]);
            }

            int resp = instance.resolverCaso(k, n, P);

            System.out.println(resp);
        }
    }

    public int resolverCaso(int k, int n, int[] P) {
        
        int[] C = new int[n + 1];
        for (int x = 0;x <= n; x++) {
            C[x] = calcularCreativad(x, P);
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1000000000);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                int mejor = -1000000000;
                for (int x = 0; x <= j; x++) {
                    if (dp[i-1][j-x] + C[x] != -1000000000) {
                        mejor = Math.max(mejor, dp[i-1][j-x] + C[x]);
                        
                    }
                }
                dp[i][j] = mejor;
            }
        }


        return dp[k][n];
    }

    public int calcularCreativad(int x, int[] P) {
        int total = 0;
        int pos = 0;
        while (x > 0) {
            int digito = x % 10;
            if (digito == 3){
                total += 1 * P[pos];
            } else if (digito == 6) {
                total += 2 * P[pos];
            } else if (digito == 9) {
                total += 3 * P[pos];
            } else{
                total += 0 * P[pos];
            }
            x = x / 10;
            pos += 1;
        }

        return total;
    }

}