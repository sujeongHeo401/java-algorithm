    public static long candies(int n, List<Integer> arr) {
    // Write your code here
        ArrayList<Long> a = new ArrayList<Long>(Collections.nCopies(n+2, 0l));
        long ans = 0; 
        long tmp = 0;
        
        a.set(0, 1l);
        // populate 'valleys'
        for(int i = 1; i < n; i++){
            if(arr.get(i) >arr.get(i-1)){
                a.set(i, a.get(i-1) + 1);
            } else a.set(i, 1l);
        }
        
        ans = a.get(n - 1);
        
        for(int i = n - 2; i >= 0; i--){
            if(arr.get(i) > arr.get(i+1)){
                tmp = a.get(i+1) + 1;
            } else tmp = 1;
            
            ans += Math.max(tmp, a.get(i));// maximum of the two values for child(i)
            a.set(i, tmp);
        }
        
        // populate 'rises'
      
        return ans;

    
    }
    
    
    //////https://www.hackerrank.com/challenges/candies/problem?isFullScreen=true
