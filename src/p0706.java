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
  public static String gridChallenge(List<String> grid){
    int n = grid.size();
    for(int i = 0; i < n; i++){
      char[] c = grid.get(i).toCharArray();
      Arrays.sort(c);
      grid.set(i, new String(c));
    }
    for(int i = 1; i < n; i++){
      for(int j = 0; j < grid.get(i).length(); j++){
        if(grid.get(i-1).charAt(j) > grid.get(i).charAt(j)){
          return "NO";
        }
      }
    }
    RETURN "YES";
  }
}

////https://www.hackerrank.com/challenges/grid-challenge/problem?isFullScreen=true
