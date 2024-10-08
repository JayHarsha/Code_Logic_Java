package LeetCode;

import java.util.*;

public class NormalQue {
    public static void main(String[] args){

//       int [] nums= {-2,1,-3,4,-1,2,1,-5,4};
//        int [] nums = {2,2,1,1,1,2,2};
//        int maj = majorityElement(nums);
//
        int[] arr = {4,4,2,4,3};
        int num = unequalTriplets(arr);
        System.out.println("Majority element : "+ num);

    }

//    public static int[] maxSubArray(int[] nums){
//        int [] subNums = null;
//        int maxSum = nums[0];
//        int currSum = nums[0]
//        int sum = 0
//        for(int i=0; i<nums.length; i++){
//            sum = sum +nums[i];
//            if(nums[i]==0){
//
//            }
//        }
//    }
    //[2,2,1,1,1,2,2]

    /**
     * returns majority element that is repeated more than n/2 times
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//            hashMap.put(num, 1 + hashMap.getOrDefault(num, 0));
//        }
//        System.out.println(hashMap);
//        for (HashMap.Entry<Integer,Integer> map: hashMap.entrySet()){
//            if(map.getValue() > (nums.length/2)){
//                return map.getKey();
//            }
//
//        }
        Arrays.sort(nums);
        return nums[(nums.length)/2];
    }

    public static int countTriples(int n) {
        int counter = 0;
        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                int num = (i*i)+(j*j);
                if(squareRoot(num) != 0 && squareRoot(num) <= n){
                    System.out.println("Square root of "+num+" is : "+squareRoot(num));
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int squareRoot(int n){
        int intSqrt = (int) Math.sqrt(n);
        if (intSqrt * intSqrt == n) {
            return intSqrt;
        }
//         for(int i=1; i<=n; i++){
//             if(i*i == n){
//                 return i;
//             }
//         }
        return 0;
    }

    //2475
    public static int unequalTriplets(int[] nums) {
        int count = 0;
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int x=j+1; x< nums.length; x++){
                    if(nums[i] != nums[j] && nums[j] != nums[x] && nums[x] != nums[i]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
