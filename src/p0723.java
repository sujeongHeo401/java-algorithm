////////////////////////https://www.hackerrank.com/challenges/coin-change/submissions/code/280769319
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
       long [][] memory = new long[n+1][c.size() + 1];
       
       /// the 0 coin has 0 combinations
       for(int i = 0; i < memory.length; i++){
           memory[i][0] = 0;
       }
       
       // all coins have 0 combinations for the 0 target
       for(int i =0; i < memory[0].length; i++){
           memory[0][i] = 0;
       }
        // perform the computation
        for(int t = 1; t < memory.length; t++){
            for(int eachcoins = 1; eachcoins < memory[t].length; eachcoins++){
                long withoutC = memory[t][eachcoins - 1];
                long subValue = t - c.get(eachcoins-1);

                long withC = subValue > 0 ? memory[(int)subValue][eachcoins] : 0;
                if(t == c.get(eachcoins - 1)){
                    memory[t][eachcoins] = 1 + withoutC;
                } else {
                    memory[t][eachcoins] = withC + withoutC;
                }
            }
        }
        
        /// the 0 targets has 0
    // Write your code here
        return memory[n][c.size()];

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
