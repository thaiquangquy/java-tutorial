package coding_challenge.Leetcode.TwoPointer;

// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

import java.util.Arrays;

public class Q167TwoSum2 {
    
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        Q167TwoSum2 solution = new Q167TwoSum2();
        int[] result = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
        
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = 1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                
                if (target == sum) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
            
        }

//        while (index2 < numbers.length) {
//            int sum = numbers[index1] + numbers[index2];
//
//            if (target == sum) {
//                break;
//            }
//            index1++;
//            index2++;
//        })
        
        return new int[]{++index1, ++index2};
    }
}
