def reconstructQueue(self, people):
    ans = []
    if people:
        people.sort(key = lambda x: (x[0], -1*x[1]), reverse = True)
        for p in people:
            ans.insert(p[1], p)
    return ans