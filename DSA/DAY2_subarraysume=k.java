class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int temp=0;
        int l=0;
        int sum=0;
        while(l<nums.length){
                sum+=nums[l];
                l++;
        }

        for(int i=0;i<nums.length;i++){
            temp=sum;
            for(int r=nums.length-1;r>=i;r--){
                if(temp==k){
                    count++;
                }
                temp-=nums[r];
            }
            sum-=nums[i];
         }
        return count;
    }

}