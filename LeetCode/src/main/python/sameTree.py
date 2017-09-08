def isSameTree(p, q):
    return p and q and p.val == q.val and all(map(self.isSameTree, (p.left, q.left), (p.right, q.right))) or p is q