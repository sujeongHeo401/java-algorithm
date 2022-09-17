/////////////// https://www.hackerrank.com/challenges/closest-numbers/problem
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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
    int arrSize = arr.size();
    List<Integer> answerList = new ArrayList<Integer>(arrSize);
    List<Integer> checkList = new ArrayList<Integer>(arrSize - 1);
    
    Collections.sort(arr);
    for(int i = 0; i < arrSize - 1; i++){
        int element = Math.abs(arr.get(i+1) - arr.get(i));
        checkList.add(i, element);
    }
    Collections.sort(checkList);
    
    for(int i = 0; i < arrSize-1; i++){
        if(checkList.get(0) == arr.get(i+1) - arr.get(i)){
            answerList.add(arr.get(i));
            answerList.add(arr.get(i + 1));
        }
    }
    return answerList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
