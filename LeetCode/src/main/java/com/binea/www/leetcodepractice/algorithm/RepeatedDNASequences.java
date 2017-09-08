package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 25/10/2016.
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes
     * useful to identify repeated sequences within the DNA.
     *
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
     *
     * For example,
     *
     * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
     *
     * Return:
     * ["AAAAACCCCC", "CCCCCAAAAA"].
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList<>(repeated);
    }

    private static final byte[] TIDE_VALUE = new byte[26];

    static {
        TIDE_VALUE['A' - 'A'] = 0;
        TIDE_VALUE['C' - 'A'] = 1;
        TIDE_VALUE['G' - 'A'] = 2;
        TIDE_VALUE['T' - 'A'] = 3;
    }

    //for fast cleanup of other mark array
    private static final long[] dummyMrk = new long[16384];
    // mark recurrence of DNA sequence in molecule
    private static final long[] mrk = new long[16384];
    // mark if DNA sequence has been added before
    private static final long[] addMrk = new long[16384];

    public List<String> findRepeatedDnaSequences9ms(String s) {
        ArrayList<String> dupSeqs = new ArrayList<String>();

        if (s.length() >= 10) {
            //String.charAt will be slower than char array access
            char[] sChars = s.toCharArray();
            int i = 0, dnaSeqRep = 0, pos = 0;
            System.arraycopy(dummyMrk, 0, mrk, 0, dummyMrk.length);  // clear up mark
            System.arraycopy(dummyMrk, 0, addMrk, 0, dummyMrk.length); // clear up mark
            for (; i < 10; i++) {
                pos = i << 1;
                dnaSeqRep |= TIDE_VALUE[sChars[i] - 'A'] << pos;
            }
            mrk[dnaSeqRep >> 6] |= 1L << (dnaSeqRep & 0x3f);
            for (; i < sChars.length; i++) {
                dnaSeqRep >>= 2;
                dnaSeqRep |= TIDE_VALUE[sChars[i] - 'A'] << pos;
                int idx = (dnaSeqRep >> 6);
                long bitRep = 1L << (dnaSeqRep & 0x3f);
                //if the sequence has a duplicate and haven't been added before
                if ((mrk[idx] & bitRep) != 0) {
                    if ((addMrk[idx] & bitRep) == 0) {
                        addMrk[idx] |= bitRep;
                        dupSeqs.add(s.substring(i - 9, i + 1));
                    }
                } else {
                    mrk[idx] |= bitRep;
                }
            }
        }
        return dupSeqs;
    }
}
