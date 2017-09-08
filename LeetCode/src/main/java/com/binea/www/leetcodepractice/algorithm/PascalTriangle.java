package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 21/10/2016.
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
import java.util.List;

public class PascalTriangle {
    /**
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rowResult = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rowResult.add(0, 1);
            for (int j = 1; j < rowResult.size() - 1; j++) {
                rowResult.set(j, rowResult.get(j) + rowResult.get(j + 1));
            }
            result.add(new ArrayList<>(rowResult));
        }
        return result;
    }
}
