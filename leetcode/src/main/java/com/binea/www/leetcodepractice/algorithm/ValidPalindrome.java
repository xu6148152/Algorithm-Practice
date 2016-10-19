package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 9/19/16.
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
public class ValidPalindrome {
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     *
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     *
     * For the purpose of this problem, we define empty string as valid palindrome.
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < s.length() - 1) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && right > 0) {
                right--;
            }
            if (Character.isLetterOrDigit(s.charAt(left))
                    && Character.isLetterOrDigit(s.charAt(right))
                    && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
