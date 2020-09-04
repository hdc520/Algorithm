package leetcode;

public class A_88_合并两个有序数组 {
    public static void main(String[] args) {
        int nums1[]=new int[]{1,2,3,0,0,0};
        int nums2[]=new int[]{2,5,6};
        merge(nums1,3,nums2,3);
        for(int i:nums1){
            System.out.print(i+" ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int t=m+n-1;
        m--;
        n--;
        while(m>=0&&n>=0){
            if(nums1[m]<nums2[n]){
                nums1[t]=nums2[n];
                t--;
                n--;
            }else{
                nums1[t]=nums1[m];
                t--;
                m--;
            }
        }
        while(n>=0){
            nums1[t--]=nums2[n--];
        }
        while(m>=0){
            nums1[t--]=nums1[m--];
        }
    }
}
