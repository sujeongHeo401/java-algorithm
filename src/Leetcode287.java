package jagorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode287 {
	////// 시간 복잡도 : 선형 탐색이기 때문에 O(NlogN)
	//////공간 복잡도 : 자바는 정렬할 때 퀵정렬 쓰므로 O(log n)
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i - 1])
				return nums[i];
		}
		
		return -1;
	} 
	// c++ 
	//	public: 
	//		int findDuplicate(vector<int>& nums){
	//			sort(nums.begin(), nums.end());
	//			for(int i = 1; i < nums.size(); i++) {
	//				if(nums[i] == nums[i - 1])
	//					return nums[i];
	//			}
	//			return -1;
	//		}
	//	
	
	////// 시간 복잡도 : 해시함수는 찾는 시간 단축이 되므로 -> O(N)
	//////공간 복잡도 : set 은 O(N)
	public int findDuplicateWithSet(int[] nums) {
		Set<Integer> seen = new HashSet<Integer>();
		for(int num : nums) {
			if(seen.contains(num))
				return num;
			seen.add(num);
		}
		return -1;
	} 
	
	// c++ 
//		public: 
//			int findDuplicateWithSet(vector<int>& nums){
//				unordered_set<int> seen;
//				for(auto &num : nums) {
//					if(seen.count(num))
//						return num;
//					seen.insert(num);
//				}
//				return -1;
	
	public int findDuplicateWithMark(int[] nums) {
		int duplicate = -1;
		for(int i = 0; i < nums.length; i++) {
			int cur = Math.abs(nums[i]);
			if(nums[cur] < 0) {
				duplicate = cur;
				for(i = 0; i < nums.length; i++) {
					nums[i] = Math.abs(nums[i]);
				}
				return duplicate;
			}
			nums[cur] *= -1;
		}
		return -1;

	} 

	//// 시간복잡도 : on, 공간 복잡도 on
	public int store(int[] nums, int cur) {
		if(cur == nums[cur])
			return cur;
		int nxt = nums[cur];
		nums[cur] = cur;
		return store(nums, nxt);
	}
	public int findDuplicateWithArrayHash(int[] nums) {
		int duplicate = -1;
		for(int i = 0; i < nums.length; i++) {
			int cur = Math.abs(nums[i]);
			if(nums[cur] < 0) {
				duplicate = cur;
				for(i = 0; i < nums.length; i++) {
					nums[i] = Math.abs(nums[i]);
				}
				return duplicate;
			}
			nums[cur] *= -1;
		}
		return -1;

	} 
	
	/// 시간 복잔도 : O(n), 공간 복잡도 : O(1)
	public int findDuplicateWithArrayHash2(int[] nums) {
		while(nums[0] != nums[nums[0]]) {
			int nxt = nums[nums[0]];
			nums[nums[0]] = nums[0];
			nums[0] = nxt;
		}
		return nums[0];
	}
//	public:
//	    int findDuplicate(vector<int>& nums) {
//	        while(nums[0] != nums[nums[0]])
//	            swap(nums[0], nums[nums[0]]);
//	        return nums[0];
//	    }
	
/////// Floyd 알고리즘
	public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners
        int tortoise = nums[0];
        int hare = nums[0];
    
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);
        
        //Find the "entrance" to the cycle
        tortoise = nums[0];
        
        while(tortoise != hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        return hare;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
