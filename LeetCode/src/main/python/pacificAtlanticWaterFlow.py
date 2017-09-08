class Solution(object):
    def findTerritory(self, matrix, boarder):
        territory=set(boarder)
        while boarder:
            x,y=boarder.popleft()
            for i,j in [(x-1, y), (x+1, y), (x, y-1), (x, y+1)]:
                if (i,j) not in territory and i>=0 and i<len(matrix) and j>=0 and j<len(matrix[0]) and matrix[i][j]>=matrix[x][y]:
                    territory.add((i,j))
                    boarder.append((i,j))
        return territory


    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix:
            return []

        a=self.findTerritory(matrix, collections.deque([(0,i) for i in xrange(len(matrix[0]))]+[(i,0) for i in xrange(1, len(matrix))]))
        b=self.findTerritory(matrix, collections.deque([(len(matrix)-1, i) for i in xrange(len(matrix[0]))]+[(i, len(matrix[0])-1) for i in xrange(len(matrix)-1)]))

        return list(a&b)