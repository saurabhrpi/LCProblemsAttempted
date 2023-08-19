class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) 
    {
        List<Boolean> ans = new ArrayList<>();
        int[] dp = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++)
        {
            dp[i + 1] = dp[i] ^ (1 <<(s.charAt(i) - 'a'));
            //dp = [0,1,3,7,.]
        }
        for(int i = 0; i < queries.length; i++)
        {
            ans.add((Integer.bitCount(dp[queries[i][0]] ^ dp[queries[i][1] + 1])/2) <= queries[i][2]);
        }
        return ans;
    }
}
