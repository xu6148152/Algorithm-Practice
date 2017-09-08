package com.binea.www.leetcodepractice;

//  Created by xubinggui on 09/01/2017.
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

import com.binea.www.leetcodepractice.algorithm.LFUCache;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LFUTest {

    LFUCache<Integer, Integer> mLFUCache;

    @Before public void setup() {
        mLFUCache = new LFUCache<>(2);
    }

    @Test public void testLFUCache() {
        mLFUCache.put(1, 1);
        mLFUCache.put(2, 2);
        //assertNotNull(mLFUCache.get(1));
        mLFUCache.put(3, 3);
        //assertNull(mLFUCache.get(2));
        //assertNotNull(mLFUCache.get(3));
        mLFUCache.put(4, 4);
        //assertNull(mLFUCache.get(1));
        assertNotNull(mLFUCache.get(3));
        assertNotNull(mLFUCache.get(4));
    }
}
