package comAlgo.sort;

public class Top2 {
    public static void main(String[] args) {
        int nums[]=new int[]{1,3,5,8,9,6,7,12};
        int max=0,secondMax=0;
        for(int i:nums){
            if(i>=max){
                int temp=max;
                max=i;
                secondMax=temp;
            }else{
                if(i>=secondMax){
                    secondMax=i;
                }
            }
        }
        System.out.println(max+" "+secondMax);
    }
}
