package comAlgo;

public class Top2 {
    public static void main(String[] args) {
        int nums[]=new int[]{1,9,5,3,4,2,6,8,7};
        int max=0,secondMax=0;
        for(int i:nums){
            if(i>=max){
                max=i;
            }else{
                if(i>=secondMax){
                    secondMax=i;
                }
            }
        }
        System.out.println(max+" "+secondMax);
    }
}
