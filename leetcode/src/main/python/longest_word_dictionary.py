def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        heap = [(-len(word), word) for word in d]
        heapq.heapify(heap)
        while heap:
            word = heapq.heappop(heap)[1]
            it = iter(s)
            if all(c in it for c in word):
                return word
        return ''