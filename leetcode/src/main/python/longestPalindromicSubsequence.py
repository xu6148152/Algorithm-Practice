def longestPalindromeSubseq(self, s):
    if s == s[::-1]:
        return len(s)

    n = len(s)
    dp = [0 for j in range(n)]
    dp[n - 1] = 1

    for i in range(n - 1, -1, -1):
        newdp = dp[:]
        newdp[i] = 1
        for j in range(i + 1, n):
            if s[i] == s[j]:
                newdp[j] = 2 + dp[j - 1]
            else:
                newdp[j] = max(dp[j], newdp[j - 1])
        dp = newdp

    return dp[n - 1]