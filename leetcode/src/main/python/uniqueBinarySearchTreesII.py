def generateTrees(n):
    def gen_trees(s, e, memo):
        if e < s:
            return [None]
        ret_list = []
        if (s, e) in memo:
            return memo[s, e]
        for i in range(s, e + 1):
            list_left = gen_trees(s, i - 1, memo)
            list_right = gen_trees(i + 1, e, memo)
            for left in list_left:
                for right in list_right:
                    root = TreeNode(i)
                    root.left = left
                    root.right = right
                    ret_list.append(root)
        memo[s, e] = ret_list
        return ret_list

    if n == 0:
        return []
    return gen_trees(1, n, {})