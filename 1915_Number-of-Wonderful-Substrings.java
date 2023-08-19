class Solution {
    public long wonderfulSubstrings(String word) 
    {
        long[] count = new long[1024];
        count[0] = 1;
        int mask = 0;
        long res = 0;
        for(int i = 0; i < word.length();i++)
        {
            char ch = word.charAt(i);
            mask ^= 1 << (ch - 'a');
            res += count[mask];
            for(int j = 0; j < 10; j++)
            {
                res += count[mask ^ (1 << j)];
            }
            ++count[mask];
        }
        return res;
    }
}
