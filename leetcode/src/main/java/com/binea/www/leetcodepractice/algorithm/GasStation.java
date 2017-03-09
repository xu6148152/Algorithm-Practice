package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 13/12/2016.
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

public class GasStation {

    /**
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the
     * journey
     * with an empty tank at one of the gas stations.
     *
     * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length, end = 0, sum = 0;
        do {
            sum += sum > 0 ? gas[end] - cost[end++] : gas[--start] - cost[start];
        } while (start != end);
        return sum >= 0 ? start : -1;
    }
}
