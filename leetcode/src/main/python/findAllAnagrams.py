def findAnagrams(s, p):
    dct = {}
    for c in p:
        if c in dct: dct[c] += 1
        else: dct[c] = 1

    L, res, tmpdct = len(p), [], {}

    for i in xrange(len(s)-L+1):
        if not tmpdct:                            # construct new temp dictionary
            for c in s[i:i+L]:
                if c not in tmpdct: tmpdct[c] = 1
                else: tmpdct[c] += 1
        else:                                     # update the dictionary
            tmpdct[s[i-1]] -= 1
            if s[i+L-1] in tmpdct: tmpdct[s[i+L-1]] += 1
            else: tmpdct[s[i+L-1]] = 1

        fit = True
        for k in dct.keys():
            if k not in tmpdct or dct[k] != tmpdct[k]:
                fit = False
                break
        if fit: res += i,

    return res