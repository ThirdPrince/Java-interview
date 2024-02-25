package two_points;

import java.util.Arrays;

public class RemoveDuplications {
    public static void main(String[] args) {


        int[] array = {0,1,1,2,3,5,6,6,7,8};
        System.out.println(removeDuplicates(array));
    }
    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slow = 0;
        for(int fast = 1;fast < nums.length;fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        System.out.println(Arrays.toString(nums));
        return slow +1;
    }
}
