package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  Created by xubinggui on 8/30/16.
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
public class PathSumII {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    private List<List<Integer>> resultList = new ArrayList<>();

    public void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
        path.push(root.val);
        if(root.left == null && root.right == null)
            if(sum == root.val) resultList.add(new ArrayList<>(path));
        if(root.left!=null) pathSumInner(root.left, sum-root.val, path);
        if(root.right!=null)pathSumInner(root.right, sum-root.val, path);
        path.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return resultList;
        Stack<Integer> path = new Stack<>();
        pathSumInner(root, sum, path);
        return resultList;
    }
}
