package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//  Created by xubinggui on 8/29/16.
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
public class ReconstructItinerary {

    /**
     * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of
     * the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
     *
     * Note:
     * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For
     * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     * All airports are represented by three capital letters (IATA code).
     * You may assume all tickets form at least one valid itinerary.
     * Example 1:
     * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
     * Example 2:
     * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
     * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
     */
    public List<String> findItinerary(String[][] tickets) {
        ArrayList<String> result = new ArrayList<>();

        if (tickets == null || tickets.length == 0) {
            return result;
        }

        int total = tickets.length + 1;

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            if (map.containsKey(tickets[i][0])) {
                ArrayList<String> tmp = map.get(tickets[i][0]);
                listAdd(tickets[i][1], tmp);
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(tickets[i][1]);
                map.put(tickets[i][0], tmp);
            }
        }

        result.add("JFK");

        itineraryHelper("JFK", map, result, total, 1);

        return result;
    }

    public boolean itineraryHelper(String current, HashMap<String, ArrayList<String>> map, ArrayList<String> result, int total, int num) {

        if (num >= total) {
            return true;
        }

        if (!map.containsKey(current) || map.get(current).size() == 0) {
            return false;
        }

        ArrayList<String> curList = map.get(current);
        int i = 0;

        while (i < curList.size()) {
            String next = curList.remove(i);
            result.add(next);

            if (itineraryHelper(next, map, result, total, num + 1)) {
                return true;
            }

            result.remove(result.size() - 1);
            listAdd(next, curList);
            i++;
        }

        return false;
    }

    public void listAdd(String value, ArrayList<String> list) {
        if (list.size() == 0) {
            list.add(value);
        } else {
            int i = 0;
            while (i < list.size()) {
                if (value.compareTo(list.get(i)) <= 0) {
                    list.add(i, value);
                    return;
                }
                i++;
            }
            list.add(value);
        }
    }
}
