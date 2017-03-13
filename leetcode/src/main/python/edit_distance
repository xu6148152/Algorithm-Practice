def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        w1 = len(word1)
        w2 = len(word2)
        r = [[ 0 for j in range(w2+1)] for i in range(w1+1)]

        for i in range(w1+1):
            for j in range(w2+1):
                if i == 0:
                    r[i][j] = j
                elif j == 0:
                    r[i][j] = i
                elif word1[i-1] == word2[j-1]:
                    r[i][j] = r[i-1][j-1]
                else:
                    r[i][j] = 1 + min(r[i][j-1], r[i-1][j], r[i-1][j-1])
        return r[w1][w2]