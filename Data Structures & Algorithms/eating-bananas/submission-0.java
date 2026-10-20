class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int minSpeed=1;
        int maxSpeed=0;
        for(int i=0; i<n; i++){
            maxSpeed=Math.max(maxSpeed,piles[i]);
        }
        while(minSpeed<maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;
            if(canEat(piles,mid)>h){
                minSpeed=mid+1;
            }
            else{
                maxSpeed=mid;
            }
        }
        return minSpeed;
    }
    public int canEat(int[] piles, int speed){
        int hour=0;
        for(int i=0; i<piles.length; i++){
            hour+=(int)Math.ceil((double)piles[i]/speed);
        }
        return hour;
    }
}
