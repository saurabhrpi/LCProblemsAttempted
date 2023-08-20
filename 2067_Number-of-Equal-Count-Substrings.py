class Solution:
    def equalCountSubstrings(self, s: str, count: int) -> int:

        res = 0
        max_uniq = len(set(s))

        for uniq in range(1, max_uniq + 1):
            length = uniq * count            
            has_count = 0 
            freq = {}
            for i in range(len(s)):
                c = ord(s[i]) - ord('a')                
                freq[c] = freq.get(c,0) + 1                
                if freq[c] == count:
                    has_count += 1                
                if i >= length:
                    d = ord(s[i - length]) - ord('a')                    
                    freq[d] = freq.get(d,0) - 1                    
                    if freq[d] == count - 1:
                        has_count -= 1                    
                res += (1 if (has_count == uniq) else 0)

        return res
