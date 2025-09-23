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

            long resp = instance.resolverCaso(k, n, P);
            System.out.println(resp);
        }
    }

    public long resolverCaso(int k, int n, int[] P) {
        final long NEG_INF = -1_000_000_000_000_000L;

        long[] C = new long[n + 1];
        for (int x = 0; x <= n; x++) {
            C[x] = calcularCreatividad(x, P);
        }

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];
        Arrays.fill(prev, NEG_INF);
        prev[0] = 0;

        for (int i = 1; i <= k; i++) {
            Arrays.fill(curr, NEG_INF);
            for (int j = 0; j <= n; j++) {
                long mejor = NEG_INF;
                for (int x = 0; x <= j; x++) {
                    if (prev[j - x] > NEG_INF / 2) {
                        mejor = Math.max(mejor, prev[j - x] + C[x]);
                    }
                }
                curr[j] = mejor;
            }
         
            long[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        return prev[n];
    }

    public long calcularCreatividad(int x, int[] P) {
        long total = 0;
        int pos = 0;
        while (x > 0 && pos < 5) { 
            int digito = x % 10;
            if (digito == 3) {
                total += P[pos];
            } else if (digito == 6) {
                total += 2L * P[pos];
            } else if (digito == 9) {
                total += 3L * P[pos];
            }
            x /= 10;
            pos++;
        }
        return total;
    }
}