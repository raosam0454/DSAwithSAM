package Array.Type2_HashMapApproaches;

import java.util.Arrays;
import java.util.HashMap;
/*
LeetCode : https://leetcode.com/problems/two-sum/description/
Solution:
the question here is to find pair of indices, and the array of nums is not sorted, so this resolves to HashMap pattern,
I'll be checking the difference that we need to make up the sum, with every array element, and the moment we come
across a difference that was already seen, we've found our pair. Keep pushing the pair(<ele, position>) to hashmap otherwise.
eg trace:
target = 9
array = 2,7,11,15
traversing the array
round 1: ele = 2 position = 0
         9-2 = 7 (we have not seen this yet, hashmap is empty)
         add (2, 0) to the map
round 2: ele = 7 position = 1
         9-7 = 2, we've seen this (hashmap contains 2)
         so add index of current element to the solution array
         retrieve the index of the seen from hashmap, hm.get(2) = 0
         (1, 0)
         is the answer

 */
public class TwoSum {
    private static int[] findIndices(int[] nums, int target){
        int[] ans = {-1, -1};
        int curr;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            curr = target - nums[i];
            if(hm.containsKey(curr)){
                ans[0] = i;
                ans[1] = hm.get(curr);
                break;
            }else{
                hm.put(nums[i], i);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(findIndices(nums, target)));

    }
}
