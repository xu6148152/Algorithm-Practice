class Solution():
    def __init__(self):
        self.mPreNode = None

    def flatten(root):
        if not root:
            return
        flatten(root.right)
        flatten(root.left)

        root.right = self.mPreNode
        root.left = None
        self.mPreNode = root
