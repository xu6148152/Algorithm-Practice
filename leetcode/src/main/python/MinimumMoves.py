class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # if len(nums) == 0:
        #     return 0
        # minNum = nums[0]
        # for i in nums:
        #     minNum = min(i, minNum)
        # res = 0
        # for i in nums:
        #     res += i - minNum
        # return res
        return sum(nums) - len(nums) * min(nums)