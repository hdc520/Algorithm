package comAlgo;

public class 选择排序 {
    public static void main(String[] args) {
        int nums[]=new int[]{1,9,3,8,5,6,2,4,7};
        for(int i=0;i<nums.length;i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
            System.out.print(nums[i]+" ");
        }
    }
}
