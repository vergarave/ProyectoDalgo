
// Daniel Vergara - 202320392
// Camila Caballero - 202320565

import java.io.*;

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
        // TODO: implementar la DP para maximizar creatividad
        return 0; //placeholder
    }


}