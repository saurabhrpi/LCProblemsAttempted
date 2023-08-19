class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] moves = new int[2*limit + 1];
        int n = nums.length;
        for(int i  = 0; i < n/2; i++)
        {
            int l = nums[i];
            int r = nums[n - 1 - i];
            moves[Math.min(l,r) + 1] -= 1;
            moves[l + r] -= 1;
            if(l < limit || r < limit)
                moves[l + r + 1] += 1;
            if(Math.max(l,r) < limit)    
                moves[Math.max(l,r) + limit + 1] += 1;
        }
        int cur = n, ans = n;
        for(int i = 0; i < moves.length; i++)
        {
            cur += moves[i];
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
