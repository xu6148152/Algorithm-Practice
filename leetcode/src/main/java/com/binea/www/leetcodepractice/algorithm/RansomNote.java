package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 20/10/2016.
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

public class RansomNote {

    /**
     *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that
     *  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.
     *
     * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
     *
     * Note:
     * You may assume that both strings contain only lowercase letters.
     *
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     */
    public boolean canConstruct(String ransom, String magazine) {
        int[] array = new int[26];
        for (char c : ransom.toCharArray()) {
            array[c - 'a']--;
        }

        for (char c : magazine.toCharArray()) {
            array[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (array[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
