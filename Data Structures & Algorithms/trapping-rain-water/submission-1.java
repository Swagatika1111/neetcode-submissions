class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftMax=0;
        int rightMax=0;
        int max_water=0;
        int water=0;

        while(left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(height[left]<height[right]){         
                water=Math.min(leftMax,rightMax)-height[left];

                left++;
            }
            else{           
                water=Math.min(leftMax,rightMax)-height[right];
                
                right--;
            }
            max_water=max_water+water;
        }
        return max_water;
    }
}
