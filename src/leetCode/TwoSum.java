package leetCode;

/**
 * Created by Alex Lee on 18/6/24.
 */

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 给了我们一个数组，还有一个目标数target，让我们找到两个数字，使其和为target
 */

public class TwoSum {
    public int[] solutionNoOne(int[] intArray , int target)
    {
        HashMap<Integer,Integer> arrayMap = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<=intArray.length-1;i++)
        {
            arrayMap.put(intArray[i],i);
        }
        for(int j=0;j<intArray.length-1;j++)
        {
            if(arrayMap.containsKey(target-intArray[j])&&target-intArray[j]!=j)
            {
                result[0] = j;
                result[1] = target-intArray[j];
                break;
            }
        }
        return result;
    }

    public int[] solutionNoTwo(int[] nums, int target) {
        HashMap<Integer, Integer> intHash = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        //由于算的是两数之和 所以即使目标数在后面，算前面数时候hashMap找不到后面的值，但在查到后面的数的时候，也能找到前面的值，所以不用担心中间建立hashMap不完整
        for (int i = 0; i < nums.length; i++) {
            if (intHash.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = intHash.get(target - nums[i]);
                break;
            }
            intHash.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] intArray={1,2,4,8,9,10,26};
        int target = 6;
        TwoSum twoSum = new TwoSum();

        int[] intResult = twoSum.solutionNoOne(intArray,target);

        int[] intResult2 = twoSum.solutionNoTwo(intArray,target);

        System.out.printf(" \nsolution No 1 \n");
        for(int i=0;i<intResult.length;i++)
        {
            System.out.printf("%d,",intResult[i]);
        }
        System.out.printf(" \nsolution No 2 \n");
        for(int i=0;i<intResult2.length;i++)
        {
            System.out.printf("%d,",intResult[i]);
        }

    }
}
