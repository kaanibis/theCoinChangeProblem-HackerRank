package thecoinchangeproblem;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheCoinChangeProblem {

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {
         int f;
        f =(int)n;
        Arrays.sort(c);
        int t=c.length;
        long[] mem = new long[f+1];
        mem[0]=1;
        for(int i=1;i<f+1;i++){
            mem[i]=0;
        }
        for(int i = 0; i < t; i++) {
            for(int j = (int)c[i]; j <= f; j++) {
                mem[j] += mem[j-(int)c[i]];
            }
        }
        return(mem[f]);

    }

  
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];
        Arrays.fill(c,0);

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        //System.out.println(ways);
        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.close();

        scanner.close();
        
    }
}
