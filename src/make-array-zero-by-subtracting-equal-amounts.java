class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        while(!checkIfAllZeroes(nums)){
            int minvalue = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= 0){
                    continue;
                }
                minvalue = Math.min(minvalue, nums[i]);
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= 0){
                    continue;
                }
                nums[i] = nums[i] - minvalue;
            }
            ans++;
            
        }
        return ans;
    }
    
    public boolean checkIfAllZeroes(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                return false;
            }
        }
        
        return true;
    }
}
