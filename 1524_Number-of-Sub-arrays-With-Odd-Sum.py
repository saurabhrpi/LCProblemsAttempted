class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        evens,odds,total,temp = 0,0,0,0

        for i in range(len(arr)):
            if arr[i] % 2 == 1:
                temp = evens
                evens = odds
                odds = temp + 1
            else:
                evens += 1
            
            total += odds

        return total%(1000000007)
