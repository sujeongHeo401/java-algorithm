/////////////////// https://www.hackerrank.com/challenges/largest-permutation/problem

public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        
        int max = Integer.MIN_VALUE;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int j = 0; j < arr.size(); j++){            
            if(arr.get(j) > max){
                max = arr.get(j);
            }
            map.put(arr.get(j), j);
        }
        int temp;
        for(int i = 0; i < k; i++){
            if(i == arr.size()) break;
            if(arr.get(i) == max){
                k++;
                max = max - 1;
                continue;

            } else {
                temp = arr.get(i);
                arr.set(i, max);
                arr.set(map.get(max), temp);
                map.replace(temp , map.get(max));

                max = max - 1;
            }
        }
        return arr;
            
    // Write your code here
    }
